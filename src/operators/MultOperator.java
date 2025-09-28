public class MultOperator extends Operator {
	
	private static final int PRECEDENCE = 2;
	
	public MultOperator()
	{
		super(PRECEDENCE);
	}
	
	public double evaluate(double a, double b)
	{
		double result = a * b;
		
		return result;
	}
}