package it.unisa.di.is.gc1.ify.web;

/** 
 * Oggetto utilizzato per mappare i campi di un form di login. Questo oggetto
 * viene passato come parametro al controller della dispatcher servlet quando
 * un utente sottomette il modulo di login.
 * 
 * @author Alessia Natale, Giacomo Izzo
 *
 */

public class LoginForm {
	
	public LoginForm() {
		
	}
	
	public LoginForm(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	private String email;
	private String password;

}
