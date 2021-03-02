
public class Screen {
	public static void main(String args[]){
	Point p=new Point(3,3);
	String type1="Circle";
	String type2="Square";
	String type3="Triangle";
	String type4="Triangle";
	int arr[]={3};
	Shape shape1=Factory.createShape(type1,p,arr);
	Shape shape2=Factory.createShape(type2,new Point(5,5), new int[]{7});
	Shape shape3=Factory.createShape(type3,new Point(6,8), new int[]{7,10});
	Shape shape4=Factory.createShape(type4,new Point(10,5), new int[]{8,12});
	Library.addShape(shape1);
	Library.addShape(shape2);
	Library.printShapes();
	Library.deleteShapeOfType(type1);
	Library.printShapes();
	Library.addShape(shape3);
	Library.addShape(shape4);
	Library.printShapes();
	Library.deleteShapeOfType(type3);
	Library.printShapes();
	Library.sortByTimestamp();
	Library.sortByArea();
	Library.sortByPerimeter();
	}
}
