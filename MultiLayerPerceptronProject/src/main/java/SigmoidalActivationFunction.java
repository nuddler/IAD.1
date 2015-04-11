/**
 * 
 */

/**
 * @author nuddler
 *
 */
public class SigmoidalActivationFunction extends ActivationFunction {

	/**
	 * 
	 */
	public SigmoidalActivationFunction() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ActivationFunction#activate(java.lang.Double)
	 */
	@Override
	public Double activate(Double generateSum) {
		return 1 / (1 + Math.pow(Math.E, -generateSum));
	}

	@Override
	public Double differentiate(Double generateSum) {
		//e^x/(1+e^x)^2
        double eToX = Math.pow(Math.E,generateSum);
        return eToX/Math.pow(eToX+1, 2);
	}

}
