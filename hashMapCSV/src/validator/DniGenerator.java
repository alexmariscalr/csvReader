package validator;

import java.util.Random;

public class DniGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDNI());

	}
	
	public static String getDNI() {
		String dni = "";
		String numeroDNI = "";
		
		for (int i=0 ; i<8; i++) {
			Random numAleatorio = new Random();
			numeroDNI += String.valueOf(numAleatorio.nextInt(10));
			
		}
		
		dni += numeroDNI + getLetra(Integer.valueOf(numeroDNI));
		return dni;
	}
	
	public static String getLetra(int numeroDNI) {
		String letra = "";
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int indexLetra = numeroDNI%23;
		letra = String.valueOf(letras.charAt(indexLetra));		
		
		return letra;
	}

}
