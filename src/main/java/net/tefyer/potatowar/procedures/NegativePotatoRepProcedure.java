package net.tefyer.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.tefyer.potatowar.network.PotatowarModVariables;
import net.tefyer.potatowar.PotatowarMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class NegativePotatoRepProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato")))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false
							&& (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:outlaw"))))
							&& !(entityiterator == entity)) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					} else if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false && entityiterator instanceof Player && entityiterator instanceof ServerPlayer && !(entityiterator == entity)
							&& (entityiterator.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PotatoReputation < 0) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					} else if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:boss_mob"))) && !(entityiterator == entity)) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					}
				}
			}
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human")))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false
							&& (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:outlaw"))))
							&& !(entityiterator == entity)) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					} else if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false && entityiterator instanceof Player && entityiterator instanceof ServerPlayer && !(entityiterator == entity)
							&& (entityiterator.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).HumanReputation < 0) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					} else if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:boss_mob"))) && !(entityiterator == entity)) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					}
				}
			}
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:boss_mob")))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false && (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))) && !(entityiterator == entity)
							|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))) && !(entityiterator == entity))) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					}
				}
			}
		} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:outlaw")))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity.getPersistentData().getBoolean("potatowar:HasAttackTarget") == false && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:outlaw")))) {
						entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", true);
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						PotatowarMod.queueServerWork(5, () -> {
							entity.getPersistentData().putBoolean("potatowar:HasAttackTarget", false);
						});
					}
				}
			}
		}
	}
}
