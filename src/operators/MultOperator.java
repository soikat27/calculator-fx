package operators;

/**
 * The {@code MultOperator} class represents the multiplication operator {@code (*)}.
 * <p>
 * This operator has a precedence of {@code 2}, which is higher than addition 
 * and subtraction, but lower than exponentiation.
 * </p>
 */
public class MultOperator extends Operator {
	
	/** 
     * The precedence level for multiplication. 
     * Higher than addition and subtraction, lower than exponentiation.
     */
	private static final int PRECEDENCE = 2;
	
	/**
     * Constructs a {@code MultOperator} with predefined precedence.
     */
	public MultOperator()
	{
		super(PRECEDENCE);
	}
	
	/**
     * Evaluates the product of two operands.
     *
     * @param a the left-hand operand
     * @param b the right-hand operand
     * @return the result of {@code a * b}
     */
    @Override
	public double evaluate(double a, double b)
	{
		double result = a * b;
		
		return result;
	}
}