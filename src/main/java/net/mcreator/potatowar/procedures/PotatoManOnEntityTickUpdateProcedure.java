package net.mcreator.potatowar.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public class PotatoManOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if (entity.getX() >= entity.getPersistentData().getDouble("HomeX") + 64 || entity.getX() <= entity.getPersistentData().getDouble("HomeX") - 64 || entity.getZ() <= entity.getPersistentData().getDouble("HomeZ") - 64
				|| entity.getZ() >= entity.getPersistentData().getDouble("HomeZ") + 64) {
			entity.getPersistentData().putBoolean("potatowar:OutsideTownPosition", true);
		}
		if (entity.getPersistentData().getBoolean("potatowar:outsidePosition") == true) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("HomeX")), y, (entity.getPersistentData().getDouble("HomeZ")), 1.2);
		}
		if (entity.getX() >= entity.getPersistentData().getDouble("HomeX") + 8 || entity.getX() <= entity.getPersistentData().getDouble("HomeX") - 8 || entity.getZ() <= entity.getPersistentData().getDouble("HomeZ") - 8
				|| entity.getZ() >= entity.getPersistentData().getDouble("HomeZ") + 8) {
			entity.getPersistentData().putBoolean("potatowar:OutsideTownPosition", false);
		}
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entity.getPersistentData().getString("potatowar:QuestHolder")).equals(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString())) {
				if (!(entityiterator.getPersistentData().getDouble("potatowar:CivilianID") == entity.getPersistentData().getDouble("potatowar:CivilianID"))) {
					entity.getPersistentData().putBoolean("potatowar:QuestTaken", false);
				}
			}
		}
	}
}
