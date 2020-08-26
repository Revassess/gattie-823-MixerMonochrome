package com.revature.tier1;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		String toCheck = ((Long)num).toString();
		int len = toCheck.length();
		int sum = 0;
		for(int i = 0; i < len; i++) {
			sum += Math.pow(Integer.parseInt(String.valueOf(toCheck.charAt(i))), len);
		}
		if(sum == num) {
			return true;
		}
		return false;
	}
}
