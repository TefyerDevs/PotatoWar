
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotatowarModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> GREAT_MIGRATION =
			GameRules.register("greatMigration", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));
}
