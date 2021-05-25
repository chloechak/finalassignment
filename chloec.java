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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
 
public class chloec extends Application {
    private Button buttonReadLine;
 
   private static int WINDOW_WIDTH  = 500;
    private static int WINDOW_HEIGHT = 300;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Note Taker");
        Scene scene = new Scene(new Group(), 950, 450);
        String categories[] = {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};
           
        Label selected1 = new Label();
        Label selected2 = new Label();

        Text welcome = new Text();
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        welcome.setX(50); 
        welcome.setY(130);      
         welcome.setText("Welcome to your note taker"); 
         //Button buttonSelectFile;
        // buttonSelectFile.setX(70);    
         //buttonSelectFile = new Button("Select Input Text File");
      //  buttonSelectFile.setOnAction((EventHandler<ActionEvent>) this);  
        
        ComboBox addNotes = new ComboBox(FXCollections.observableArrayList(categories));       
      
        EventHandler<ActionEvent> addFile = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Laksyha's part
           
                // add file 
                // example of an action: 
                selected1.setText(addNotes.getValue() + " selected");
            }
        };

        addNotes.setOnAction(addFile);

        ComboBox readNotes = new ComboBox(FXCollections.observableArrayList(categories));        

        EventHandler<ActionEvent> addFile2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Laksyha's part 
                // add file 
                // example of an action: 
                selected2.setText(readNotes.getValue() + " selected");
            }
        };

        readNotes.setOnAction(addFile2);

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(welcome, 0, 0);
        grid.add(new Label("add notes: "), 1,25);
        grid.add(addNotes, 1, 26);
        grid.add(selected1, 1, 27);
        grid.add(new Label("see notes: "),2,25);
        grid.add(readNotes, 2, 26);
        grid.add(selected2, 2, 27);


        //StackPane root = new StackPane(addNotes, selected);
        //root.getChildren().add(addNotes);
        //root.getChildren().add(t);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


