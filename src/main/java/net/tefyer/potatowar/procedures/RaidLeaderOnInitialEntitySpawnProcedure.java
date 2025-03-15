package net.tefyer.potatowar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.Comparator;

public class RaidLeaderOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double RaiderCount = 0;
		RaiderCount = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
					entityiterator.getPersistentData().putBoolean("potatowar:InRaidPosition", false);
					entityiterator.getPersistentData().putBoolean("potatowar:Raider", true);
					entityiterator.getPersistentData().putBoolean("potatowar:OutsideRaidPosition", true);
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600, 1));
					RaiderCount = RaiderCount + 1;
				}
			}
		}
		entity.getPersistentData().putBoolean("potatowar:InRaidPosition", false);
		entity.getPersistentData().putBoolean("potatowar:Raider", true);
		entity.getPersistentData().putBoolean("potatowar:OutsideRaidPosition", true);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600, 1));
		RaiderCount = RaiderCount + 1;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Raider count: " + RaiderCount)), false);
	}
}
