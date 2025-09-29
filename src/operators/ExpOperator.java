package operators;

/**
 * The {@code ExpOperator} class represents the exponentiation operator {@code (^)}.
 * <p>
 * This operator has a precedence of {@code 3}, which is higher than 
 * multiplication, division, addition, and subtraction.
 * </p>
 */
public class ExpOperator extends Operator {
	
	/** 
     * The precedence level for exponentiation. 
     * Highest among the basic operators in this calculator.
     */
	private static final int PRECEDENCE = 3;
	
	/**
     * Constructs an {@code ExpOperator} with predefined precedence.
     */
	public ExpOperator()
	{
		super(PRECEDENCE);
	}
	
	/**
     * Evaluates the result of raising one operand to the power of another.
     *
     * @param a the base value
     * @param b the exponent value
     * @return the result of {@code a ^ b} (i.e., {@code Math.pow(a, b)})
     */
    @Override
	public double evaluate(double a, double b)
	{
		double result = Math.pow(a, b);
		
		return result;
	}
}
