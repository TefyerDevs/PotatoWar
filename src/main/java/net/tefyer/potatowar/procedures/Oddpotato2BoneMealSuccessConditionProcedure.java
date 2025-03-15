package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class Oddpotato2BoneMealSuccessConditionProcedure {
	public static boolean execute() {
		return 1 == Mth.nextInt(RandomSource.create(), 1, 3);
	}
}
