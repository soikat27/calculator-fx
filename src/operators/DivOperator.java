public class DivOperator extends Operator {
	
	private static final int PRECEDENCE = 2;
	
	public DivOperator()
	{
		super(PRECEDENCE);
	}
	
	public double evaluate(double a, double b)
	{
		double result = a / b;
		
		return result;
	}
}
