package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class CorruptedplayerEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		double NewX = 0;
		double NewY = 0;
		double NewZ = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
				NewX = entity.getX() + Mth.nextInt(RandomSource.create(), 1, 3);
			} else {
				NewX = entity.getX() - Mth.nextInt(RandomSource.create(), 1, 3);
			}
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
				NewZ = entity.getZ() + Mth.nextInt(RandomSource.create(), 1, 3);
			} else {
				NewZ = entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 3);
			}
			if (!((world.getBlockState(BlockPos.containing(NewX, y, NewZ))).getBlock() == Blocks.AIR)) {
				{
					Entity _ent = entity;
					_ent.teleportTo(NewX, y, NewZ);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(NewX, y, NewZ, _ent.getYRot(), _ent.getXRot());
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 80, 1, false, false));
		}
	}
}
