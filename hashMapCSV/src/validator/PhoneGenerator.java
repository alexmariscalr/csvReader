package validator;

import java.util.Random;

public class PhoneGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPhoneNumber());
	}
	
	public static String getPhoneNumber() {
		String number = "6";
		Random numAleatorio = new Random();
		for(int i=0; i<8; i++) {
			number += numAleatorio.nextInt(10);
		}
		
		return number;
	}
	
	

}
