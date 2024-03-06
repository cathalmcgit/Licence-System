/**
 * Cathal McGuigan - 14640074
 */
package p2;

/**
 * Abstract parent class
 * @author Cathal
 *
 */
public abstract class Licence {
	
	private String surname;
	private String initial;
	
	
	
	/**
	 * Constructor to set Surname and Initial
	 * @param surname
	 * @param initial
	 */
	public Licence(String surname, String initial) {
		this.setSurname(surname);
		this.setInitial(initial);
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * Surname must be be null and must be between 3 and 20 letters long
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		if (surname != null && surname.length() >= 3 && surname.length()<=20) {
		this.surname = surname;
		} else {
			throw new IllegalArgumentException("Invalid Name Entered");
		}
	}
	/**
	 * @return the initial
	 */
	public String getInitial() {
		return initial;
	}
	/**
	 * The initial must not be null and should also only equal one letter
	 * This letter should only be a letter from A-Z, only capital letters, no numbers or spaces
	 * @param initial the initial to set
	 */
	public void setInitial(String initial) {
		
		if (initial != null && initial.length() == 1) {
			this.initial = initial;
		} else {
			throw new IllegalArgumentException("Invalid Initial Entered");
		}
	}
	
	/**
	 * prints info on surname and inital to screen
	 */
	public void displayAll() {
		System.out.println("Surname :" +this.surname);
		System.out.println("Initial :" +this.initial);
	}

}
