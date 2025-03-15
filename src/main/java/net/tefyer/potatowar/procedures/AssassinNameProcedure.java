package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class AssassinNameProcedure {
	public static String execute() {
		double randomnumber = 0;
		String AssassinName = "";
		String lastname = "";
		randomnumber = Mth.nextInt(RandomSource.create(), 1, 12);
		if (randomnumber == 12) {
			AssassinName = "Phantomblade";
		} else if (randomnumber == 11) {
			AssassinName = "Nightshade";
		} else if (randomnumber == 10) {
			AssassinName = "Silentstrike";
		} else if (randomnumber == 9) {
			AssassinName = "Venomcloak";
		} else if (randomnumber == 8) {
			AssassinName = "Deathshroud";
		} else if (randomnumber == 7) {
			AssassinName = "Crimsonflash";
		} else if (randomnumber == 6) {
			AssassinName = "Bulletcrash";
		} else if (randomnumber == 5) {
			AssassinName = "Bob";
		} else if (randomnumber == 4) {
			AssassinName = "Ironkill";
		} else if (randomnumber == 3) {
			AssassinName = "Hollowshot";
		} else if (randomnumber == 2) {
			AssassinName = "Blacksaw";
		} else if (randomnumber == 1) {
			AssassinName = "Darkbeat";
		}
		randomnumber = Mth.nextInt(RandomSource.create(), 1, 12);
		if (randomnumber == 12) {
			lastname = "The Crimson Viper";
		} else if (randomnumber == 11) {
			lastname = "Veiled Marauder";
		} else if (randomnumber == 10) {
			lastname = "The Lurking Doom";
		} else if (randomnumber == 9) {
			lastname = "Netherblade";
		} else if (randomnumber == 8) {
			lastname = "Obsidian Wraith";
		} else if (randomnumber == 7) {
			lastname = "Veil of Darkness";
		} else if (randomnumber == 6) {
			lastname = "Shadeborne";
		} else if (randomnumber == 5) {
			lastname = "The Destroyer";
		} else if (randomnumber == 4) {
			lastname = "Abyssal Executioner";
		} else if (randomnumber == 3) {
			lastname = "The Enigma";
		} else if (randomnumber == 2) {
			lastname = "Cloak of Doom";
		} else if (randomnumber == 1) {
			lastname = "Whispering Death";
		}
		return AssassinName + "" + (" " + lastname);
	}
}
