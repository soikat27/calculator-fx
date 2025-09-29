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

/**
 * {@code Calculator} is a JavaFX-based GUI calculator application that
 * supports basic arithmetic operations (+, -, *, /), exponentiation (^),
 * parentheses, and multi-digit input.
 * <p>
 * The calculator evaluates expressions using the classic **shunting-yard algorithm**
 * (by Edsger Dijkstra) technique with two stacks:
 * <ul>
 *     <li>{@code operator} stack stores {@link Operator} instances</li>
 *     <li>{@code operand} stack stores numeric values</li>
 * </ul>
 * It evaluates expressions using operator precedence and supports
 * multi-digit numbers and decimal points.
 * </p>
 * <p>
 * GUI elements include a {@link TextField} for the display and {@link Button}s
 * arranged in a {@link GridPane} for input.
 * </p>
 */
public class Calculator extends Application {
    
    /** Width of the calculator window. */
	public static int CALC_WIDTH  = 400;
	/** Height of the calculator window. */
	public static int CALC_HEIGHT = 200;

    /** TextField representing the calculator display screen. */
	private TextField screen;

    /** Stack to store operators for expression evaluation. */
	private Stack<Operator> operator;
	/** Stack to store operands (numbers) for evaluation. */
	private Stack<Double>   operand;

    /** Current numeric input as a string (for multi-digit numbers). */
	private String num;

    // Calculator buttons (0-9, operators, parentheses, dot, clear, equals)
	private Button button0, button1, button2, button3, button4,
                   button5, button6, button7, button8, button9;

	private Button buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonExp;

	private Button buttonLPar, buttonRPar;

	private Button buttonDot, buttonClear, buttonEqual;

    /**
     * JavaFX entry point. Sets up the stage, scene, display, and buttons.
     * 
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) 
    {
        // create the calculator screen
		screen = new TextField();
		screen.setEditable(false);
		styleTextField (screen);

		// create the buttons
		button0 = new Button("0");	createStyledButton(button0);
		button1 = new Button("1");	createStyledButton(button1);
		button2 = new Button("2");	createStyledButton(button2);
		button3 = new Button("3");	createStyledButton(button3);
		button4 = new Button("4");	createStyledButton(button4);
		button5 = new Button("5");	createStyledButton(button5);
		button6 = new Button("6");	createStyledButton(button6);
		button7 = new Button("7");	createStyledButton(button7);
		button8 = new Button("8");	createStyledButton(button8);
		button9 = new Button("9");	createStyledButton(button9);
		
		buttonPlus = new Button("+");	createStyledButton(buttonPlus);
		buttonMinus = new Button("-");	createStyledButton(buttonMinus);
		buttonMult = new Button("*");	createStyledButton(buttonMult);
		buttonDiv = new Button("/");	createStyledButton(buttonDiv);
		buttonExp = new Button("^");	createStyledButton(buttonExp);
		
		buttonLPar = new Button("(");	createStyledButton(buttonLPar);
		buttonRPar = new Button(")");	createStyledButton(buttonRPar);
		
		buttonDot = new Button(".");	createStyledButton(buttonDot);
		buttonEqual = new Button("=");	createStyledButton(buttonEqual);
		buttonClear = new Button("C");	createStyledButton(buttonClear);

        // Initialize stacks and input string
		operator = new Stack<Operator> ();
		operand  = new Stack<Double> ();
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
		keypad.add(button1, 0, 0);	keypad.add(button2, 1, 0);	keypad.add(button3, 2, 0);       
		keypad.add(button4, 0, 1);	keypad.add(button5, 1, 1);	keypad.add(button6, 2, 1); 
		keypad.add(button7, 0, 2);	keypad.add(button8, 1, 2);	keypad.add(button9, 2, 2);

		keypad.add(buttonPlus, 3, 0);	keypad.add(buttonMinus, 4, 0);       
		keypad.add(buttonMult, 3, 1);	keypad.add(buttonDiv, 4, 1);
		keypad.add(buttonExp, 3, 3);

		keypad.add(buttonLPar, 3, 2);	keypad.add(buttonRPar, 4, 2);

		keypad.add(buttonDot, 1, 3);	keypad.add(buttonEqual, 2, 3);	keypad.add(buttonClear, 4, 3);

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

    /**
     * Handles button click events for the calculator.
     * Uses {@link Operator} stack and operand stack to process input.
     */
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

	/**
     * Processes the current operator with respect to operator precedence.
     * Pops from the operator stack and evaluates as needed.
     * 
     * @param curOperator the operator to process
     */
    private void operate(Operator curOperator)
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

	/**
     * Pushes a multi-digit or decimal number currently in input string
     * to the operand stack.
     */
    private void pushMultiDigit()
	{
		if (num != "")
		{
			double curNumber = Double.parseDouble(num);

			operand.push(curNumber);
			num = "";
		}
	}

	/**
     * Styles a button for consistent appearance in the GUI.
     * 
     * @param btn the button to style
     */
    private void createStyledButton (Button btn)
	{
		
		btn.setMinSize(80, 34);
		
		btn.setStyle(
				
				"-fx-font-weight: bold;" +                        // Make the text bold
				"-fx-background-color: linear-gradient(to bottom, #e0e9f1, #c0d2e4);" + // Light gradient color
				"-fx-padding: 10;" +                              // Add padding
				"-fx-border-color: #a0b8d8;" +                    // Light blue border color
				"-fx-border-width: 1px;" +                        // Set border thickness
				"-fx-border-radius: 5px;" +                       // Add rounded corners to the border
				"-fx-background-radius: 5px;" +                   // Round the background corners as well
				"-fx-font-size: 16px;"                            // Set font size for better readability
			
		);
	}
	
	/**
     * Styles the TextField used as the calculator screen.
     * 
     * @param textField the TextField to style
     */
	private void styleTextField(TextField textField)
	{
		
	    textField.setStyle(
	    		
	        "-fx-background-color: #E6F7FF;" +  // Light blue background color
	        "-fx-padding: 10;" +                // Add padding
	        "-fx-border-color: #A8D8FF;" +      // Light blue border color
	        "-fx-border-width: 2px;" +          // Set border thickness
	        "-fx-border-radius: 5px;" +         // Rounded corners for the border
	        "-fx-background-radius: 5px;" +     // Rounded corners for the background
	        "-fx-font-size: 18px;" +            // Set font size for readability
	        "-fx-font-weight: bold;" +          // Make the text bold
	        "-fx-text-fill: #000000;"           // Set text color to black
	    );
	    
	    textField.setMinHeight(40);                // Set minimum height for the text field
	    textField.setAlignment(Pos.CENTER_RIGHT);  // Align text to the right
	}

	/** Launches the JavaFX application. */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
