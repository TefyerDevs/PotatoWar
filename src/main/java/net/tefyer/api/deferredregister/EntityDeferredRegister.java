package net.tefyer.api.deferredregister;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EntityDeferredRegister implements IDeferredRegister{
    public final DeferredRegister<EntityType<?>> ENTITY_TYPES;

    public EntityDeferredRegister(String id) {
        ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, id);
    }

    public <T extends EntityType<?>> RegistryObject<T> register(String id, Supplier<T> entity){
        return ENTITY_TYPES.register(id,entity);
    }

    @Override
    public void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}
