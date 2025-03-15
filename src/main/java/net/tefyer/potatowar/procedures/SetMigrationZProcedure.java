package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.tefyer.potatowar.network.PotatowarModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetMigrationZProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		PotatowarModVariables.WorldVariables.get(world).MigrationZ = DoubleArgumentType.getDouble(arguments, "MigrationZ");
		PotatowarModVariables.WorldVariables.get(world).syncData(world);
	}
}
