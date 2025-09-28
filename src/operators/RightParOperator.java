public class RightParOperator extends Operator {
	
	private static final int PRECEDENCE = 0;
	
	public RightParOperator()
	{
		super(PRECEDENCE);
	}
	
	public double evaluate(double a, double b)
	{
		throw new UnsupportedOperationException();
	}
}