import java.sql.Timestamp;
import java.util.Date;
import java.lang.Math;
public class Circle implements Shape{
	public int radius;
	public Date date;
	public Timestamp ts;
	public String type;
	public float originDistance;
	public float area;
	public float perimeter;
;	public Circle(int r){
		radius=r;
	}
    public Point origin=new Point();
    public void setPoint(int x,int y){
    	origin.x=x;
    	origin.y=y;
    }
	public float getArea(){
		return (float)(3.14*radius*radius);
	}
	public float getPerimeter(){
		return (float)(2*3.14*radius);
	}
	public Point getOrigin(){
		return origin;
	}
	public boolean isPointEnclosed(int x,int y){
		if((x>=origin.x && x<=(origin.x+radius)) && (y>=origin.y && y<=(origin.y+radius)) )
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
    public Timestamp getTimestamp(){
		return ts;
	}
    public String getType(){
    	return type;
    }

}
