
public class Area {
	/**
	 * Find area of triangle
	 * @param height and width of triangle
	 * @param greater than 0
	 * @return area of triangle in double
	 */
    public double areaTriangle(double h,double w){
    	double ans;
    	ans=0.5*h*w;
    	return ans;
    }
    
    /**
	 * Find area of rectangle
	 * @param height and width of triangle
	 * @param greater than 0
	 * @return area of rectangle in double
	 */
    public double areaRectangle(double h,double w){
    	double ans;
    	ans=h*w;
    	return ans;
    }
    /**
	 * Find area of square
	 * @param side of triangle
	 * @param greater than 0
	 * @return area of square in double
	 */
    public double areaSquare(double h){
    	double ans;
    	ans=h*h;
    	return ans;
    }
    
    /**
	 * Find area of circle
	 * @param radius of circle
	 * @param greater than 0
	 * @return area of circle in double
	 */
    public double areaCircle(double h){
    	double ans;
    	ans=314*h*h;
    	return ans;
    }
    public static void main(String args[]){
    	Area traingle=new Area();
    	Area rectangle=new Area();
    	Area square=new Area();
    	Area circle=new Area();
    	System.out.println("The area of traingle is "+traingle.areaTriangle(5,10));
    	System.out.println("The area of rectangle is "+rectangle.areaRectangle(5,7));
    	System.out.println("The area of square is "+square.areaSquare(8));
    	System.out.println("The area of circle is "+circle.areaCircle(10));
    }
}
