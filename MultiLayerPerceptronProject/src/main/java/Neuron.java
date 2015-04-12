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
	
	private double bias = 0;
	

	public Neuron(int inputCount, String activationFunction, boolean bias) {
		super();
        Random rn = new Random();
        weights = new ArrayList<Double>();
        //weights.add((double) rn.nextInt(100) / 500);
        for (int i = 0; i < inputCount; i++) {
            weights.add((double) rn.nextInt(100) / 400);
        }
        
        if(bias) {
        	this.bias = (double) rn.nextInt(100) / 400;
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
		if(bias != 0) {
			sum += 1 * bias;
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
		for (int i = 0; i < weights.size(); i++) {
			Double newWeight = weights.get(i) +  (delta * lastInputs.get(i) * learningFactory);
			weights.set(i, newWeight);
		}
		if(bias != 0) {
			bias += delta * 1 * learningFactory;
		}
	}

	public Double getOutput(List<Double> inputList) {
		if(inputList != null) { //je¿eli nie podamy listy z wejœciem, podajemy ostatni sygna³ pobudzenia aktywowany 
			this.lastSignal = generateSum(inputList);
		}
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

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}


}
