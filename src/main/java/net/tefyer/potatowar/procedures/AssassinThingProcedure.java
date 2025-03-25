package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class AssassinThingProcedure {
	public static String execute() {

		String whatDidTheAssainDo = "NULL_1";
		int RandomNumber = Mth.nextInt(RandomSource.create(), 1, 10);

		switch (RandomNumber){
			case 1:whatDidTheAssainDo = "stole my socks";
			case 2:whatDidTheAssainDo = "robbed me the other day";
			case 3:whatDidTheAssainDo = "attacked another village";
			case 4:whatDidTheAssainDo = "burned someones house";
			case 5:whatDidTheAssainDo = "killed a town guard";
			case 6:whatDidTheAssainDo = "burned a rival's hideout";
			case 7:whatDidTheAssainDo = "betrayed a former ally";
			case 8:whatDidTheAssainDo = "stole a sacred relic";
			case 9:whatDidTheAssainDo = "disrupted a trade route";
			case 10:whatDidTheAssainDo = "released dangerous creatures";
			default:whatDidTheAssainDo = "NULL_2";
		}
		return whatDidTheAssainDo;
	}
}
