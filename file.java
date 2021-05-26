import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class file extends Application {

    Scene scene;
    Stage window; 
    Button button;
    

    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Bucky's Meat Subs");
        window.setWidth(400);
        
        ComboBox<String> comboBox = new ComboBox<>();

        comboBox.getItems().addAll("Bananas","Apples","Epic","Gamer");

        // Set a default value
        comboBox.setValue("Apples");

        //Listen for selection changes
        comboBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> NewWindow.display(newValue));

        // Button
        button = new Button("Click me");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}

class NewWindow extends file{
    public static void display(String value) {
        Stage window = new Stage();
        window.setTitle("yes");
        window.setHeight(200);
        window.setWidth(300);
        
        VBox layout = new VBox();

        switch (value) {
            case "Apples": {
                Label appleLabel = new Label("Welcome to the apple scene.");
                layout.getChildren().add(appleLabel);
                break;
            }
            case "Epic": {
                Label epicLabel = new Label("Wow, this is epic.");
                layout.getChildren().add(epicLabel);
                break;
            }
        }

        

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}