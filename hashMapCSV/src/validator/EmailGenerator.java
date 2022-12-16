package validator;

import java.util.Random;

public class EmailGenerator {
	
	static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	static String provincias[] = {"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
	              "Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
	              "Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
	              "Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
	              "Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
	static String dominios[] = {"gmail.com", "hotmail.com", "yahoo.es", "indra.es"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateMail());

	}
	
	public static String generateMail() {
		String emailAddress = getRandomUser()+ getRandomNumber() + "@" + getRandomDomain();
		return emailAddress;
		
		
	}
	
	public static String getRandomUser() {
		Random randomNum = new Random();
		int randomIndex = randomNum.nextInt(provincias.length); 
		String user = provincias[randomIndex].toLowerCase();
		return user;
	}
	
	public static String getRandomNumber() {
		Random randomNum = new Random();
		String number ="";
		number += String.valueOf(randomNum.nextInt(10));
		number += String.valueOf(randomNum.nextInt(10));
		return number;
	}
	
	public static String getRandomDomain() {
		Random randomNum = new Random();
		int randomIndex = randomNum.nextInt(dominios.length);
		String dominio = dominios[randomIndex];
		return dominio;
	}
	
	
	
	

}
