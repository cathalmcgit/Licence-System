/**
 * Cathal McGuigan - 14640074
 */
package p2;

import java.util.ArrayList;

/**
 * Class which searches for information in an ArrayList of Licence Objects
 * @author Cathal
 *
 */
public class LicenceSearch {

	ArrayList <Licence> licences = new ArrayList <Licence>();
	
	/*
	 * Searches for licences containing a particular age field
	 * Dog Licences cast to Licence if found in Array List to access
	 * getDogAge()- a dog specific method
	 * 
	 * Method searches Arraylist to find those in range and creates a
	 * new ArrayList from the positive results
	 */
	public static ArrayList <Licence> searchByAge (ArrayList <Licence> licences, int lowestAge, int highestAge){
		ArrayList <Licence> ageSearchResults = new ArrayList <Licence>();
		
		for (Licence licence : licences) {
			if (licence instanceof DogLicence) {
				DogLicence temp = (DogLicence) licence;
				if (temp.getDogAge() <= 10 && temp.getDogAge() >= 7) {
					ageSearchResults.add(temp);
				}
			}
		}
		return ageSearchResults;
	}
	
	/*
	 * Searches for licences containing a particular initial field
	 * 
	 * Method searches ArrayList to find those with the correct initial and creates a
	 * new ArrayList from the positive results
	 */
	public static ArrayList <Licence> searchByLetter (ArrayList <Licence> licences, String initial){
		ArrayList <Licence> letterSearchResults = new ArrayList <Licence>();
		
		for (Licence licence : licences) {
				if (licence.getInitial().equals(initial)) {
					letterSearchResults.add(licence);
				}
	}
		return letterSearchResults;
}
}
