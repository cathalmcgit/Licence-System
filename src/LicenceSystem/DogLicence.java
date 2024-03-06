/**
 * Cathal McGuigan - 14640074
 */
package p2;

/**
 * Dog Licence class which extends parent Licence class
 * Contains fields only relevant to Dog Licences
 * @author Cathal
 *
 */
public class DogLicence extends Licence {
	
	private String dogName;
	private int dogAge;
	private DogSize dogSize;
	private String licenceID;
	
	/**
	 * Constructor with args for Dog Licence Objects
	 * @param surname
	 * @param initial
	 * @param dogName
	 * @param dogAge
	 * @param dogSize
	 * @param licenceID
	 */
	public DogLicence(String surname, String initial, String dogName, int dogAge, DogSize dogSize) {
		super(surname, initial);
		this.setDogName(dogName);
		this.setDogAge(dogAge);
		this.setDogSize(dogSize);
		//elements must be passed through to create Licence ID rather than it being set directly
		this.createLicenceID(dogName, surname, dogSize, dogAge);
	}
	/**
	 * @return the dogName
	 */
	public String getDogName() {
		return dogName;
	}
	/**
	 * Dog name must not be null and must be between 3 and 20 letters
	 * @param dogName the dogName to set
	 */
	public void setDogName(String dogName) {
		
		if (dogName != null && dogName.length() >= 3 && dogName.length()<=20) {
			this.dogName = dogName;
			} else {
				throw new IllegalArgumentException("Invalid Name Entered");
			}
		
		this.dogName = dogName;
	}
	/**
	 * @return the dogAge
	 */
	public int getDogAge() {
		return dogAge;
	}
	/**
	 * Dog age must be between 1 and 30
	 * @param dogAge the dogAge to set
	 */
	public void setDogAge(int dogAge) {
		if (dogAge >= 1 && dogAge <= 30) {
		this.dogAge = dogAge;
		} else {
			throw new IllegalArgumentException("Invalid Age Entered");
		}
	}
	/**
	 * @return the dogSize
	 */
	public DogSize getDogSize() {
		return dogSize;
	}
	/**
	 * Dog size must be one of the valid enum choices - small, medium, or large
	 * @param dogSize the dogSize to set
	 */
	public void setDogSize(DogSize dogSize) {
		this.dogSize = dogSize;
	}
	/**
	 * @return the licenceID
	 */
	public String getLicenceID() {
		return licenceID;
	}
	/**
	 * Licence ID is created using information from other fields
	 * @param licenceID the licenceID to set
	 */
	public void createLicenceID(String dogName, String surname, DogSize dogSize, int dogAge) {
		String dogLetters = dogName.substring(0, 3);
		String surnameLetters = surname.substring(0, 3);
		
		String sizeLetter = "";
		String ageLetter;
		
		if (dogSize.equals(DogSize.SMALL)) {
			sizeLetter = "S";
		} else if (dogSize.equals(DogSize.MEDIUM)) {
			sizeLetter = "M";
		} else if (dogSize.equals(DogSize.LARGE)) {
			sizeLetter = "L";
		}
		
		if (dogAge >= 15) {
			ageLetter = "G";
		} else {
			ageLetter = "Y";
		}
		this.licenceID = dogLetters+"-"+surnameLetters+"-"+sizeLetter+"-"+ageLetter;
	}

	@Override
	public void displayAll() {
		super.displayAll();
		System.out.println("Dog's Name :" +this.getDogName());
		System.out.println("Dog's Age :" +this.getDogAge());
		System.out.println("Dog's Size :" +this.getDogSize());
		System.out.println("Dog's Licence ID :" +this.getLicenceID());
	}
	
}
