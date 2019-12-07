import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FuzzyToolBox {

	// Variables
	private String filename;
	private Fuzzification fuzzification;
	private Scanner scanner;
	private HashMap<String, Integer> crisps;
	
	
	// Constructor
	public FuzzyToolBox () {
		this.filename = "input.txt";
		fuzzification = new Fuzzification();
		this.crisps = new HashMap<>();
	}
	
	// Add new crisp value
	public void addNewCrisp(String fun, int value) {
		crisps.put(fun, value);
	}
	
	// Read inputs
	public void readMemFun(Scanner scanner) {
		int inputsNum = 0, value = 0, setsNum = 0;
		String ling, name, type;
		Set newSet;
		MemberShip mFun;
		ArrayList<Integer> points;
		inputsNum = scanner.nextInt(); 
		for (int i = 0; i < inputsNum +1; i++) {
			ling = scanner.next();
			if(i!=inputsNum) {
				value = scanner.nextInt();
			}
			setsNum = scanner.nextInt();
			mFun = new MemberShip(ling);
			for (int j = 0; j < setsNum; j++) {
				points = new ArrayList<Integer>();
				name = scanner.next();
				type= scanner.next();
				int num = (type.equals("trapezoidal"))? 4 : 3;
				for(int k=0; k<num ; k++) {
					points.add(Integer.parseInt(scanner.next()));
				}
				newSet = new Set(name, type, points);
				mFun.sets.add(newSet);
			}
			if(i!=inputsNum) {
				addNewCrisp(ling, value);
				fuzzification.addNewMemberFun(mFun);
			}else {
				fuzzification.addOutput(mFun);
			}
		}
	}
	
	// Function to execute the full program
	public void execute() {
		try {
			scanner = new Scanner(new File(filename));
			readMemFun(scanner);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<FuzzyValue> results;
		for (String name: crisps.keySet()){
			results = fuzzification.getFuzzyValues(name, crisps.get(name));
			for(int i=0; i< results.size(); i++) {
				System.out.println(results.get(i).value + results.get(i).name);
			}
		} 
	}
	
	public static void main (String args[]) {
		FuzzyToolBox obj = new FuzzyToolBox();
		obj.execute();
	}
	
}
