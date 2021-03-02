
import java.util.Comparator;
public class sortByPerimeter implements Comparator<Shape> {
	public int compare(Shape a, Shape b){
		return (int)a.getPerimeter()-(int)b.getPerimeter();
	}

}
