import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nuddler
 *
 */
public class MultiLayerPerceptronProject {

	static List<Double> points = new ArrayList<Double>();
	static MultiLayerPerceptron multiLayerPerceptron;

	public static void main(String[] args) throws FileNotFoundException {
		
		List<ArrayList<Double>> inputList = readInputFromFile();
		
		int hiddenLayerNeuronCount = 1;
		int outputLayerNeuronCount = 4;
		int inputLayerNeuronCount = 1;
		double lerningFactory = 0.1;
		
		multiLayerPerceptron = new MultiLayerPerceptron(inputList,hiddenLayerNeuronCount,inputLayerNeuronCount,outputLayerNeuronCount,lerningFactory);
		
		multiLayerPerceptron.learn();
	}
	
	public static ArrayList<ArrayList<Double>> readInputFromFile() throws FileNotFoundException{
		ArrayList<ArrayList<Double>> input = new ArrayList<ArrayList<Double>>();
		Scanner scanner = new Scanner(new File("input"));
		ArrayList<Double> row = new ArrayList<Double>();
		
		int i = 1;
		while(scanner.hasNextDouble()){			
			row.add(scanner.nextDouble());
			
			if (i%4==0){
				ArrayList<Double> temp = new ArrayList<Double>(row);
				input.add(temp);
				row.clear();
			}
			i++;
		}
		return input;	
	}

}
