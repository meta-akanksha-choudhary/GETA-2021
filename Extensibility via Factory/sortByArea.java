import java.util.Comparator;


public class sortByArea implements Comparator<Shape>{
	public int compare(Shape a, Shape b){
		return (int)a.getArea()-(int)b.getArea();
	}

}
