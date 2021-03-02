import java.util.Comparator;


public class sortByTimestamp implements Comparator<Shape>{
	public int compare(Shape a, Shape b){
		return a.getTimestamp().compareTo(b.getTimestamp());
	}

}
