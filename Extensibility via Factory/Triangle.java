import java.sql.Timestamp;
import java.util.Date;
import java.lang.Math;
public class Triangle implements Shape {
	public int base;
	public int height;
	public Date date;
	public Timestamp ts;
	public String type;
	public float originDistance;
	public float area;
	public float perimeter;
	public Triangle(int b,int h){
		base=b;
		height=h;
	}
	public Point origin=new Point();
    public void setPoint(int x,int y){
    	origin.x=x;
    	origin.y=y;
    }
	public float getArea(){
		return (float)(0.5*base*height);
	}
	public float getPerimeter(){
		return (float)(3*base);
	}
	public Point getOrigin(){
		return origin;
	}
	public boolean isPointEnclosed(int x,int y){
		if((x>=origin.x && x<=(origin.x+base)) && (y>=origin.y && y<=(origin.y+height)) )
			return true;
		return false;
	}
	public void setValues(String type){
    	this.type=type;
    	date=new Date();
    	ts=new Timestamp(date.getTime());
    	perimeter=this.getPerimeter();
    	area=this.getArea();
    	this.originDistance=(float)Math.sqrt(Math.pow(origin.x, 2)+Math.pow(origin.y,2));
    }

}
