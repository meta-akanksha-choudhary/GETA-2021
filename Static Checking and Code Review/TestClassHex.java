import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
public class TestClassHex {
	@Test
	public void testDecToHex(){
		assertsEquals("A",HexCal.decToHex(10));
		assertsNotEquals("A",HexCal.decToHex(11));
	}
	@Test
	public void testHexToDec(){
		assertsEquals(10,HexCal.hexToDec("A"));
		assertsNotEquals(11,HexCal.hexToDec("A"));
	}
	@Test
	public void testAddition(){
		assertsEquals("11",HexCal.addition("5", "6"));
		assertsNotEquals("12",HexCal.addition("5", "6"));
	}
	@Test
	public void testSubtraction(){
		assertsEquals("1",HexCal.subtraction("7", "6"));
		assertsNotEquals("1",HexCal.subtraction("8", "6"));
	}
	@Test
	public void testMultiplication(){
		assertsEquals("A",HexCal.multiplication("5", "2"));
		assertsNotEquals("A",HexCal.multiplication("5", "6"));
	}
	@Test
	public void testDivision(){
		assertsEquals("2",HexCal.division("C", "6"));
		assertsNotEquals("3",HexCal.division("C", "6"));
	}

}
