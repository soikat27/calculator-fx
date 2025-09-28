import javafx.application.Application;
import javafx.stage.Stage;

public class Calculator extends Application {
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
