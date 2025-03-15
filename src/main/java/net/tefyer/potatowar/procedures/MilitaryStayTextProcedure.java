package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class MilitaryStayTextProcedure {
	public static String execute() {
		double RandomNum = 0;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 1);
		if (RandomNum == 1) {
			return StayTextCluster1Procedure.execute();
		}
		return "Error#9";
	}
}
