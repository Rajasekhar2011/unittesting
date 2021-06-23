package com.junit.course;

public class StringHelper {
	
	public String truncateAInFirstTwoPositions(String str) {
		if(str.length() <=2) {
			return str.replace("A", "");
		}
		 return str.substring(0,2).replace("A", "").concat(str.substring(2));
	}
	public boolean areFirstAndLastTwoCharactersTheSame(String str) {
		if(str.length()<=1) return false;
		if(str.length()==2) return true;
		
		String firstTwoChars = str.substring(0,2);
		String lastTwoChars = str.substring(str.length()-2);
		return firstTwoChars.equals(lastTwoChars);
	}

}
