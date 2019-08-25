package com.itwine.mcm.email;

import java.security.SecureRandom;


public class PasswordGenerator {

	 private static SecureRandom random = new SecureRandom();


	    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/";
	    public static String generatePassword(int len) {
	    String result = "";
	    for (int i = 0; i < len; i++) {
	        int index = random.nextInt(characters.length());
	        result += characters.charAt(index);
	    }
	    return result;
	    }

}
