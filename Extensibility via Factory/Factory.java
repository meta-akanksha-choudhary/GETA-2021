
public class Factory {
	
	
	public static Shape createShape(String type,Point p ,int []list){
		Shape shape=null;
		if(type=="Circle"){
			shape=new Circle(list[0]);
			if(p.x+list[0]>shape.XMAX || p.y+list[0]>shape.YMAX){
				System.out.println("Point is out of screen");
			    System.exit(0);
			}
			
		}
		else if(type=="Triangle"){
			shape=new Triangle(list[0],list[1]);
			if(p.x+list[0]>shape.XMAX || p.y+list[1]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
			
		}
		else if(type=="Rectangle"){
			shape=new Rectangle(list[0],list[1]);
			if(p.x+list[0]>shape.XMAX || p.y+list[1]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
		}
		else if(type=="Square"){
			shape=new Square(list[0]);
			if(p.x+list[0]>shape.XMAX || p.y+list[0]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
		}
		else if(type=="RegularPolygon"){
			shape=new RegularPolygon(list[0],list[1],list[2]);
			if(p.x+list[0]>shape.XMAX || p.y+list[1]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
		}
		else{
			System.out.println("This type of shape is not allowed");
			System.exit(0);
		}
		shape.setPoint(p.x, p.y);
		shape.setValues(type);
		return shape;
		
	}

}
