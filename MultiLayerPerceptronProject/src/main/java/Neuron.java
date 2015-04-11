import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author nuddler
 *
 */
public class Neuron {

	private List<Double> weights;
	
	private ActivationFunction activationFunction;
	
	private double delta;
	
	private double lastSignal;
	
	private List<Double> lastInputs;
	

	public Neuron(int inputCount, String activationFunction) {
		super();
        Random rn = new Random();
        weights = new ArrayList<Double>();
        //weights.add((double) rn.nextInt(100) / 500);
        for (int i = 0; i < inputCount; i++) {
            weights.add((double) rn.nextInt(100) / 500);
        }
        if(activationFunction.equals("sigmoidal")) {
        	this.activationFunction = new SigmoidalActivationFunction(); 
        }
	}

	private Double generateSum(List<Double> inputList) {
		this.lastInputs = inputList;
		Double sum = 0D;
		for (int i = 0; weights.size() > i; i++) {

			sum += inputList.get(i) * weights.get(i);
		}
		return sum;
	}
	
	public Double getActivaionFunctionDerivative() {
		return activationFunction.differentiate(lastSignal);
	}
	/**
	 * 
	 */
	public void propage(double learningFactory) {
			
	}

	public Double getOutput(List<Double> inputList) {
		
		this.lastSignal = generateSum(inputList);
		return activationFunction.activate(lastSignal);
	}
	
	public List<Double> getWeights() {
		return weights;
	}

	public ActivationFunction getActivationFunction() {
		return activationFunction;
	}

	public void setActivationFunction(ActivationFunction activationFunction) {
		this.activationFunction = activationFunction;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public double getDelta() {
		return delta;
	}

	public double getSignal() {
		return lastSignal;
	}

	public void setSignal(double signal) {
		this.lastSignal = signal;
	}


}
