package net.tefyer.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.tefyer.potatowar.network.PotatowarModVariables;
import net.tefyer.potatowar.init.PotatowarModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BeginMigrationProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getY(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double y, Entity entity) {
		execute(null, world, y, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))))
				&& world.getLevelData().getGameRules().getBoolean(PotatowarModGameRules.GREAT_MIGRATION) == true) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo(PotatowarModVariables.WorldVariables.get(world).MigrationX, y, PotatowarModVariables.WorldVariables.get(world).MigrationZ, 1);
		}
	}
}
