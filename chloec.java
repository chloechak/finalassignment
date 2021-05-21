import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
 
public class chloec extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Note Taker");
        // Group root = new Group();   
        Text t = new Text();
        t.setFont(Font.font ("Verdana", 20));
        t.setX(50);
        t.setY(150);
        t.setText("This is a text sample");
        t.setFill(Color.RED);  
        //Group root = new Group(t);   

        ComboBox categories = new ComboBox();        
        categories.getItems().addAll(
            "Characters",
            "Literary Devices",
            "Techniques",
            "Themes",
            "Important Quotes",
            "Plot Analysis",
            "Additional Notes" 
        );
        Group root = new Group();   

        //StackPane root = new StackPane();
        root.getChildren().add(categories);
        root.getChildren().add(t);

        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}


