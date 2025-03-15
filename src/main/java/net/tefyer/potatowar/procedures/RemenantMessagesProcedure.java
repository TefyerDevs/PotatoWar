package net.tefyer.potatowar.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class RemenantMessagesProcedure {
	public static String execute() {
		double randomNumber = 0;
		String Message = "";
		randomNumber = Mth.nextInt(RandomSource.create(), 1, 15);
		if (randomNumber == 1) {
			Message = "Do you remember.";
		} else if (randomNumber == 2) {
			Message = "I didn't forget.";
		} else if (randomNumber == 3) {
			Message = "Do you know who I am.";
		} else if (randomNumber == 4) {
			Message = "You were my best friend";
		} else if (randomNumber == 5) {
			Message = "You were gone for so long.";
		} else if (randomNumber == 6) {
			Message = "We were friends.";
		} else if (randomNumber == 7) {
			Message = "What happened.";
		} else if (randomNumber == 8) {
			Message = "You forgot about me,";
		} else if (randomNumber == 9) {
			Message = "You left me.";
		} else if (randomNumber == 10) {
			Message = "Why did you leave.";
		} else if (randomNumber == 11) {
			Message = "What did I do wrong.";
		} else if (randomNumber == 12) {
			Message = "Please come back.";
		} else if (randomNumber == 13) {
			Message = "I still remember you.";
		} else if (randomNumber == 14) {
			Message = "How many years has it been.";
		} else if (randomNumber == 15) {
			Message = "Its been too long.";
		}
		return Message;
	}
}
