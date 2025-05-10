package net.tefyer.potatowar.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.api.deferredregister.EntityDeferredRegister;
import net.tefyer.potatowar.entity.custom.PotatoManEntity;

import static net.tefyer.potatowar.PotatowarMod.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    public static final EntityDeferredRegister ENTITY_TYPES = new EntityDeferredRegister(MODID);


    public static final RegistryObject<EntityType<PotatoManEntity>> POTATO_MAN = register("potato_man",
            EntityType.Builder.<PotatoManEntity>of(PotatoManEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoManEntity::new)
                    .sized(0.6f, 1.8f));


    private static <T extends Entity> RegistryObject<EntityType<T>> register(String id, EntityType.Builder<T> entityTypeBuilder) {
        return ENTITY_TYPES.register(id, () ->entityTypeBuilder.build(id));
    }
    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }

    public static void registerEntities(IEventBus modEventBus) {


        // register entities here:


        register(modEventBus);
        // ^ cannot add new entities after this
    }


    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PotatoManEntity.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(POTATO_MAN.get(), PotatoManEntity.createAttributes().build());
    }
}
