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
    public static void main(String[] args) {
        launch(args);
    }
    
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Note Taker");
        Scene scene1 = new Scene(new Group(), 950, 450);

        String categories[] = {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};

        Label selected1 = new Label();
        Label selected2 = new Label();
        Text welcome = new Text();
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        welcome.setX(50); 
        welcome.setY(130);      
        welcome.setText("Welcome to your note taker"); 
    




        ComboBox addNotes = new ComboBox(FXCollections.observableArrayList(categories));  
        
       
        

        EventHandler<ActionEvent> addFile = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Laksyha's part 
                // add file 
                // example of an action: 
                selected1.setText(addNotes.getValue() + " selected");
                //setScene(addNotes.getValue());
                
            }

        };

        addNotes.setOnAction((event) -> {
            setScene(addNotes.getValue());
        })

        private void setScene(Object value) {
        }

        // if (addNotes.getValue() == "Characters") {
        //     addNotes.setOnAction(e -> primaryStage.setScene(scene2));
        // }

        //addNotes.setOnAction(addFile);

        // ComboBox readNotes = new ComboBox(FXCollections.observableArrayList(categories));        

        // EventHandler<ActionEvent> addFile2 = new EventHandler<ActionEvent>() {
        //     public void handle(ActionEvent e) {
        //         // Laksyha's part 
        //         // add file 
        //         // example of an action: 
        //         selected2.setText(readNotes.getValue() + " selected");
        //     }
        // };

        // readNotes.setOnAction(addFile2);

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(welcome, 0, 0);
        grid.add(new Label("add notes: "), 1,25);
        grid.add(addNotes, 1, 26);
        grid.add(selected1, 1, 27);
        // grid.add(new Label("see notes: "),2,25);
        // grid.add(readNotes, 2, 26);
        // grid.add(selected2, 2, 27);

        Group root = (Group)scene1.getRoot();
        root.getChildren().add(grid);
        // primaryStage.setScene(scene1);
        // primaryStage.show();

        // scene 2
        Button submitButton = new Button ("Submit");
        TextField character = new TextField("");
        TextField pageNumber = new TextField("");
        TextArea detailText = new TextArea ("");

        //secondaryStage.setTitle("Characters");
        Scene scene2 = new Scene(new Group(), 450, 250);
        
        GridPane grid2 = new GridPane();
        grid2.setVgap(4);
        grid2.setHgap(10);
        grid2.setPadding(new Insets(5, 5, 5, 5));
        grid2.add(new Label("Page Number: "), 0, 1);
        grid2.add(pageNumber, 1, 1, 2, 1);
        grid2.add(new Label("Character: "), 0, 2);
        grid2.add(character, 1, 2, 3, 2);
        grid2.add(new Label("Character Detail: "), 0, 4);
        grid2.add(detailText, 0, 5, 3, 1);             
        grid2.add(submitButton, 0, 6);
        
        Group root2 = (Group)scene2.getRoot();
        root2.getChildren().add(grid2);
        // secondaryStage.setScene(scene2);
        // secondaryStage.show();

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
}


