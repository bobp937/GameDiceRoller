package com.pierce.bob.dice;

import java.util.Arrays;

class DiceFormatter {
	String format(int dieSides, int roll){
		return "d" + dieSides + " rolled " + roll;
	}

	String format(int dieSides, int rolls[]){
		int sum = 0;
		for (int roll : rolls){
			sum += roll;
		}
		return "d" + dieSides + " rolled " + Arrays.toString(rolls) + " = " + sum;
	}
}
