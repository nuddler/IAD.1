/**
 * 
 */

/**
 * @author nuddler
 *
 */
public class IdenityActivationFunction extends ActivationFunction {

	/**
	 * 
	 */
	public IdenityActivationFunction() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ActivationFunction#activate(java.lang.Double)
	 */
	@Override
	public Double activate(Double generateSum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Double function(Double sum) {
		
		return (double) (sum >=1 ? 1 : 0);
		
	}

	@Override
	public Double differentiate(Double generateSum) {
		// TODO Auto-generated method stub
		return null;
	}

}
