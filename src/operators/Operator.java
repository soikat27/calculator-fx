public abstract class Operator {
	
	private int precedence;
	
	public Operator(int prec)
	{
		precedence = prec;
	}
	
	public int getPrecedence()
	{
		return precedence;
	}
	
	public abstract double evaluate(double a, double b);
}
