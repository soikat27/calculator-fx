import java.util.Stack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import operators.Operator;

public class Calculator extends Application {
    
    // the calculator dimensions
	public static int CALC_WIDTH  = 400;
	public static int CALC_HEIGHT = 200;

    // the calculator screen
	private TextField screen;

    // stacks
	private Stack<Operator> operator;
	private Stack<Double>   operand;

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

    public static void main(String[] args) 
    {
        launch(args);
    }
}
