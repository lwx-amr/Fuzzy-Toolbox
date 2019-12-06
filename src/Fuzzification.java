import java.util.ArrayList;
import java.util.HashMap;

public class Fuzzification {

	// Variables
	HashMap<String, Integer> crisps;
	ArrayList<MemberShip> inputs;
	MemberShip output;
	
	// Constructor
	public Fuzzification () {
		this.inputs = new ArrayList<MemberShip>();
		this.crisps = new HashMap<>();
	}
	
	// Initialize all membership functions
	public void addNewMemberFun(MemberShip input) {
		inputs.add(input);
	}
	
	// Initialize all membership functions
	public void addOutput(MemberShip output) {
		this.output = output;
	}
	
	// Add new crisp value
	public void addNewCrisp(String fun, int value) {
		crisps.put(fun, value);
	}
	
	public void print() {
		for(int i=0; i<inputs.size() ; i++) {
			MemberShip fun = inputs.get(i);
			System.out.println("\n" + fun.linguistic + ": ");
			for(int j=0;j<fun.sets.size(); j++) {
				System.out.println(fun.sets.get(j).name + "  " + fun.sets.get(j).type);
				System.out.println(fun.sets.get(j).points.toString());
			}
		}
		
		MemberShip fun = output;
		System.out.println("\n" + fun.linguistic + ": ");
		for(int j=0;j<fun.sets.size(); j++) {
			System.out.println(fun.sets.get(j).name + "  " + fun.sets.get(j).type);
			System.out.println(fun.sets.get(j).points.toString());
		}
	}
	
}
