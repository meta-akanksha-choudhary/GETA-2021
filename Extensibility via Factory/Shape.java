
public interface Shape {
	public final int XMAX=100;
	public final int YMAX=100;
	public static enum ShapesType{
		SQUARE,CIRCLE,RECTANGLE,TRIANGLE,REGULAR_POLYGON
	}
	public float getArea();
	public void setPoint(int x,int y);
	public float getPerimeter(); 
	public Point getOrigin(); 
	public boolean isPointEnclosed(int x,int y);
    public void setValues(String type);
}
