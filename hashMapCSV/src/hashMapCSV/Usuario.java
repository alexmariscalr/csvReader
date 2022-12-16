package hashMapCSV;

public class Usuario {
	
	public static String email;
	public static String username;
	public static String password;
	public static String phoneNumber;
	public static String zipCode;
	public static String dni;
	
	public Usuario(String email, String username, String password, String phoneNumber, String zipCode, String dni) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.dni = dni;
	}
	
	public String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Usuario.email = email;
	}

	public String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Usuario.username = username;
	}


	public String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Usuario.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public static void setPhoneNumber(String phoneNumber) {
		Usuario.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public static void setZipCode(String zipCode) {
		Usuario.zipCode = zipCode;
	}

	public String getDni() {
		return dni;
	}

	public static void setDni(String dni) {
		Usuario.dni = dni;
	}

}
