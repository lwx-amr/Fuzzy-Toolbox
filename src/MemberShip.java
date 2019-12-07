import java.text.DecimalFormat;
import java.util.ArrayList;

public class MemberShip {

	// Variables
	String linguistic;
	ArrayList<Set> sets;
	
	// Constructor
	public MemberShip(String linguistic) {
		this.sets = new ArrayList<Set>();
		this.linguistic = linguistic;
	}
	
	// Get slope 
	public double getSlope(Point a, Point b){
		return (b.y - a.y)/(b.x - a.x);
	}
	
	// Find value in triangle shap
	public double findInTraingle(int value, Set currentSet) {
		double result, slope, B;
		Point a, b;
		if(value <= currentSet.points.get(1)) {
			a = new Point(currentSet.points.get(0), 0);
			b = new Point(currentSet.points.get(1), 1);
		}
		else {
			a = new Point(currentSet.points.get(1), 1);
			b = new Point(currentSet.points.get(2), 0);
		}
		slope = getSlope(a,b);
		B = a.y - (slope*a.x);
		DecimalFormat df = new DecimalFormat("#.##");
		result = Double.parseDouble(df.format(slope*value)) + B;
		return result;
	}
	
	// Find value in triangle shap
	public double findInTrapezoidal(int iValue, Set currentSet) {
		double result, slope, B, value;
		value = (double) iValue;
		Point a, b;
		if(currentSet.points.get(0) == currentSet.points.get(1)) {
			if(value <= currentSet.points.get(2)) {
				result = 1;
			}
			else {
				a = new Point(currentSet.points.get(2), 1);
				b = new Point(currentSet.points.get(3), 0);
				slope = getSlope(a,b);
				B = a.y - (slope*a.x);
				DecimalFormat df = new DecimalFormat("#.##");
				result = Double.parseDouble(df.format(slope*value)) + B;
			}
		}else {
			if(value >= currentSet.points.get(1)) {
				result = 1;
			}
			else {
				a = new Point(currentSet.points.get(0), 0);
				b = new Point(currentSet.points.get(1), 1);
				slope = getSlope(a,b);
				B = a.y - (slope*a.x);
				DecimalFormat df = new DecimalFormat("#.##");
				result = Double.parseDouble(df.format(slope*value)) + B;
			}
		}
		return result;
	}
	
	// Get fuzzy value after using equations
	public ArrayList<FuzzyValue> getFuzzyValues(int value){
		ArrayList<FuzzyValue> results = new ArrayList<FuzzyValue>();
		FuzzyValue result = null;
		double calcedValue = 0;
		Set currentSet;
		for(int i=0; i<sets.size() ; i++) {
			currentSet = sets.get(i);
			if(!currentSet.inRange(value))
				continue;
			if(currentSet.type.equals("triangle"))
				calcedValue = findInTraingle(value, currentSet);	
			else if(currentSet.type.equals("trapezoidal"))
				calcedValue = findInTrapezoidal(value, currentSet);	
			result = new FuzzyValue(currentSet.name, calcedValue);
			results.add(result);		
		}
		return results;
	}
	
	/*public static void main (String args[]) {
		MemberShip obj = new MemberShip("Amr"); 
		int value = 30;
		ArrayList<Integer> points = new ArrayList<Integer>();
		points.add(0);
		points.add(0);
		points.add(50);
		Set currentSet = new Set("left", "triangle", points);
		System.out.println(obj.findInTraingle(value, currentSet));
		
		MemberShip obj = new MemberShip("Amr"); 
		int value = 60;
		ArrayList<Integer> points = new ArrayList<Integer>();
		points.add(50);
		points.add(70);
		points.add(100);
		points.add(100);
		Set currentSet = new Set("left", "trapezoidal", points);
		System.out.println(obj.findInTrapezoidal(value, currentSet));	
	}*/
}
