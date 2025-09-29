package operators;

/**
 * The {@code SubtOperator} class represents the subtraction operator {@code (-)}.
 * <p>
 * This operator has a precedence of {@code 1}, the same as addition, 
 * and lower than multiplication or exponentiation.
 * </p>
 */
public class SubtOperator extends Operator {
	
	/** 
     * The precedence level for subtraction. 
     * Same as addition, lower than multiplication and exponentiation.
     */
	private static final int PRECEDENCE = 1;
	
	/**
     * Constructs a {@code SubtOperator} with predefined precedence.
     */
	public SubtOperator()
	{
		super(PRECEDENCE);
	}
	
	/**
     * Evaluates the difference between two operands.
     *
     * @param a the left-hand operand
     * @param b the right-hand operand
     * @return the result of {@code a - b}
     */
	@Override
	public double evaluate(double a, double b)
	{
		double result = a - b;
		
		return result;
	}
}