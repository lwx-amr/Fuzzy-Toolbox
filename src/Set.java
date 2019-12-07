import java.util.ArrayList;

public class Set {

	// Variables
	String name , type;
	ArrayList<Integer> points;
	
	// Constructor
	public Set(String name , String type, ArrayList<Integer> points){
		this.name  = name ;
		this.type = type;
		this.points = points;
	}
	
	// Find whether value in set range or not
	public boolean inRange(int value) {
		if( value>=points.get(0) && value<=points.get(points.size()-1))
				return true;
		return false;
	}

}
