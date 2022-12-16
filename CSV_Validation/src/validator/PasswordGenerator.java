package validator;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PasswordGenerator {
	
	static String alfabeto = "abcdefghijklmnopqrstuvwxyz";
	static String alfabetoMay = alfabeto.toUpperCase();
	static String digits = "1234567890";
	static Random numAleatorio = new Random(); 
	static int maxLon = 12;
	static int minLon = 8;
	static int longitud = numAleatorio.nextInt(maxLon - minLon +1) + minLon;
	
	static int alfabetoLength = alfabeto.length();
	static int digitsLength = digits.length();
	
	public static String getPassword() {
		String password = "";
		String passwordArray[] = new String[longitud];
		
		boolean hasNum = false;
		boolean hasMayus = false;
		boolean hasMinus = false;
		
		while (!hasNum || !hasMayus || !hasMinus) {
			for (int i = 0; i<passwordArray.length; i++) {
				int selectChar = selectChar();
				if (selectChar == 0) {
					passwordArray[i] = String.valueOf(randomDigit());
					hasNum = true;
				}
				else if (selectChar == 1) {
					hasMinus = true;
					passwordArray[i] = String.valueOf(randomMinus());
				}
				
				else if (selectChar == 2) {
					hasMayus = true;
					passwordArray[i] = String.valueOf(randomMayus());
				}
				password = password + passwordArray[i];
			}
		}
		
		
		
		return password;
		
	}
	
	public static char randomDigit() {
		return digits.charAt(numAleatorio.nextInt(digitsLength));
	}
	
	public static char randomMinus() {
		return alfabeto.charAt(numAleatorio.nextInt(alfabetoLength));
	}
	
	public static char randomMayus() {
		return alfabetoMay.charAt(numAleatorio.nextInt(alfabetoLength));
	}
	public static int selectChar() {
		return numAleatorio.nextInt(3);
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(getPassword());
	}

	
	
	
	
	
}
