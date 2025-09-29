package operators;

/**
 * The {@code DivOperator} class represents the division operator {@code (/)}.
 * <p>
 * This operator has a precedence of {@code 2}, the same as multiplication, 
 * which is higher than addition and subtraction but lower than exponentiation.
 * </p>
 */
public class DivOperator extends Operator {
	
	/** 
     * The precedence level for division. 
     * Same as multiplication, higher than addition and subtraction.
     */
	private static final int PRECEDENCE = 2;
	
	/**
     * Constructs a {@code DivOperator} with predefined precedence.
     */
	public DivOperator()
	{
		super(PRECEDENCE);
	}
	
	/**
     * Evaluates the quotient of two operands.
     *
     * @param a the left-hand operand (numerator)
     * @param b the right-hand operand (denominator)
     * @return the result of {@code a / b}
     * @throws ArithmeticException if {@code b == 0}
     */
    @Override
	public double evaluate(double a, double b)
	{
		double result = a / b;
		
		return result;
	}
}
