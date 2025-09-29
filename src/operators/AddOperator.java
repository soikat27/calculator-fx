package operators;

/**
 * The {@code AddOperator} class represents the addition operator {@code (+)}.
 * <p>
 * This operator has a precedence of {@code 1}, which is lower than 
 * multiplication or exponentiation, but higher than parentheses handling.
 * </p>
 */
public class AddOperator extends Operator{
	
	/** 
     * The precedence level for addition. 
     * Lower than multiplication and exponentiation. 
     */
	private static final int PRECEDENCE = 1;
	
	/**
     * Constructs an {@code AddOperator} with predefined precedence.
     */
	public AddOperator()
	{
		super(PRECEDENCE);
	}
	
	/**
     * Evaluates the sum of two operands.
     *
     * @param a the left-hand operand
     * @param b the right-hand operand
     * @return the result of {@code a + b}
     */
	@Override
	public double evaluate(double a, double b)
	{
		double result = a + b;
		
		return result;
	}
}
