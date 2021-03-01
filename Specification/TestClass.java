import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
public class TestClass {
	static float grades[]={10,20,30,70,90};
	Area a=new Area();
	@Test
	public void testAreaRectangle(){
		
		assertEquals(30,a.areaRectangle(5, 6));
		assertNotEquals(40,a.areaRectangle(5, 6));
	}
	@Test
	public void testAreaCircle(){
		assertEquals(314,a.areaCircle(10));
		assertNotEquals(330,a.areaCircle(10));
		
	}
	@Test
	public void testAreaSquare(){
		assertEquals(25,a.areaSquare(5));
		assertNotEquals(30,a.areaSquare(5));
	}
	@Test
	public void testAreaTriangle(){
		assertEquals(15,a.areaTriangle(5, 6));
		assertNotEquals(30,a.areaTriangle(5, 6));
		
	}
	@Test
	public void testCompareString(){
		assertEquals(1,StringOps.compareString("hello", "hello"));
		assertNotEquals(1,StringOps.compareString("Hello", "hello"));
	}
	@Test
    public void testReverseString(){
    	assertEquals("dam",StringOps.reverse("mad"));
    	assertNotEquals("dam",StringOps.reverse("had"));
	}
	@Test
    public void testConvertCase(){
    	assertEquals("heLLo",StringOps.convertCase("HEllO"));
    	assertNotEquals("helLo",StringOps.convertCase("HEllO"));
		
	}
	@Test
    public void testLongestWord(){
    	assertEquals("happy",StringOps.longestWord("i am happy"));
    	assertNotEquals("am",StringOps.longestWord("i am happy"));
		
	}
	@Test
    public void testMaxGrades(){
    	assertEquals(90,Marksheet.maxGrade());
    	assertNotEquals(70,Marksheet.maxGrade());
    }
	@Test
    public void testMinGrades(){
    	assertEquals(10,Marksheet.minGrade());
    	assertNotEquals(20,Marksheet.minGrade());
    }
	@Test
    public void testAvgGrades(){
    	assertEquals(44,Marksheet.avgGrade());
    	assertNotEquals(50,Marksheet.avgGrade());
    }
	@Test
    public void testPassPerStud(){
    	assertEquals(40,Marksheet.passPerStud());
    	assertNotEquals(20,Marksheet.passPerStud());
    }
	
}
