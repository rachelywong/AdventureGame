/**
 * @author Team7
 * 
 * Junit test class for LocationD (suspect guess).
 * <p>
 * Test class will ensure that inheritance has been implemented properly throughout the 
 * child location classes to the parent Police Station class. This test will be done by
 * testing the toString method shared throughout the classes.
 */ 

import static org.junit.Assert.*;
import org.junit.Test;

public class LocationDTest extends LocationD {
	
	@Test
	public void testToString() {
		
		LocationD d = new LocationD();
		
		assertEquals("super.toString was called correctly", "Welcome: ", d.toString());
	}

}
