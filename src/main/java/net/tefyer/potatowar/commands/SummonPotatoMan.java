package net.tefyer.potatowar.commands;

import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.EnumArgument;
import net.tefyer.api.item.kit.KitType;

@Mod.EventBusSubscriber
public class SummonPotatoMan {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("summonPotatoMan")
                .requires(s -> s.hasPermission(3))
                .then(Commands.argument("kitType",EnumArgument.enumArgument(KitType.class))
                .executes(context -> {

                    KitType type = context.getArgument("kitType", KitType.class);

                    

                    return 0;
                })));
    }
}
