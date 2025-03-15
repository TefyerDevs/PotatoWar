
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.potatowar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.potatowar.potion.PanicMobEffect;
import net.mcreator.potatowar.potion.BuildersFatiugeMobEffect;
import net.mcreator.potatowar.PotatowarMod;

public class PotatowarModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PotatowarMod.MODID);
	public static final RegistryObject<MobEffect> BUILDERS_FATIUGE = REGISTRY.register("builders_fatiuge", () -> new BuildersFatiugeMobEffect());
	public static final RegistryObject<MobEffect> PANIC = REGISTRY.register("panic", () -> new PanicMobEffect());
}
