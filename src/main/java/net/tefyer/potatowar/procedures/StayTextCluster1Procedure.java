package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class StayTextCluster1Procedure {
	public static String execute() {
		double RandomNum = 0;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 10);
		if (RandomNum == 10) {
			return "Holding our ground, Commander.";
		} else if (RandomNum == 9) {
			return "We'll stand right here.";
		} else if (RandomNum == 8) {
			return "Putting the brakes on.";
		} else if (RandomNum == 7) {
			return "No more following for now.";
		} else if (RandomNum == 6) {
			return "Coming to a stop, sir.";
		} else if (RandomNum == 5) {
			return "We'll stay put.";
		} else if (RandomNum == 4) {
			return "Taking a breather.";
		} else if (RandomNum == 3) {
			return "Easing up on the follow.";
		} else if (RandomNum == 2) {
			return "Stopping in our tracks.";
		} else if (RandomNum == 1) {
			return "Parking it right here.";
		}
		return RandomNum + " Error#8 your special :)";
	}
}
