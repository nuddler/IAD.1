

/**
 * @author nuddler
 *
 */
public class Perceptron {

	/**
	 * @param expectedValue 
	 * @param sum 
	 * @param double1 
	 * @param d 
	 * @param x 
	 * @return
	 */
	public static Double calculate(Double expectedValue, Double sum, Double weight, double learningFactor, Double x) {
        int factor = 0;
        if (IdenityActivationFunction.function(sum) != expectedValue) {
            factor = expectedValue == 0 ? -1 : 1;
        } 
        return weight + learningFactor * (factor) * x;
	}
}
