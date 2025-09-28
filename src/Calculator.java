import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import operators.*;

public class Calculator extends Application {
    
    // the calculator dimensions
	public static int CALC_WIDTH  = 400;
	public static int CALC_HEIGHT = 200;

    // the calculator screen
	private TextField screen;

    // stacks
	private Stack<Operator> operator;
	private Stack<Double>   operand;

    // operand string
	private String num;

    // the calculator buttons
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;

	private Button buttonPlus;
	private Button buttonMinus;
	private Button buttonMult;
	private Button buttonDiv;

	private Button buttonExp;

	private Button buttonLPar;
	private Button buttonRPar;

	private Button buttonDot;

	private Button buttonClear;
	private Button buttonEqual;

    @Override
    public void start(Stage primaryStage) 
    {
        // create the calculator screen
		screen = new TextField();

		// create the buttons
		button0 = new Button("0");
		button1 = new Button("1");
		button2 = new Button("2");
		button3 = new Button("3");
		button4 = new Button("4");
		button5 = new Button("5");
		button6 = new Button("6");
		button7 = new Button("7");
		button8 = new Button("8");
		button9 = new Button("9");
		
		buttonPlus = new Button("+");
		buttonMinus = new Button("-");
		buttonMult = new Button("*");
		buttonDiv = new Button("/");
		buttonExp = new Button("^");	

		buttonLPar = new Button("(");
		buttonRPar = new Button(")");

		buttonDot = new Button(".");
		buttonEqual = new Button("=");
		buttonClear = new Button("C");

        // instantiate the stacks
		operator = new Stack<Operator> ();
		operand  = new Stack<Double> ();

        // instantiate the string operand
		num = "";

        // attach a handler to process button clicks
		ButtonHandler handler = new ButtonHandler();

		button0.setOnAction(handler);
		button1.setOnAction(handler);
		button2.setOnAction(handler);
		button3.setOnAction(handler);
		button4.setOnAction(handler);
		button5.setOnAction(handler);
		button6.setOnAction(handler);
		button7.setOnAction(handler);
		button8.setOnAction(handler);
		button9.setOnAction(handler);

		buttonPlus.setOnAction(handler);
		buttonMinus.setOnAction(handler);
		buttonMult.setOnAction(handler);
		buttonDiv.setOnAction(handler);

		buttonExp.setOnAction(handler);

		buttonLPar.setOnAction(handler);
		buttonRPar.setOnAction(handler);

		buttonDot.setOnAction(handler);

		buttonEqual.setOnAction(handler);
		buttonClear.setOnAction(handler);

        // setup a grid panel for the keypad
		GridPane keypad = new GridPane();

		keypad.setMinSize(CALC_WIDTH, CALC_HEIGHT); 
		keypad.setPadding(new Insets(5, 5, 5, 5));

		keypad.setVgap(5); 
		keypad.setHgap(5);

		keypad.setAlignment(Pos.CENTER);

        // attach the buttons to the keypad grid
		keypad.add(button0, 0, 3);
		keypad.add(button1, 0, 0); 
		keypad.add(button2, 1, 0); 
		keypad.add(button3, 2, 0);       
		keypad.add(button4, 0, 1);
		keypad.add(button5, 1, 1); 
		keypad.add(button6, 2, 1); 
		keypad.add(button7, 0, 2);       
		keypad.add(button8, 1, 2);
		keypad.add(button9, 2, 2);

		keypad.add(buttonPlus, 3, 0); 
		keypad.add(buttonMinus, 4, 0);       
		keypad.add(buttonMult, 3, 1);
		keypad.add(buttonDiv, 4, 1);
		keypad.add(buttonExp, 3, 3);

		keypad.add(buttonLPar, 3, 2);       
		keypad.add(buttonRPar, 4, 2);

		keypad.add(buttonDot, 1, 3);
		keypad.add(buttonEqual, 2, 3);
		keypad.add(buttonClear, 4, 3);

        // put screen and keypad together
		BorderPane gui = new BorderPane();

		gui.setTop(screen);
		gui.setCenter(keypad);

        // set up the scene
		Scene scene = new Scene(gui);

		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);

		primaryStage.show();
    }

    // Handler for processing the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>
	{ 
		@Override 
		public void handle(ActionEvent e) 
		{
			if (e.getSource() == button0)
			{

				screen.appendText("0");

				num += "0";
			}
			else if (e.getSource() == button1)
			{

				screen.appendText("1");

				num += "1";
			}
			else if (e.getSource() == button2)
			{

				screen.appendText("2");

				num += "2";
			}
			else if (e.getSource() == button3)
			{

				screen.appendText("3");

				num += "3";
			}
			else if (e.getSource() == button4)
			{

				screen.appendText("4");

				num += "4";
			}
			else if (e.getSource() == button5)
			{

				screen.appendText("5");

				num += "5";
			}
			else if (e.getSource() == button6)
			{

				screen.appendText("6");

				num += "6";
			}
			else if (e.getSource() == button7)
			{

				screen.appendText("7");

				num += "7";
			}
			else if (e.getSource() == button8)
			{

				screen.appendText("8");

				num += "8";
			}
			else if (e.getSource() == button9)
			{

				screen.appendText("9");

				num += "9";
			}


			else if (e.getSource() == buttonPlus)
			{

				pushMultiDigit ();

				screen.appendText("+");

				Operator add = new AddOperator ();

				operate (add);
			}
			else if (e.getSource() == buttonMinus)
			{

				pushMultiDigit ();

				screen.appendText("-");

				Operator subt = new SubtOperator ();

				operate (subt);
			}
			else if (e.getSource() == buttonMult)
			{

				pushMultiDigit ();

				screen.appendText("*");

				Operator mult = new MultOperator ();

				operate (mult);
			}
			else if (e.getSource() == buttonDiv)
			{

				pushMultiDigit ();

				screen.appendText("/");

				Operator div = new DivOperator ();

				operate (div);
			}


			else if (e.getSource() == buttonExp)
			{

				pushMultiDigit ();

				screen.appendText("^");

				Operator exp = new ExpOperator ();

				operate (exp);
			}


			else if (e.getSource() == buttonLPar)
			{

				screen.appendText("(");

				Operator lPar = new LeftParOperator ();

				operator.push(lPar);
			}
			else if (e.getSource() == buttonRPar)
			{

				pushMultiDigit ();

				screen.appendText(")");

				Operator rPar = new RightParOperator ();

				operate (rPar);

				operator.pop(); // to get rid of right parenthesis
				operator.pop(); // to get rid of left parenthesis
			}


			else if (e.getSource() == buttonDot)
			{

				screen.appendText(".");

				num += ".";
			}


			else if (e.getSource() == buttonEqual)
			{

				pushMultiDigit ();

				Operator equal = new EqualOperator ();

				operate (equal);

				screen.setText(String.valueOf(operand.peek()));

				operator.clear();
				operand.clear();
			}
			else if (e.getSource() == buttonClear)
			{

				num = "";

				operand.clear();
				operator.clear();

				screen.clear();
			}
		}  
	}

    public void operate(Operator curOperator)
	{
		int curPrec = curOperator.getPrecedence();

		while (!operator.isEmpty() && operator.peek().getPrecedence() >= curPrec)
		{
			Operator topStackOperator = operator.pop();

			double b = operand.pop();
			double a = operand.pop();

			double intResult = topStackOperator.evaluate(a, b);

			operand.push(intResult);
		}

		operator.push(curOperator);
	}

    public void pushMultiDigit()
	{
		if (num != "")
		{
			double curNumber = Double.parseDouble(num);

			operand.push(curNumber);
			num = "";
		}
	}

    public static void main(String[] args) 
    {
        launch(args);
    }
}
