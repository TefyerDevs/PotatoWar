package net.mcreator.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class HoldPositionCluster1Procedure {
	public static String execute() {
		double RandomNum = 0;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 10);
		if (RandomNum == 10) {
			return "We're digging in right here.";
		} else if (RandomNum == 9) {
			return "Holding this spot, sir.";
		} else if (RandomNum == 8) {
			return "Taking a defensive stance.";
		} else if (RandomNum == 7) {
			return "Guarding this position.";
		} else if (RandomNum == 6) {
			return "Digging our heels in.";
		} else if (RandomNum == 5) {
			return "Securing this area.";
		} else if (RandomNum == 4) {
			return "We'll stand our ground.";
		} else if (RandomNum == 3) {
			return "Holding tight, Commander.";
		} else if (RandomNum == 2) {
			return "Planting ourselves here.";
		} else if (RandomNum == 1) {
			return "Standing firm, sir.";
		}
		return RandomNum + " Error#8 your not special :)";
	}
}
