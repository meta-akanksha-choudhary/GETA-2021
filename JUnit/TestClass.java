
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestClass {
	@Test
	public void testSplitArray(){
		assertEquals(3,JUnit.splitArray(new int[]{1, 1, 1, 2, 1}));
	}
	@Test
	public void testCountClumps(){
		assertEquals(2,JUnit.countClumps(new int[]{1, 1, 2, 1, 1}));
	}
	@Test
	public void testFixXY(){
		assertEquals(new int[]{1, 4, 5, 1},JUnit.fixXY(new int[]{1, 4, 1, 5},4,5));
	}
	@Test
	public void testMaxMirror(){
		assertEquals(2,JUnit.maxMirror(new int[]{7, 1, 4, 9, 7, 4, 1}));
	}

}
