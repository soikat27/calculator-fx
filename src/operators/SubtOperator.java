public class SubtOperator extends Operator {
	
	private static final int PRECEDENCE = 1;
	
	public SubtOperator()
	{
		super(PRECEDENCE);
	}
	
	public double evaluate(double a, double b)
	{
		double result = a - b;
		
		return result;
	}
}