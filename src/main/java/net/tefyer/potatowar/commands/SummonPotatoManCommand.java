package net.tefyer.potatowar.commands;

import net.minecraft.commands.Commands;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.EnumArgument;
import net.tefyer.api.item.kit.KitType;
import net.tefyer.potatowar.entity.EntityRegistry;

@Mod.EventBusSubscriber
public class SummonPotatoManCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("summonPotatoMan")
                .requires(s -> s.hasPermission(3))
                .then(Commands.argument("kitType",EnumArgument.enumArgument(KitType.class))
                .executes(context -> {

                    KitType type = context.getArgument("kitType", KitType.class);

                    EntityRegistry.POTATO_MAN.get().spawn(context.getSource().getLevel(), context.getSource().getPlayer().getOnPos(),
                            MobSpawnType.COMMAND).setKitType(type);

                    return 0;
                })));
    }
}
