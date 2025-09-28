public class LeftParOperator extends Operator {
	
	private static final int PRECEDENCE = -1;
	
	public LeftParOperator()
	{
		super(PRECEDENCE);
	}
	
	public double evaluate(double a, double b)
	{
		throw new UnsupportedOperationException();
	}
}