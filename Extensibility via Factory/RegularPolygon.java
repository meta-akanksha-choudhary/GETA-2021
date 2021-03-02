import java.sql.Timestamp;
import java.util.Date;
import java.lang.Math;
public class RegularPolygon implements Shape{
	public int side;
	public int height;
	public int num_sides;
	public Date date;
	public Timestamp ts;
	public String type;
	public float originDistance;
	public float area;
	public float perimeter;
	public RegularPolygon(int s,int h,int nside ){
		side=s;
		height=h;
		num_sides=nside;
	}
	public Point origin=new Point();
    public void setPoint(int x,int y){
    	origin.x=x;
    	origin.y=y;
    }
	public float getArea(){
		return (float)(num_sides*height*side*0.5);
	}
	public float getPerimeter(){
		return (float)(2*(num_sides*side));
	}
	public Point getOrigin(){
		return origin;
	}
	public boolean isPointEnclosed(int x,int y){
		if((x>=origin.x && x<=(origin.x+side)) && (y>=origin.y && y<=(origin.y+(2*height))) )
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
