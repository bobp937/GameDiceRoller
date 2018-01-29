package com.pierce.bob.dice;

import java.util.Calendar;
import java.util.Random;


public class DiceRoller {
	public static Random random = new Random(Calendar.getInstance().getTimeInMillis());
	private static DiceFormatter diceFormatter = new DiceFormatter();
	
	public static String roll(int dieSides){
		return roll(dieSides,0);
	}

	public static String roll(int dieSides, short adjustment){
		return diceFormatter.format(dieSides,random.nextInt(dieSides) + 1 + adjustment);
	}

	public static String roll(int dieSides, int diceCount){
		return roll(dieSides, (short)0, diceCount);
	}
	
	public static String roll(int dieSides, short adjustment, int diceCount){
		int result[] = new int[diceCount];
		
		for (int i = 0; i < diceCount; i++){
			result[i] = random.nextInt(dieSides) + 1 + adjustment;
		}
		
		
		return diceFormatter.format(dieSides,result);
	}
}
