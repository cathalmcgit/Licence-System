/**
 * Cathal McGuigan - 14640074
 */
package p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Dog Licence Class
 * @author Cathal
 *
 */
class DogLicenceTest {

	//instance vars
	String nameValidLow, nameValidMid,nameValidHigh;
	String nameInvalidLow, nameInvalidHigh;
	
	String initialValidLow, initialValidMid, initialValidHigh;
	String initialInvalidLowercase, initialInvalidNumber, initialInvalidSpace;
	
	int dogAgeValidLow, dogAgeValidMid, dogAgeValidHigh;
	int[] validDogAges;
	int dogAgeInvalidLow, dogAgeInvalidHigh;
	
	DogSize small, medium, large;
	
	String licenceIDValid, licenceIDInvalid;
	
	DogLicence rexLicence;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//declaring vars for testing name fields
		//can be used for surname & dog name as both have same business rules
		nameInvalidLow = "ab";
		//contains 3 letters - boundary
		nameValidLow = "abc"; 
	    nameValidMid = "abcd5abcd5";
	    //contains 20 letters - boundary
	    nameValidHigh = "abcd5abcd5acbd5abcd5";
		nameInvalidHigh = "abcd5abcd5acbd5abcd5a";
		
		//examples of test data for testing SetInitial
		initialValidLow = "A";
		initialValidMid = "M";
		initialValidHigh = "Z";
		initialInvalidLowercase = "p";
		initialInvalidNumber = "6";
		initialInvalidSpace = " ";
		
		dogAgeInvalidLow = 0;
		dogAgeValidLow = 1;
		dogAgeValidMid = 15;
		dogAgeValidHigh = 30;
		dogAgeInvalidHigh = 31;
		
		validDogAges = new int [] {dogAgeValidLow, dogAgeValidMid, dogAgeValidHigh };
		
		small = DogSize.SMALL;
		medium = DogSize.MEDIUM;
		large = DogSize.LARGE;
		
		licenceIDValid = "abc-abc-S-G";
		licenceIDInvalid = "xyz-xyz-B-G";
		
		rexLicence = new DogLicence(nameValidLow, initialValidLow, nameValidHigh, dogAgeValidMid, small);
		
	}

	
	/**
	 * Test method 
	 */
	@Test
	void testGetSetSurname() {
		
		rexLicence.setSurname(nameValidHigh);
		assertEquals(nameValidHigh, rexLicence.getSurname());
		
		rexLicence.setSurname(nameValidMid);
		assertEquals(nameValidMid, rexLicence.getSurname());
		
		rexLicence.setSurname(nameValidLow);
		assertEquals(nameValidLow, rexLicence.getSurname());

		Exception wrongName = assertThrows(IllegalArgumentException.class, ()-> {
			rexLicence.setSurname(nameInvalidLow);
		});
		assertEquals("Invalid Name Entered", wrongName.getMessage());
		
		wrongName = assertThrows(IllegalArgumentException.class, ()-> {
			rexLicence.setSurname(nameInvalidHigh);
		});
		assertEquals("Invalid Name Entered", wrongName.getMessage());
	}


	/**
	 * Test of constructor with args
	 * Super constructor would be checked in a similar way
	 * but only the surname and initial fields
	 */
	@Test
	void testDogLicence() {
		DogLicence Rover = new DogLicence(nameValidLow, initialValidLow, nameValidHigh, dogAgeValidLow, small);
		assertNotNull(Rover);
		assertEquals(nameValidLow, Rover.getSurname());
		assertEquals(initialValidLow, Rover.getInitial());
		assertEquals(nameValidHigh, Rover.getDogName());
		assertEquals(dogAgeValidLow, Rover.getDogAge());
		assertEquals(small, Rover.getDogSize());
	
	}

	/**
	 * Test method for {@link p2.DogLicence#getDogName()}.
	 */
	@Test
	void testGetSetDogName() {
		
		rexLicence.setDogName(nameValidLow);
		assertEquals(nameValidLow, rexLicence.getDogName());
		
		rexLicence.setDogName(nameValidMid);
		assertEquals(nameValidMid, rexLicence.getDogName());
		
		rexLicence.setDogName(nameValidHigh);
		assertEquals(nameValidHigh, rexLicence.getDogName());

		Exception wrongName = assertThrows(IllegalArgumentException.class, ()-> {
			rexLicence.setDogName(nameInvalidLow);
		});
		assertEquals("Invalid Name Entered", wrongName.getMessage());
		
		wrongName = assertThrows(IllegalArgumentException.class, ()-> {
			rexLicence.setSurname(nameInvalidHigh);
		});
		assertEquals("Invalid Name Entered", wrongName.getMessage());
	}
		
	

	/**
	 * Test method for {@link p2.DogLicence#getDogAge()}.
	 */
	@Test
	void testGetSetDogAge() {
		
		for (int doggyAge : validDogAges) {
			rexLicence.setDogAge(doggyAge);
			assertEquals(doggyAge, rexLicence.getDogAge());
		}
		Exception wrongAge = assertThrows(IllegalArgumentException.class, ()-> {
			rexLicence.setDogAge(dogAgeInvalidLow);
		});
		assertEquals("Invalid Age Entered", wrongAge.getMessage());
		
		wrongAge = assertThrows(IllegalArgumentException.class, ()-> {
			rexLicence.setDogAge(dogAgeInvalidHigh);
		});
		assertEquals("Invalid Age Entered", wrongAge.getMessage());
	}

	/**
	 * Test method for {@link p2.DogLicence#setDogSize(p2.DogSize)}.
	 */
	@Test
	void testSetDogSize() {
		rexLicence.setDogSize(large);
		assertEquals(large, rexLicence.getDogSize());
		
		rexLicence.setDogSize(medium);
		assertEquals(medium, rexLicence.getDogSize());
		
		rexLicence.setDogSize(small);
		assertEquals(small, rexLicence.getDogSize());
	}

	/**
	 * Test method for {@link p2.DogLicence#getLicenceID()}.
	 */
	@Test
	void testGetSetLicenceID() {
		rexLicence.createLicenceID(nameValidLow, nameValidLow, small, dogAgeValidMid);
		assertEquals("abc-abc-S-G", rexLicence.getLicenceID());
	}
	
	/**
	 * Test method for {@link p2.Licence#getInitial()}.
	 */
	@Test
	void testGetSetInitial() {
		rexLicence.setInitial(initialValidMid);{
			assertEquals(initialValidMid, rexLicence.getInitial());
		}
		
		Exception wrongInitial = assertThrows(IllegalArgumentException.class, ()-> {
			rexLicence.setInitial(null);
		});
		assertEquals("Invalid Initial Entered", wrongInitial.getMessage());
	}



}
