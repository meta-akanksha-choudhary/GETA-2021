import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
public class TestRecursion {
	@Test
	public void testGcd(){
		assertEquals(1,Recursion.gcd(5, 3));
		assertNotEquals(2,Recursion.gcd(15, 3));
	}
	public void testLcm(){
		assertEquals(15,Recursion.lcm(5, 3));
		assertNotEquals(2,Recursion.lcm(15, 3));
	}
	public void testLinearSearch(){
		assertEquals(3,Recursion.linearSearch(new int[]{3,5,8,6,4},0,4,6));
		assertNotEquals(3,Recursion.linearSearch(new int[]{3,5,8,6,4},0,4,8));
	}
	public void testBinarySearch(){
		assertEquals(-1,Recursion.binarySearch(new int[]{3,5,8,10,12},0,4,6));
		assertNotEquals(3,Recursion.binarySearch(new int[]{3,5,8,10,12},0,4,8));
	}
	public void testNQueens(){
		NQueens queen=new NQueens();
		assertEquals(true,queen.solveNQ(4));
		assertNotEquals(false,queen.solveNQ(2));
	}
  
}
