package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.potatowar.network.PotatowarModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetMigrationProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		PotatowarModVariables.WorldVariables.get(world).MigrationX = DoubleArgumentType.getDouble(arguments, "MigrationX");
		PotatowarModVariables.WorldVariables.get(world).syncData(world);
	}
}
