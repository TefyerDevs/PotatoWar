package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.potatowar.network.PotatowarModVariables;
import net.mcreator.potatowar.init.PotatowarModMobEffects;
import net.mcreator.potatowar.init.PotatowarModEntities;
import net.mcreator.potatowar.PotatowarMod;

public class DigitalWorldPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (PotatowarModVariables.MapVariables.get(world).DigiArenaSpawned == false && PotatowarModVariables.MapVariables.get(world).SpawnPrototypeCooldown == false) {
			entity.getPersistentData().putDouble("potatowar:DigitalEntranceX", x);
			entity.getPersistentData().putDouble("potatowar:DigitalEntranceY", y);
			entity.getPersistentData().putDouble("potatowar:DigitalEntranceZ", z);
			entity.getPersistentData().putBoolean("potatowar:IndigiWorld", true);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PotatowarModMobEffects.BUILDERS_FATIUGE.get(), 200000, 1, false, false));
			PotatowarModVariables.MapVariables.get(world).DigiArenaSpawned = true;
			PotatowarModVariables.MapVariables.get(world).syncData(world);
			PotatowarModVariables.MapVariables.get(world).SpawnPrototypeCooldown = true;
			PotatowarModVariables.MapVariables.get(world).syncData(world);
			entity.getPersistentData().putBoolean("potatowar:HasDigitalAssistant", false);
			{
				Entity _ent = entity;
				_ent.teleportTo(3, 81, 3);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(3, 81, 3, _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("potatowar", "fakeworld"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(0, 80, 0), new BlockPos(0, 80, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.UNKNOWN.get().spawn(_level, new BlockPos(22, 81, 12), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			PotatowarMod.queueServerWork(20, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("???: Welcome to the digital world!"), false);
				PotatowarMod.queueServerWork(40, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("???: Do you want to be friends?"), false);
					PotatowarMod.queueServerWork(40, () -> {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("???: It gets lonely here"), false);
						PotatowarMod.queueServerWork(40, () -> {
							if (!world.isClientSide() && world.getServer() != null)
								world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("???: But hey now your here!"), false);
						});
					});
				});
				PotatowarMod.queueServerWork(1200, () -> {
					PotatowarModVariables.MapVariables.get(world).SpawnPrototypeCooldown = true;
					PotatowarModVariables.MapVariables.get(world).syncData(world);
				});
			});
		}
	}
}
