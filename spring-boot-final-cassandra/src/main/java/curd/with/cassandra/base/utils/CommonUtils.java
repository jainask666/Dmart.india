package curd.with.cassandra.base.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;

	}

	
	
	Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
	public static boolean check(String name) {
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
			Matcher matcher = pattern.matcher(name);
			boolean isStringContainsSpecialCharacter = matcher.find();
			return isStringContainsSpecialCharacter;
		} 
	
}
