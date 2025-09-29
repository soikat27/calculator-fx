package operators;

/**
 * The {@code Operator} class represents an abstract mathematical operator 
 * (e.g., addition, subtraction, multiplication, division).
 * <p>
 * Each operator has an associated precedence level, which determines 
 * the order in which operations are performed during expression evaluation.
 * Higher precedence operators are evaluated before lower precedence operators.
 * </p>
 */
public abstract class Operator {
	
	/** 
     * The precedence level of this operator.
     * Higher values indicate higher precedence.
     */
	private int precedence;
	
	/**
     * Constructs an {@code Operator} with the specified precedence.
     *
     * @param prec the precedence level of this operator
     */
	public Operator(int prec)
	{
		precedence = prec;
	}
	
	/**
     * Returns the precedence level of this operator.
     *
     * @return the precedence level
     */
	public int getPrecedence()
	{
		return precedence;
	}
	
	/**
     * Evaluates this operator on two operands.
     * 
     * @param a the left-hand operand
     * @param b the right-hand operand
     * @return the result of applying the operator to {@code a} and {@code b}
     */
	public abstract double evaluate(double a, double b);
}
