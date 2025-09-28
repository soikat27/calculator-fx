public class ExpOperator extends Operator {
	
	private static final int PRECEDENCE = 3;
	
	public ExpOperator()
	{
		super(PRECEDENCE);
	}
	
	public double evaluate(double a, double b)
	{
		double result = Math.pow(a, b);
		
		return result;
	}
}
