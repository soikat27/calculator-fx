package operators;

/**
 * The {@code LeftParOperator} class represents a left parenthesis {@code (}.
 * <p>
 * This is not a real arithmetic operator. Instead, it acts as a marker in 
 * the expression parsing process to indicate the beginning of a sub-expression.
 * </p>
 * <p>
 * Its precedence is set to {@code -1}, which ensures that it will not be 
 * evaluated like normal operators. Instead, it is handled by the parser 
 * to manage operator precedence and grouping.
 * </p>
 */
public class LeftParOperator extends Operator {
	
	/** 
     * Precedence level for the left parenthesis marker. 
     */
	private static final int PRECEDENCE = -1;
	
	/**
     * Constructs a {@code LeftParOperator}.
     */
	public LeftParOperator()
	{
		super(PRECEDENCE);
	}
	
	/**
     * This method is unsupported because a left parenthesis cannot be evaluated.
     *
     * @param a unused
     * @param b unused
     * @throws UnsupportedOperationException always, since parentheses are not operators
     */
    @Override
	public double evaluate(double a, double b)
	{
		throw new UnsupportedOperationException();
	}
}