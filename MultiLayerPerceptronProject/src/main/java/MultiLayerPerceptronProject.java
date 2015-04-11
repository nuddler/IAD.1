import java.util.ArrayList;
import java.util.List;

/**
 * @author nuddler
 *
 */
public class MultiLayerPerceptronProject {

	static List<Double> points = new ArrayList<Double>();
	static MultiLayerPerceptron multiLayerPerceptron;

	public static void main(String[] args) {
		
		List<Double> inputList = null;
		
		int hiddenLayerNeuronCount = 0;
		int outputLayerNeuronCount = 0;
		int inputLayerNeuronCount = 0;
		double lerningFactory = 0;
		
		multiLayerPerceptron = new MultiLayerPerceptron(inputList,hiddenLayerNeuronCount,inputLayerNeuronCount,outputLayerNeuronCount,lerningFactory);
		
		multiLayerPerceptron.learn();
	}

}
