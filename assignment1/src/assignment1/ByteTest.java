package assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;


class ByteTest {
	
	private final assignment.Byte bCustom = new assignment.Byte((byte) 10);
	private final assignment.Byte bCustomOther = new assignment.Byte((byte) 10);
	private final assignment.Byte bCustomWrongOther = new assignment.Byte((byte) 30);
	private final java.lang.Byte bOriginal = new java.lang.Byte((byte) 10);

	@Test
	void isMaxValueSame() {
		assertEquals(java.lang.Byte.MAX_VALUE, assignment.Byte.MAX_VALUE);
	}

	@Test
	void isMinValueSame() {
		assertEquals(java.lang.Byte.MIN_VALUE, assignment.Byte.MIN_VALUE);
	}
	
	@Test
	void isEqualsCorrect() {
		assertEquals(bCustom, bCustomOther);
		assertNotEquals(bCustom, bCustomWrongOther);
	}
	
	@Test
	void isHasingSame() {
		assertEquals(bCustom.hashCode(), bOriginal.hashCode());
	}
	
}
