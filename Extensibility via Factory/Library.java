
import java.util.List;
public class Library {
	public static List<Shape> shapes;
	public static void addShape(Shape shape){
		shapes.add(shape);
	}
	public static void deleteShape(Shape shape){
		shapes.remove(shape);
	}
	public static void printShapes(){
		for(Shape i : shapes)
			System.out.println(i);
	}
	/*public static void deleteShapeOfType(String type){
	  for(Shape i:shapes){
		  if(i.type==type)
			shapes.remove(i);
	  }
	}
	  public static void sortByTimestamp(){
		  
	  }*/
	
}
