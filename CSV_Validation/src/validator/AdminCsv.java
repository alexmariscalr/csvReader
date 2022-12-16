package validator;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import validator.*;

public class AdminCsv {
	
	//REGEX
	public static String emailRegex = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
	public static String passwordRegex = "^(?=(?:.*\\d){1,})(?=(?:.*[A-Z]){1,})(?=(?:.*[a-z]){1,})\\S{8,12}$";
	public static String usernameRegex = "^[A-Za-z0-9_-]{3,15}$";
	public static String phoneRegex = "^[679]{1}[0-9]{8}$";
	public static String zipcodeRegex = "([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}";
	public static String dniRegex = "^[0-9]{8,8}[A-Za-z]$";
	
	//CSV PATHS
	public static String path1 = "C:/Users/amariscalr/Desktop/INDRA/Formación Talent Camp/projectTransport/projectTransport/clase9dic/csv1.csv";
	public static String path2 = "C:/Users/amariscalr/Desktop/INDRA/Formación Talent Camp/projectTransport/projectTransport/clase9dic/csv2.csv";
	public static String path3 = "C:/Users/amariscalr/Desktop/INDRA/Formación Talent Camp/projectTransport/projectTransport/clase9dic/mergedCSV.csv";

	//ARRAYS WITH CSV DATA
	public static List<List<String>> csv1 = new ArrayList<>();
	public static List<List<String>> csv2 = new ArrayList<>();
	public static List<List<String>> mergedCSV = new ArrayList<>();
	public static List<List<String>> sortedCSV = new ArrayList<>();
	
	//FUNCTIONS
	public static void csvToArrayList (String path,List<List<String>> csv ) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				csv.add(Arrays.asList(values));			
			}
			
		}		
		catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	
	public static void setDataToFile( String mail,  String pwd,  String username, String dni, String phoneNumber, String zipCode) {
	
		
		PrintWriter csvWriter;
		
		String data[] = {mail, pwd, username, dni, phoneNumber, zipCode};
		String output = mail + ";" + pwd + ";" + username + ";" + dni + ";" + phoneNumber + ";" + zipCode;
		
		if (isRepeated (mail,username,dni,phoneNumber)) {
			return;
		}
		
		for (int i=0 ; i< data.length ; i++ ) {
			try {
					File file = new File(path3);
					if (!file.exists()) {
						file = new File(path3);
					}
					if (i==(data.length-1)) {
						csvWriter = new PrintWriter( new FileWriter(file, true));
						csvWriter.print(output+ "\n");					
						csvWriter.close();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}				
			
		}
	}
	
	public static void setDataToFile(String mail, String pwd, String username, String phoneNumber) {
		
		PrintWriter csvWriter;
		
		String data[] = {mail, pwd, username, phoneNumber};
		String regex[] = {emailRegex, passwordRegex, usernameRegex, phoneRegex};
		String output = mail + ";" + pwd + ";" + username + ";" + phoneNumber;
		
		if (isRepeated(mail,username,phoneNumber)) {
			return;
		}
		
		for (int i=0 ; i< data.length ; i++ ) {
			if (!data[i].matches(regex[i])) {
				System.out.println("El valor " + data[i] + " introducido no es válido. \n" );
				return;
			} else {
				try {
					File file = new File(path1);
					if (!file.exists()) {
						file = new File(path1);
					}
					if (i==(data.length-1)) {
					csvWriter = new PrintWriter( new FileWriter(file, true));
					csvWriter.print(output+ "\n");					
					csvWriter.close();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
		
	}
	
	public static void setDataToFile( String zipCode, String dni, String phoneNumber) {
		
		PrintWriter csvWriter;
		
		String data[] = {zipCode, dni, phoneNumber};
		String regex[] = {zipcodeRegex, dniRegex, phoneRegex};
		String output = zipCode + ";" + dni + ";" + phoneNumber;
		
		if (isRepeated(dni,phoneNumber)) {
			return;
		}
		
		for (int i=0 ; i< data.length ; i++ ) {
			boolean match = data[i].matches(regex[i]);
			if (!match) {
				System.out.println("El valor " + data[i] + " introducido no es válido. \n" );
				return;
			} else {
				try {
					File file = new File(path2);
					if (!file.exists()) {
						file = new File(path2);
					}
					if (i==(data.length-1)) {
					csvWriter = new PrintWriter( new FileWriter(file, true));
					csvWriter.print(output+ "\n");					
					csvWriter.close();
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
	}
	
	
	
	public static boolean isRepeated (	String email, String username, String dni, String phoneNumber) {

		for (int i = 1; i<mergedCSV.size(); i++) {

		if (mergedCSV.get(i).get(0).equals(email) ) {
		System.out.println("Email repetido");
		return true;
		} else if (mergedCSV.get(i).get(2).equals(username)) {
		System.out.println("Usuario repetido");
		return true;
		} else if (mergedCSV.get(i).get(3).equals(dni)) {
		System.out.println("DNI repetido");
		return true;
		} else if (mergedCSV.get(i).get(4).equals(phoneNumber)) {
		System.out.println("Teléfono repetido");
		return true;
		}
		}
						
		return false;

		}
			
	public static boolean isRepeated (String email, String username, String phoneNumber) {
		for (int i = 1; i<csv1.size(); i++) {
			if (csv1.get(i).get(0).equals(email) ) {
				System.out.println("Email repetido");
				return true;
			} else if (csv1.get(i).get(2).equals(username)) {
				System.out.println("Usuario repetido");
				return true;
			} else if (csv1.get(i).get(3).equals(phoneNumber)) {
				System.out.println("Teléfono repetido");
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean isRepeated (String dni, String phoneNumber) {
		for (int i = 1; i<csv2.size(); i++) {
			if (csv2.get(i).get(1).equals(dni) ) {
				System.out.println("DNI repetido");
				return true;
			} else if (csv2.get(i).get(2).equals(phoneNumber)) {
				System.out.println("Teléfono repetido");
				return true;
			}
		}
		return false;		
	}
	
	public static void concatCSV (	List<List<String>> csv1, List<List<String>> csv2) {
		
		for (int i = 1; i<csv1.size(); i++ ) {
			for (int j = 1; j<csv2.size(); j++ ) {
				String email =csv1.get(i).get(0);
				String pwd = csv1.get(i).get(1);
				String username = csv1.get(i).get(2);
				String phone1 = csv1.get(i).get(3);
				String zipCode = csv2.get(j).get(0);
				String dni = csv2.get(j).get(1);
				String phone2 = csv2.get(j).get(2);
				boolean samePhone = (phone1.equals(phone2));
				
				if (phone1.equals(phone2)) {
					setDataToFile(email,pwd,username,dni,phone1,zipCode);
				}
			}
		}
	}
	
	public static void sortByUsername(List<List<String>> csv,String path ) {
		for (int i=1; i<csv.size(); i++ ) {
			List<String> row  = csv.get(i);
			String username = row.get(2);
			if (sortedCSV.size()==0) {sortedCSV.add(row);}
			for (int j=1; j<sortedCSV.size(); j++ ) {
				String currentUsername = sortedCSV.get(i).get(2);
				String nextUsername = sortedCSV.get(i+1).get(2);
				
				
				if ((username.compareTo(currentUsername)>0) && 
						username.compareTo(nextUsername)<0) {
					
					sortedCSV.add(i+1,row);
				}
			}
		}
	}

	public static void main(String[] args) {
		//GENERATORS
		String mail = EmailGenerator.generateMail();
		String pwd = PasswordGenerator.getPassword();
		String username = UsernameGenerator.getUsername();
		String phoneNumber = PhoneGenerator.getPhoneNumber();
		String zipCode = ZipCodeGenerator.getZipCode();
		String dni = DniGenerator.getDNI();
		
		
		csvToArrayList(path1, csv1);
		csvToArrayList(path2, csv2);
		concatCSV(csv1,csv2);
		csvToArrayList(path3,mergedCSV);
		System.out.println(mergedCSV);
		
		
	}
	
}