import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
public class TestClassHex {
	@Test
	public void testDecToHex(){
		assertEquals("A",HexCal.decToHex(10));
		assertNotEquals("A",HexCal.decToHex(11));
	}
	@Test
	public void testHexToDec(){
		assertEquals(10,HexCal.hexToDec("A"));
		assertNotEquals(11,HexCal.hexToDec("A"));
	}
	@Test
	public void testAddition(){
		assertEquals("11",HexCal.addition("5", "6"));
		assertNotEquals("12",HexCal.addition("5", "6"));
	}
	@Test
	public void testSubtraction(){
		assertEquals("1",HexCal.subtraction("7", "6"));
		assertNotEquals("1",HexCal.subtraction("8", "6"));
	}
	@Test
	public void testMultiplication(){
		assertEquals("A",HexCal.multiplication("5", "2"));
		assertNotEquals("A",HexCal.multiplication("5", "6"));
	}
	@Test
	public void testDivision(){
		assertEquals("2",HexCal.division("C", "6"));
		assertNotEquals("3",HexCal.division("C", "6"));
	}

}
