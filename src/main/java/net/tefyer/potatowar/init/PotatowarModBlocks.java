
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.tefyer.potatowar.block.*;
import net.tefyer.potatowar.PotatowarMod;

public class PotatowarModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PotatowarMod.MODID);

    public static final RegistryObject<Block> LOG_BUILDING = REGISTRY.register("log_building", ModFlammableRotatedPillarBlock::new);
	public static final RegistryObject<Block> FORGOTTEN_WORLDS_PORTAL = REGISTRY.register("forgotten_worlds_portal", () -> new ForgottenWorldsPortalBlock());
	public static final RegistryObject<Block> DIGITAL_BLOCK = REGISTRY.register("digital_block", () -> new DigitalBlockBlock());
	public static final RegistryObject<Block> DIGITAL_WORLD_PORTAL = REGISTRY.register("digital_world_portal", () -> new DigitalWorldPortalBlock());
	public static final RegistryObject<Block> ODD_POTATO_PLANT_STG_1 = REGISTRY.register("odd_potato_plant_stg_1", () -> new OddPotatoPlantStg1Block());
	public static final RegistryObject<Block> ODDPOTATO_2 = REGISTRY.register("oddpotato_2", () -> new Oddpotato2Block());
	public static final RegistryObject<Block> ODDPOTATO_3 = REGISTRY.register("oddpotato_3", () -> new Oddpotato3Block());
	public static final RegistryObject<Block> ODDPOTATO_4 = REGISTRY.register("oddpotato_4", () -> new Oddpotato4Block());
	public static final RegistryObject<Block> POTATO_BLOCK = REGISTRY.register("potato_block", () -> new PotatoBlockBlock());
	public static final RegistryObject<Block> COMPRESSER_BLOCK = REGISTRY.register("compresser_block", () -> new CompresserBlock());

    public static final RegistryObject<Block> RUBBER_LOG = REGISTRY.register("rubber_log", ModFlammableRotatedPillarBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
