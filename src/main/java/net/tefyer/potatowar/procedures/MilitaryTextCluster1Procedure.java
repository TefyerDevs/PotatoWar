package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class MilitaryTextCluster1Procedure {
	public static String execute() {
		double RandomNum = 0;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 10);
		if (RandomNum == 1) {
			return "We're with you, sir.";
		} else if (RandomNum == 2) {
			return "Following your lead.";
		} else if (RandomNum == 3) {
			return "Affirmative, Commander.";
		} else if (RandomNum == 4) {
			return "At your command!";
		} else if (RandomNum == 5) {
			return "Ready and willing!";
		} else if (RandomNum == 6) {
			return "Lead the way, Commander!";
		} else if (RandomNum == 7) {
			return "On your six, Commander.";
		} else if (RandomNum == 8) {
			return "Following orders.";
		} else if (RandomNum == 9) {
			return "Securing your flank.";
		} else if (RandomNum == 10) {
			return "In formation, awaiting orders.";
		}
		return "Error#8";
	}
}
