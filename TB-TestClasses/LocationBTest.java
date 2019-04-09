/**
 * @author Team7
 * 
 * Junit test class for LocationB (crime scene).
 * <p>
 * Test class will ensure that inheritance has been implemented properly throughout the 
 * child location classes to the parent Police Station class. This test will be done by
 * testing the toString method shared throughout the classes.
 */ 

import static org.junit.Assert.*;
import org.junit.Test;

public class LocationBTest extends LocationB {
	
	@Test
	public void testToString() {
		
		LocationB b = new LocationB();
		
		assertEquals("super.toString was called correctly", "Welcome: ", b.toString());
	}

}
