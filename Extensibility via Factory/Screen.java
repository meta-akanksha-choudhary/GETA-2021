
public class Screen {
	public static void main(String args[]){
	Point p=new Point(4,4);
	String type="Circle";
	int arr[]={3};
	Shape shape=Factory.createShape(type,p,arr);
	Library.printShapes();
	}
}
