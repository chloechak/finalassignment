import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class scenes extends Application {
    Scene scene1, scene2;
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Note Taker");
        Scene scene1 = new Scene(new Group(), 950, 450);

        //String categories[] = {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};

        Label selected1 = new Label();
        Label selected2 = new Label();
        Text welcome = new Text();
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        welcome.setX(50); 
        welcome.setY(130);      
        welcome.setText("Welcome to your note taker"); 
    
        ComboBox<String> readNotes = new ComboBox<>();
        readNotes.getItems().addAll("Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes");

        ComboBox<String> addNotes = new ComboBox<>();
        addNotes.getItems().addAll("Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes");



        //ComboBox addNotes = new ComboBox(FXCollections.observableArrayList(categories));  
        
        addNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> Characters.display(newValue));

        

        EventHandler<ActionEvent> addFile = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Laksyha's part 
                // add file 
                // example of an action: 
                selected1.setText(addNotes.getValue() + " selected");
                
            }

        };

        addNotes.setOnAction(addFile);



        
        readNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> Characters.display(newValue));


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

        Group root = (Group)scene1.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    
}

class Characters extends scenes {
    public static void display (String value) {
        Stage window = new Stage();
        window.setTitle("Characters");
        // window.setHeight(450);
        // window.setWidth(250);
        Scene scene2 = new Scene(new Group(), 850, 450);


        Button submitButton = new Button ("Submit");
        TextField character = new TextField("");
        TextField pageNumber = new TextField("");
        TextArea detailText = new TextArea ("");

        // characters grid
        GridPane characterGrid = new GridPane();
        characterGrid.setVgap(4);
        characterGrid.setHgap(10);
        characterGrid.setPadding(new Insets(5, 5, 5, 5));
        characterGrid.add(new Label("Page Number: "), 0, 1);
        characterGrid.add(pageNumber, 1, 1);
        characterGrid.add(new Label("Character: "), 0, 3);
        characterGrid.add(character, 1, 2, 3, 2);
        characterGrid.add(new Label("Character Detail: "), 0, 4);
        characterGrid.add(detailText, 0, 5, 3, 1);             
        characterGrid.add(submitButton, 0, 6);
        Group root = (Group)scene2.getRoot();

        switch (value) {
            case "Characters" : {
                root.getChildren().add(characterGrid);
            }
        }

        window.setScene(scene2);
        window.show();


    }
}


