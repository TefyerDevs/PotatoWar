
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.potatowar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.potatowar.PotatowarMod;

public class PotatowarModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PotatowarMod.MODID);
	public static final RegistryObject<SoundEvent> SWEEDEN = REGISTRY.register("sweeden", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "sweeden")));
	public static final RegistryObject<SoundEvent> MICE_ON_VENUS = REGISTRY.register("mice_on_venus", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "mice_on_venus")));
	public static final RegistryObject<SoundEvent> ARIA_MATH = REGISTRY.register("aria_math", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "aria_math")));
	public static final RegistryObject<SoundEvent> HAGGSTROM = REGISTRY.register("haggstrom", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "haggstrom")));
	public static final RegistryObject<SoundEvent> LIVING_MICE = REGISTRY.register("living_mice", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "living_mice")));
	public static final RegistryObject<SoundEvent> BOSSMUSIC1 = REGISTRY.register("bossmusic1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "bossmusic1")));
	public static final RegistryObject<SoundEvent> BOSS4 = REGISTRY.register("boss4", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "boss4")));
	public static final RegistryObject<SoundEvent> BOSS5 = REGISTRY.register("boss5", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "boss5")));
	public static final RegistryObject<SoundEvent> CRPTPLAYERAMBIENT = REGISTRY.register("crptplayerambient", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "crptplayerambient")));
	public static final RegistryObject<SoundEvent> CRPTPLAYERHURT = REGISTRY.register("crptplayerhurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "crptplayerhurt")));
	public static final RegistryObject<SoundEvent> CRTPPLAYERBOSSMUSIC = REGISTRY.register("crtpplayerbossmusic", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("potatowar", "crtpplayerbossmusic")));
}
