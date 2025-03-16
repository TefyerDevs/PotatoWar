package net.tefyer.potatowar.generator;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.generator.custom.ItemModelGenerator;

@Mod.EventBusSubscriber(modid = PotatowarMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event){
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        PackOutput packOutput = dataGenerator.getPackOutput();

        dataGenerator.addProvider(event.includeClient(), new ItemModelGenerator(packOutput,fileHelper));
    }
}
