public class EqualOperator extends Operator {
    
	private static final int PRECEDENCE = -2;
	
	public EqualOperator ()
	{
		super(PRECEDENCE);
	}
	
	public double evaluate (double a, double b)
	{
		throw new UnsupportedOperationException();
	}
}