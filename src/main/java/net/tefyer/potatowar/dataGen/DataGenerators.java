package net.tefyer.potatowar.dataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.dataGen.custom.ItemModelGenerator;
import net.tefyer.potatowar.dataGen.custom.ModBlockTagGenerator;
import net.tefyer.potatowar.dataGen.custom.ModItemTagGenerator;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = PotatowarMod.MODID, value = Dist.CLIENT , bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void genAllData(GatherDataEvent gatherDataEvent){
        DataGenerator generator = gatherDataEvent.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = gatherDataEvent.getLookupProvider();

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(gatherDataEvent.includeServer(),
                new ModBlockTagGenerator(packOutput,lookupProvider, existingFileHelper));
        generator.addProvider(gatherDataEvent.includeServer(), new ModItemTagGenerator(packOutput,lookupProvider,
                blockTagGenerator.contentsGetter(),existingFileHelper));

        generator.addProvider(gatherDataEvent.includeClient(),
                new ItemModelGenerator(packOutput,existingFileHelper));

    }
}
