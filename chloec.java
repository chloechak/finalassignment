import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
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
        String categories[] = {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};
        


        ComboBox addNotes = new ComboBox(FXCollections.observableArrayList(categories));        
        
        // Create empty local variable to be used later 
        Label selected = new Label();
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Laksyha's part 
                // add file 
                // example of an action: 
                selected.setText(addNotes.getValue() + " selected");
                // empty label is used here
            }
        };

        // Allows the action to be run 
        addNotes.setOnAction(event);

        TilePane root = new TilePane(addNotes,selected);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}


