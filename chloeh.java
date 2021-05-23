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

public class chloeh extends Application {
    public static void main(String[] args) {
        launch(args);
    }
        
    final Button button = new Button ("Submit");
    final Label notification = new Label ();
    final TextField character = new TextField("");
    final TextField pageNumber = new TextField("");
    final TextArea text = new TextArea ("");
    
    String address = " ";
    
    @Override public void start(Stage stage) {
        stage.setTitle("Characters");
        Scene scene = new Scene(new Group(), 450, 250);
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Page Number: "), 0, 1);
        grid.add(pageNumber, 1, 1, 2, 1);
        grid.add(new Label("Character: "), 0, 2);
        grid.add(character, 1, 2, 3, 2);
        grid.add(new Label("Character Detail: "), 0, 4);
        grid.add(text, 0, 5, 3, 1);             
        grid.add(button, 0, 6);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }    
}