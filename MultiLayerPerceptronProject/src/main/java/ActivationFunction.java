
/**
 * @author nuddler
 *
 */
public abstract class ActivationFunction {

	/**
	 * @param generateSum
	 * @return
	 */
	public abstract Double activate(Double generateSum);
	public abstract Double differentiate(Double generateSum);
}
