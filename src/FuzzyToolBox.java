import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FuzzyToolBox {

	// Variables
	String filename;
	Fuzzification fuzzification;
	private Scanner scanner;
	
	// Constructor
	public FuzzyToolBox () {
		this.filename = "input.txt";
		fuzzification = new Fuzzification();
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
				fuzzification.addNewMemberFun(mFun);
				fuzzification.addNewCrisp(ling, value);
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
		fuzzification.print();
	}
	
	public static void main (String args[]) {
		FuzzyToolBox obj = new FuzzyToolBox();
		obj.execute();
	}
	
}
