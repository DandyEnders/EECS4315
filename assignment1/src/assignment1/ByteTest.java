package assignment1;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import assignment.Byte;


/**
 * Tests static attributes, constructor and methods of class assignment.Byte.
 * 
 * @author Jinho Hwang
 */

class ByteTest {

	/**
	 * Test whether Byte.MAX_VALUE has highest value representation in a byte.
	 * The maximum value of a byte in two's complement system is 2^7 - 1 = 127.
	 */
	@Test
	void isMaxValueCorrect() {
		assertEquals(127, Byte.MAX_VALUE);
	}

	/**
	 * Test whether Byte.MAX_VALUE has lowest value representation in a byte.
	 * The minimum value of a byte in two's complement system is -2^7 = -128.
	 */
	@Test
	void isMinValueCorrect() {
		assertEquals(-128, Byte.MIN_VALUE);
	}
	
	/**
	 * Tests whether all possible byte value can be instantiated.
	 * Test is done by instantiating every possible byte value and testing whether
	 * instantiation throws no errors.
	 */
	@Test
	void isConstructorCorrect() {
		try {
			for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
				new Byte((byte) i);
			}
		} catch (Exception e) {
			fail("Contructor Error.");
		}
	}
	
	/**
	 * Test whether Byte.equals do evaluate false when its testing against different object.
	 */
	@Test
	void isEqualsTypeCheckCorrect() {
		Byte b = new Byte((byte) 1);
		Object o = new Object();
		
		assertNotEquals(b, o);
	}
	
	/**
	 * Test whether Equals do evaluate true when the byte values are same,
	 * and false when the byte values are different for all possible pairs of value.
	 */
	@Test
	void isEqualsValueCorrect() {
		for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
			for (int j = Byte.MIN_VALUE; j <= Byte.MAX_VALUE; j++) {
				Byte b = new Byte((byte) i);
				Byte bOther = new Byte((byte) j);
				
				if (i == j) {
					assertEquals(b, bOther);
				}else {
					assertNotEquals(b, bOther);
				}
			}
		}
	}
	
	/**
	 * Test whether the Byte.hashCode() returns right hashCode.
	 * That is, check for smallest value to the largest value of byte,
	 * check whether its hashCode is the integer version of its byte value.
	 */
	@Test
	void isHashCodeCorrect() {
		for (int i = Byte.MIN_VALUE; i <= Byte.MIN_VALUE; i++) {
			assertEquals(new Byte((byte) i).hashCode(), i);
		}
	}
	
}
