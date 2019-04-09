/**
 * @author Team7
 * 
 * Junit test class for LocationA (witness house).
 * <p>
 * Test class will ensure that inheritance has been implemented properly throughout the 
 * child location classes to the parent Police Station class. This test will be done by
 * testing the toString method shared throughout the classes.
 */ 

import static org.junit.Assert.*;
import org.junit.Test;

public class LocationATest extends LocationA {
	
	@Test
	public void testToString() {
		
		LocationA a = new LocationA();
		
		assertEquals("super.toString was called correctly", "Welcome: ", a.toString());
	}

}
