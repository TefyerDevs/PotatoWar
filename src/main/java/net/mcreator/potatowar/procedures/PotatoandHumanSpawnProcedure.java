package net.mcreator.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PotatoandHumanSpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato")))) {
			if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:leader")))) {
				entity.getPersistentData().putDouble("potatowar:LeaderID", 0);
			}
			entity.getPersistentData().putDouble("potatowar:ModeID", 3);
		}
	}
}
