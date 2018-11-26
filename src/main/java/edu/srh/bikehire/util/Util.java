package edu.srh.bikehire.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	public static boolean isValidEmailAddress(String pEmailAddress)
	{
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pEmailAddress);
		return matcher.matches();
	}
}
