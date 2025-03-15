package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class AssassinThingProcedure {
	public static String execute() {
		double RandomNumber = 0;
		String thing = "";
		RandomNumber = Mth.nextInt(RandomSource.create(), 1, 10);
		if (RandomNumber == 1) {
			thing = "stole my socks";
		} else if (RandomNumber == 2) {
			thing = "robbed me the other day";
		} else if (RandomNumber == 3) {
			thing = "attacked another village";
		} else if (RandomNumber == 4) {
			thing = "burned someones house";
		} else if (RandomNumber == 5) {
			thing = "killed a town guard";
		} else if (RandomNumber == 6) {
			thing = "burned a rival's hideout";
		} else if (RandomNumber == 7) {
			thing = "betrayed a former ally";
		} else if (RandomNumber == 8) {
			thing = "stole a sacred relic";
		} else if (RandomNumber == 9) {
			thing = "disrupted a trade route";
		} else if (RandomNumber == 10) {
			thing = "released dangerous creatures";
		}
		return thing;
	}
}
