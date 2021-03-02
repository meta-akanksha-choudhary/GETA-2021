import java.sql.Timestamp;
import java.util.Date;
import java.lang.Math;
public class Square implements Shape {
	public int side;
	public Date date;
	public Timestamp ts;
	public String type;
	public float originDistance;
	public float area;
	public float perimeter;
	public Square(int s){
		side=s;
	}
	public Point origin=new Point();
    public void setPoint(int x,int y){
    	origin.x=x;
    	origin.y=y;
    }
	public float getArea(){
		return (float)(side*side);
	}
	public float getPerimeter(){
		return (float)(2*side);
	}
	public Point getOrigin(){
		return origin;
	}
	public boolean isPointEnclosed(int x,int y){
		if((x>=origin.x && x<=(origin.x+side)) && (y>=origin.y && y<=(origin.y+side)))
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
