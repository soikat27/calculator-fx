package operators;

/**
 * The {@code EqualOperator} class represents the equals operator {@code =}.
 * <p>
 * This operator does not perform arithmetic. Instead, it is used as a 
 * signal to the calculator to evaluate the entire expression currently 
 * on the stack.
 * </p>
 * <p>
 * Its precedence is set to {@code -2}, ensuring that all other operators 
 * on the stack are evaluated before it triggers the final computation.
 * </p>
 */
public class EqualOperator extends Operator {
    
	/** 
     * Precedence level for the equals operator. 
     * Negative to ensure all other operators are evaluated first.
     */
	private static final int PRECEDENCE = -2;
	
	/**
     * Constructs an {@code EqualOperator}.
     */
	public EqualOperator ()
	{
		super(PRECEDENCE);
	}
	
	/**
     * This method is unsupported because {@code =} is not a mathematical operator.
     *
     * @param a unused
     * @param b unused
     * @throws UnsupportedOperationException always, since equals is not an operator
     */
    @Override
	public double evaluate (double a, double b)
	{
		throw new UnsupportedOperationException();
	}
}