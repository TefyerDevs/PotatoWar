package net.tefyer.potatowar.api.deferredregister;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public interface IDeferredRegister {

    public void register(IEventBus modEventBus);
}
