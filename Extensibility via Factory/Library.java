
import java.util.*;
public class Library {
	public static List<Shape> shapes=new ArrayList<Shape>();
	public static void addShape(Shape shape){
		shapes.add(shape);
		System.out.println("Shape added successfully ");
	}
	
	public static void printShapes(){
		if(shapes.isEmpty())
			System.out.println("No shape is present in list");
		else{
		for(Shape i : shapes){
			System.out.println("Shape Type is "+i.getType());
			System.out.println("Area is "+i.getArea());
			System.out.println("Perimeter is "+i.getPerimeter());
			System.out.println("Origin is x:"+i.getOrigin().x+" y:"+i.getOrigin().y);
			System.out.println("Timestamp is"+i.getTimestamp());
		}
		}
	}
	public static void deleteShapeOfType(String type){
		if(shapes.isEmpty())
			System.out.println("No shape is present in list");
		else{
	  for(Shape i:shapes){
		  if(i.getType()==type)
			shapes.remove(i);
	  }
	  System.out.println("Shape deleted successfully ");
		}
	}
	public static void deleteShape(Shape shape){
		if(shapes.isEmpty())
			System.out.println("No shape is present in list");
		else{
		shapes.remove(shape);
		System.out.println("Shape deleted successfully ");
		}
	}
	  public static void sortByPerimeter(){
		  System.out.println("Shape Sorted by Perimeter ");
		  Collections.sort(shapes, new sortByPerimeter());
		  Library.printShapes();
	  }
	  public static void sortByArea(){
		  System.out.println("Shape Sorted by Area ");
		  Collections.sort(shapes, new sortByArea());
		  Library.printShapes();
	  }
	  public static void sortByTimestamp(){
		  System.out.println("Shape Sorted by Timestamp ");
		  Collections.sort(shapes, new sortByTimestamp());
		  Library.printShapes();
	  }
	
}
