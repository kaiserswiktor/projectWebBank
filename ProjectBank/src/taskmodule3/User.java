package taskmodule3;

/**
 * 
 * @author User TABLE USERS (ID_USER INT(10) NOT NULL PRIMARY KEY,FIRST_NAME
 *         VARCHAR(50) NULL, LAST_NAME VARCHAR(50) NULL,E_MAIL VARCHAR(50)
 *         NULL,PASSWORD_ VARCHAR(50) NULL, ROLE VARCHAR(10) NULL);
 */
public class User {
	private int idUser;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private String role;
	
	public User(){
		
	}

	public User(int idUser, String firstName, String lastName, String eMail, String password, String role) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.role = role;
	}

	public int getIdUser() {
		return idUser;
	}

	public void SetIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void SetFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void SetLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void SetEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void SetPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void SetRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "idUser-" + idUser + " firstName-" + firstName + " lastName-" + lastName + " eMail-" + eMail
				+ " password-" + password + " role-" + role;
	}
}
