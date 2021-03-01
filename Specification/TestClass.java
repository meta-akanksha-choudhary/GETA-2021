import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
public class TestClass {
	static float grades[]={10,20,30,70,90};
	Area a=new Area();
	@Test
	public void testAreaRectangle(){
		
		assertsEquals(30,a.areaRectangle(5, 6));
		assertsNotEquals(40,a.areaRectangle(5, 6));
	}
	@Test
	public void testAreaCircle(){
		assertsEquals(314,a.areaCircle(10));
		assertsNotEquals(330,a.areaCircle(10));
		
	}
	@Test
	public void testAreaSquare(){
		assertsEquals(25,a.areaSquare(5));
		assertsNotEquals(30,a.areaSquare(5));
	}
	@Test
	public void testAreaTriangle(){
		assertsEquals(15,a.areaTriangle(5, 6));
		assertsNotEquals(30,a.areaTriangle(5, 6));
		
	}
	@Test
	public void testCompareString(){
		assertsEquals(1,StringOps.compareString("hello", "hello"));
		assertsNotEquals(1,StringOps.compareString("Hello", "hello"));
	}
	@Test
    public void testReverseString(){
    	assertsEquals("dam",StringOps.reverse("mad"));
    	assertsNotEquals("dam",StringOps.reverse("had"));
	}
	@Test
    public void testConvertCase(){
    	assertsEquals("heLLo",StringOps.convertCase("HEllO"));
    	assertsNotEquals("helLo",StringOps.convertCase("HEllO"));
		
	}
	@Test
    public void testLongestWord(){
    	assertsEquals("happy",StringOps.longestWord("i am happy"));
    	assertsNotEquals("am",StringOps.longestWord("i am happy"));
		
	}
	@Test
    public void testMaxGrades(){
    	assertsEquals(90,Marksheet.maxGrade());
    	assertsNotEquals(70,Marksheet.maxGrade());
    }
	@Test
    public void testMinGrades(){
    	assertsEquals(10,Marksheet.minGrade());
    	assertsNotEquals(20,Marksheet.minGrade());
    }
	@Test
    public void testAvgGrades(){
    	assertsEquals(44,Marksheet.avgGrade());
    	assertsNotEquals(50,Marksheet.avgGrade());
    }
	@Test
    public void testPassPerStud(){
    	assertsEquals(40,Marksheet.passPerStud());
    	assertsNotEquals(20,Marksheet.passPerStud());
    }
	
}
