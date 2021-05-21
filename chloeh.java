/*
* Name : Chloe Hoang
* Teacher: Mr.Ho
* Date: May 19th 2021
* Description: Literary Note Taker (graphics designer (text field/note taking section))
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
        
    final Button button = new Button ("Submit");
    final Label notification = new Label ();
    final TextField subject = new TextField("");
    final TextArea text = new TextArea ("");
    
    String address = " ";
    
    @Override public void start(Stage stage) {
        stage.setTitle("Characters");
        Scene scene = new Scene(new Group(), 450, 250);
        
        GridPane grid = new GridPane();
        grid.add(subject, 1, 1, 3, 1);            
        grid.add(text, 0, 2, 4, 1);
        grid.add(button, 0, 3);
        grid.add (notification, 1, 3, 3, 1);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }    
}