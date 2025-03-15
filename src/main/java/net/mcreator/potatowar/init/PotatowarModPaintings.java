
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.potatowar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.potatowar.PotatowarMod;

public class PotatowarModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, PotatowarMod.MODID);
	public static final RegistryObject<PaintingVariant> FUZZY = REGISTRY.register("fuzzy", () -> new PaintingVariant(16, 16));
}
