
/*
 * Cathal McGuigan 14640074
 */
package p2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LicenceSearchTest {

	//test data
	ArrayList<Licence> licences;
	DogLicence dog1;
	DogSize small;
	String initialValid;
	
	@BeforeEach
	void setUp() throws Exception {
		//initialising test data
		//dog1 is an example to test if search works 
		//multiple tests should be completed with other data
		//and multiple objects
		small = DogSize.SMALL;
		dog1 = new DogLicence("John", "W", "Derek", 8, small);
		licences = new ArrayList <Licence>();
		licences.add(dog1);
		initialValid = "W";
	}

	/*
	 * Test of Search By Age
	 * Checks if the expected size of ArrayList is returned
	 * and if it contains at least one expected Object
	 */
	@Test
	void testSearchByAge() {
		ArrayList<Licence> ageSearchResults = LicenceSearch.searchByAge(licences, 7, 10);
		
		if (ageSearchResults.size() == 1 && ageSearchResults.contains(dog1)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
	}
	/*
	 * Test of Search By Letter
	 * Checks if the expected size of ArrayList is returned
	 * and if it contains at least one expected Object
	 */
	@Test
	void testSearchByLetter() {
      ArrayList<Licence> letterSearchResults = LicenceSearch.searchByLetter(licences, initialValid);
		
		if (letterSearchResults.size() == 1 && letterSearchResults.contains(dog1)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
}
