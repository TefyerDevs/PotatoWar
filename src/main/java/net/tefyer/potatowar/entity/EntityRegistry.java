package net.tefyer.potatowar.entity;

import net.minecraftforge.eventbus.api.IEventBus;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.api.deferredregister.EntityDeferredRegister;

public class EntityRegistry {
    public static final EntityDeferredRegister ENTITY_TYPES = new EntityDeferredRegister(PotatowarMod.MODID);

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }

    public static void registerEntities(IEventBus modEventBus) {


        // register entities here:


        register(modEventBus);
        // ^ cannot add new entities after this
    }
}
