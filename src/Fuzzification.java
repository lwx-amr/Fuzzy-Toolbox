import java.util.ArrayList;
import java.util.HashMap;

public class Fuzzification {

	// Variables
	HashMap<String, MemberShip> inputs;
	MemberShip output;
	
	// Constructor
	public Fuzzification () {
		this.inputs = new HashMap<String, MemberShip>();
	}
	
	// Initialize all membership functions
	public void addNewMemberFun(MemberShip input) {
		inputs.put(input.linguistic,input);
	}
	
	// Initialize all membership functions
	public void addOutput(MemberShip output) {
		this.output = output;
	}
	
	// Get fuzzy values for some member function
	public ArrayList<FuzzyValue> getFuzzyValues(String name,  int value){
		return inputs.get(name).getFuzzyValues(value);
	}
	
	public void print() {
		for (String ling: inputs.keySet()){
			MemberShip fun = inputs.get(ling);
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
