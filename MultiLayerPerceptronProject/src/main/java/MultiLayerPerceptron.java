import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author nuddler
 *
 */
public class MultiLayerPerceptron {

	/**
	 * @param outputLayerNeuronCount 
	 * @param inputLayerNeuronCount 
	 * @param hiddenLayerNeuronCount 
	 * @param inputList 
	 * 
	 */
	private List<Neuron> inputLayer = new ArrayList<Neuron>();
	
	private List<Neuron> hiddenLayer = new ArrayList<Neuron>();
	
	private List<Neuron> outputLayer = new ArrayList<Neuron>();

	private List<ArrayList<Double>> inputList;

	private double lerningFactory;
	
	public MultiLayerPerceptron(List<ArrayList<Double>> inputList, int inputLayerNeuronCount, int hiddenLayerNeuronCount, int outputLayerNeuronCount,double lerningFactory) {
		
		this.inputList = inputList;
		
		this.lerningFactory = lerningFactory;
		
		for(int i=0; i < inputLayerNeuronCount; i++) {
			inputLayer.add(new Neuron(inputList.size(), "sigmoidal"));
		}
		
		for(int i=0; i < hiddenLayerNeuronCount; i++) {
			hiddenLayer.add(new Neuron(inputLayerNeuronCount, "sigmoidal"));
		}
		
		for(int i=0; i < outputLayerNeuronCount; i++) {
			outputLayer.add(new Neuron(outputLayerNeuronCount, "sigmoidal"));
		}
	}
	
	/**
	 * 
	 */
	private void doEpoch() {
		for (int i = 0; i < inputList.size(); i++) {

			List<Double> inputLayerOutput = calculateLayer(inputLayer,inputList.get(i));
			List<Double> hiddenLayerOutput = calculateLayer(hiddenLayer,inputLayerOutput);
			List<Double> mlpOutput = calculateLayer(outputLayer,hiddenLayerOutput);

			calculateErrors(mlpOutput,inputList.get(i));
			propagateErrors(lerningFactory);
		}
	}
	
	/**
	 * @param mlpOutput
	 * @param inputLayerOutput 
	 * @param hiddenLayerOutput 
	 */
	private void propagateErrors(double lerningFactory) {
		for (Neuron neuron : inputLayer) {
			neuron.propage(lerningFactory);
		}
		for (Neuron neuron : outputLayer) {
			neuron.propage(lerningFactory);
		}
		for (Neuron neuron : hiddenLayer) {
			neuron.propage(lerningFactory);
		}
	}

	private void calculateErrors(List<Double> mlpOutput, List<Double> list) {
		
		for (int i=0; i < outputLayer.size(); i++) {
			double delta = (list.get(i) -  mlpOutput.get(i)) * outputLayer.get(i).getActivaionFunctionDerivative();
			outputLayer.get(i).setDelta(delta);
		}
		
		for(int i=0; i < hiddenLayer.size(); i++) {
			double delta = 0;
			for (int j=0; j < outputLayer.size(); j++) {
				delta += outputLayer.get(j).getDelta() *  outputLayer.get(j).getWeights().get(j);
			}
			delta *= hiddenLayer.get(i).getActivaionFunctionDerivative();
			hiddenLayer.get(i).setDelta(delta);
		}
		
		for(int i=0; i < inputLayer.size(); i++) {
			double delta = 0;
			for (int j=0; j < hiddenLayer.size(); j++) {
				delta += hiddenLayer.get(j).getDelta() *  hiddenLayer.get(j).getWeights().get(j);
			}
			delta *= inputLayer.get(i).getActivaionFunctionDerivative();
			inputLayer.get(i).setDelta(delta);
		}
	}

	/**
	 * @param layer
	 * @param inputList
	 * @return
	 */
	private List<Double> calculateLayer(List<Neuron> layer, List<Double> inputList) {
		
		List<Double> outputList = new ArrayList<Double>();
		for (Neuron neuron : layer) {
			outputList.add(neuron.getOutput(inputList));
		}
		return outputList;
	}
	
	/**
	 * 
	 */
	public void learn() {
		
		if(true) {//waurnek bledu napisa�
			doEpoch();
		}
		
	}

	public List<Neuron> getInputLayer() {
		return inputLayer;
	}

	public void setInputLayer(List<Neuron> inputLayer) {
		this.inputLayer = inputLayer;
	}

	public List<Neuron> getHiddenLayer() {
		return hiddenLayer;
	}

	public void setHiddenLayer(List<Neuron> hiddenLayer) {
		this.hiddenLayer = hiddenLayer;
	}

	public List<Neuron> getOutputLayer() {
		return outputLayer;
	}

	public void setOutputLayer(List<Neuron> outputLayer) {
		this.outputLayer = outputLayer;
	}

	public List<ArrayList<Double>> getInputList() {
		return inputList;
	}

	public void setInputList(List<ArrayList<Double>> inputList) {
		this.inputList = inputList;
	}

}
