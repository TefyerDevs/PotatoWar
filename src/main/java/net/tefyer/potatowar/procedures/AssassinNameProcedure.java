package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class AssassinNameProcedure {
	public static String execute() {
		int randomnumber = Mth.nextInt(RandomSource.create(), 1, 12);;
		String assassinname;
		String lastname;


		switch (randomnumber){
			case 1: assassinname = "Darkbeat";
			case 2: assassinname = "Blacksaw";
			case 3: assassinname = "Hollowshot";
			case 4: assassinname = "Ironkill";
			case 5: assassinname = "Bob";
			case 6: assassinname = "Bulletcrash";
			case 7: assassinname = "Crimsonflash";
			case 8: assassinname = "Deathshroud";
			case 9: assassinname = "Venomcloak";
			case 10: assassinname = "Silentstrike";
			case 11: assassinname = "Nightshade";
			case 12: assassinname = "Phantomblade";
			default: assassinname = "NULL";
		}
		randomnumber = Mth.nextInt(RandomSource.create(), 1, 12);

		switch (randomnumber){
			case 1: lastname = "Whispering Death";
			case 2: lastname = "Cloak of Doom";
			case 3: lastname = "The Enigma";
			case 4: lastname = "Abyssal Executioner";
			case 5: lastname = "The Destroyer";
			case 6: lastname = "Shadeborne";
			case 7: lastname = "Veil of Darkness";
			case 8: lastname = "Obsidian Wraith";
			case 9: lastname = "Netherblade";
			case 10: lastname = "The Lurking Doom";
			case 11: lastname = "Veiled Marauder";
			case 12: lastname = "The Crimson Viper";
			default: lastname = "NULL";
		}
		return assassinname + " " + lastname;
	}
}
