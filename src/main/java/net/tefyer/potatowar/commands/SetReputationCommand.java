package net.tefyer.potatowar.commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.synchronization.SuggestionProviders;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.EnumArgument;
import net.tefyer.api.CompoundTagIds;
import net.tefyer.api.entity.utils.EntityUtils;
import net.tefyer.api.item.kit.KitType;

import java.util.Objects;

@Mod.EventBusSubscriber
public class SetReputationCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("setPotatoReputation")
                .requires(s -> s.hasPermission(3))
                .then(Commands.argument("type",StringArgumentType.string()).suggests(reputation).executes(context -> {
                            String type = StringArgumentType.getString(context,"type");
                            ServerPlayer player = context.getSource().getPlayer();
                            if(Objects.equals(type, "get")){
                                EntityUtils.sendMessage(player,
                                        Component.translatable("chat.potatowar.human_rep").append(": "+
                                                String.valueOf(EntityUtils.getPotatoReputation(player))));
                                return 0;
                            }
                            return 0;
                        })
                        .then(Commands.argument("num", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    String type = StringArgumentType.getString(context,"type");
                                    double num = DoubleArgumentType.getDouble(context,"num");
                                    ServerPlayer player = context.getSource().getPlayer();

                                    switch (type){
                                        case "add": EntityUtils.addPotatoReputation(player, (int) num);
                                        case "sub": EntityUtils.subPotatoReputation(player, (int) num);
                                        case "set": EntityUtils.setPotatoReputation(player, num);
                                    }
                                    return 0;
                                }))));
        event.getDispatcher().register(Commands.literal("setHumanReputation")
                .requires(s -> s.hasPermission(3))
                .then(Commands.argument("type",StringArgumentType.string()).suggests(reputation).executes(context -> {
                            String type = StringArgumentType.getString(context,"type");
                            ServerPlayer player = context.getSource().getPlayer();
                            if(Objects.equals(type, "get")){
                                EntityUtils.sendMessage(player,
                                        Component.translatable("chat.potatowar.human_rep").append(": "+
                                                String.valueOf(EntityUtils.getHumanReputation(player))));
                                return 0;
                            }
                            return 0;
                        })
                        .then(Commands.argument("num", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    String type = StringArgumentType.getString(context,"type");
                                    double num = DoubleArgumentType.getDouble(context,"num");
                                    ServerPlayer player = context.getSource().getPlayer();

                                    switch (type){
                                        case "add": EntityUtils.addHumanReputation(player, (int) num);
                                        case "sub": EntityUtils.subHumanReputation(player, (int) num);
                                        case "set": EntityUtils.setHumanReputation(player, num);
                                    }
                                    return 0;
                                }))));

    }

    public static final SuggestionProvider<CommandSourceStack> reputation =
            (context, builder) -> {
        builder.suggest("add");
        builder.suggest("sub");
        builder.suggest("set");
        builder.suggest("get");
        return builder.buildFuture();
    };
}
