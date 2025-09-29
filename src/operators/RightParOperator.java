package operators;

/**
 * The {@code RightParOperator} class represents a right parenthesis {@code )}.
 * <p>
 * Like the {@link LeftParOperator}, this is not a real arithmetic operator. 
 * Instead, it is used by the parser to mark the end of a sub-expression. 
 * </p>
 * <p>
 * Its precedence is set to {@code 0}, which allows the parser to detect when 
 * evaluation should continue until a matching left parenthesis is found.
 * </p>
 */
public class RightParOperator extends Operator {
	
	/** 
     * Precedence level for the right parenthesis marker. 
     * Set to 0 so it interacts properly with expression parsing logic. 
     */
	private static final int PRECEDENCE = 0;
	
	/**
     * Constructs a {@code RightParOperator}.
     */
	public RightParOperator()
	{
		super(PRECEDENCE);
	}
	
	/**
     * This method is unsupported because a right parenthesis cannot be evaluated.
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