package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.BlockPos;

public class DigitalAssistantRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double portalX = 0;
		double portalY = 0;
		double portalZ = 0;
		if (entity.getPersistentData().getBoolean("potatowar:IndigiWorld") == true) {
			entity.getPersistentData().putBoolean("potatowar:IndigiWorld", false);
			if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
				ResourceKey<Level> destinationType = Level.OVERWORLD;
				if (_player.level().dimension() == destinationType)
					return;
				ServerLevel nextLevel = _player.server.getLevel(destinationType);
				if (nextLevel != null) {
					_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
					_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
					_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
					for (MobEffectInstance _effectinstance : _player.getActiveEffects())
						_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
					_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("potatowar:DigitalEntranceX")), (entity.getPersistentData().getDouble("potatowar:DigitalEntranceY")), (entity.getPersistentData().getDouble("potatowar:DigitalEntranceZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("potatowar:DigitalEntranceX")), (entity.getPersistentData().getDouble("potatowar:DigitalEntranceY")),
							(entity.getPersistentData().getDouble("potatowar:DigitalEntranceZ")), _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
