/**
 * @author Team7
 * 
 * Junit test class for LocationC (guessing game).
 * <p>
 * Test class will ensure that inheritance has been implemented properly throughout the 
 * child location classes to the parent Police Station class. This test will be done by
 * testing the toString method shared throughout the classes.
 */ 

import static org.junit.Assert.*;
import org.junit.Test;

public class LocationCTest extends LocationC {
	
	@Test
	public void testToString() {
		
		LocationC c = new LocationC();
		
		assertEquals("super.toString was called correctly", "Welcome: ", c.toString());
	}

}
