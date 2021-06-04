import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.binding;
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
import java.util.logging.Level;
import javafx.scene.Group;
import java.util.logging.Logger;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.cell.PropertyValueFactory;
 
import javax.swing.JOptionPane;
import javafx.scene.control.TableView;
 
public class hello extends Application {
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
 
        String categories[] = {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};
 
        
        Label selected2 = new Label();
        Text welcome = new Text();
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        welcome.setX(50); 
        welcome.setY(130);      
        welcome.setText("Welcome to your note taker"); 
    
        ComboBox<String> readNotes = new ComboBox<>(FXCollections.observableArrayList(categories));
 
        ComboBox<String> addNotes = new ComboBox<>(FXCollections.observableArrayList(categories));
 
 
 
        //ComboBox addNotes = new ComboBox(FXCollections.observableArrayList(categories));  
        
        addNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> idk.display(newValue));
 
        
 
        EventHandler<ActionEvent> addFile = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Laksyha's part 
                // add file 
                // example of an action: 
            //    selected1.setText(addNotes.getValue() + " selected");
                
            }
 
        };
 
        addNotes.setOnAction(addFile);
 
 
 
        
        readNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> new scene3().display2(newValue));
 
 
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
        //grid.add(selected1, 1, 27);
        grid.add(new Label("see notes: "),2,25);
        grid.add(readNotes, 2, 26);
        grid.add(selected2, 2, 27);
 
        Group root = (Group)scene1.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    
}
 
class idk extends hello {
    public static void display (String value) {
        Stage window = new Stage();
        Scene scene2 = new Scene(new Group(), 850, 450);
 
        TextField character = new TextField("");
        TextField literaryDevices = new TextField("");
        TextField techniques = new TextField("");
        TextField themes = new TextField("");
        TextField importantQuotes = new TextField("");
        TextField plotAnalysis = new TextField("");
        TextField additionalNotes = new TextField("");
 
        TextField pageNumberC = new TextField("");
        TextField pageNumberL = new TextField("");
        TextField pageNumberTech = new TextField("");
        TextField pageNumberTheme = new TextField("");
        TextField pageNumberQ = new TextField("");
        TextField pageNumberP = new TextField("");
        TextField pageNumberA = new TextField("");
 
        TextArea detailText = new TextArea ("");
        TextArea explanation = new TextArea ("");
        TextArea impact = new TextArea ("");
        TextArea implied = new TextArea ("");
        TextArea quoteExplanation = new TextArea ("");
        TextArea analysisText = new TextArea ("");
        TextArea notes = new TextArea ("");
 
        Button submitButton = new Button ("Submit");
        Label charactersLabel=new Label();
        Label literaryLabel= new Label();
        Label techniqueLabel = new Label();
        Label themesLabel = new Label(); 
        Label quotesLabel = new Label();
        Label plotLabel = new Label();
        Label additonLabel = new Label();
       

        // characters grid
        GridPane characterGrid = new GridPane();
        characterGrid.setVgap(4);
        characterGrid.setHgap(10);
        characterGrid.setPadding(new Insets(5, 5, 5, 5));
        characterGrid.add(new Label("Page Number: "), 0, 1);
        characterGrid.add(pageNumberC, 1, 1);
        characterGrid.add(new Label("Character: "), 0, 3);
        characterGrid.add(character, 1, 2, 3, 2);
        characterGrid.add(new Label("Character Detail: "), 0, 4);
        characterGrid.add(detailText, 0, 5, 3, 1); 

        characterGrid.add(charactersLabel, 6, 7);
        



        // literary devices grid
        GridPane literaryDevicesGrid = new GridPane();
        literaryDevicesGrid.setVgap(4);
        literaryDevicesGrid.setHgap(10);
        literaryDevicesGrid.setPadding(new Insets(5, 5, 5, 5));
        literaryDevicesGrid.add(new Label("Page Number: "), 0, 1);
        literaryDevicesGrid.add(pageNumberL, 1, 1);
        literaryDevicesGrid.add(new Label("Literary Device: "), 0, 3);
        literaryDevicesGrid.add(literaryDevices, 1, 2, 3, 2);
        literaryDevicesGrid.add(new Label("Explanation: "), 0, 4);
        literaryDevicesGrid.add(explanation, 0, 5, 3, 1);   

          
        
 

        literaryDevicesGrid.add(literaryLabel, 6, 7); 
        
        


        // techniques grid
        GridPane techniquesGrid = new GridPane();
        techniquesGrid.setVgap(4);
        techniquesGrid.setHgap(10);
        techniquesGrid.setPadding(new Insets(5, 5, 5, 5));
        techniquesGrid.add(new Label("Page Number: "), 0, 1);
        techniquesGrid.add(pageNumberTech, 1, 1);
        techniquesGrid.add(new Label("Technique used: "), 0, 3);
        techniquesGrid.add(techniques, 1, 2, 3, 2);
        techniquesGrid.add(new Label("How it was used/Impact: "), 0, 4);
        techniquesGrid.add(impact, 0, 5, 3, 1); 

            
        
 

        techniquesGrid.add(techniqueLabel, 6, 7);
        

        // themes grid
        GridPane themesGrid = new GridPane();
        themesGrid.setVgap(4);
        themesGrid.setHgap(10);
        themesGrid.setPadding(new Insets(5, 5, 5, 5));
        themesGrid.add(new Label("Page Number: "), 0, 1);
        themesGrid.add(pageNumberTheme, 1, 1);
        themesGrid.add(new Label("Themes: "), 0, 3);
        themesGrid.add(themes, 1, 2, 3, 2);
        themesGrid.add(new Label("How is it Implied?: "), 0, 4);
        themesGrid.add(implied, 0, 5, 3, 1);             
 
 
        themesGrid.add(themesLabel, 6, 7);

        // important quotes grid
        GridPane importantQuotesGrid = new GridPane();
        importantQuotesGrid.setVgap(4);
        importantQuotesGrid.setHgap(10);
        importantQuotesGrid.setPadding(new Insets(5, 5, 5, 5));
        importantQuotesGrid.add(new Label("Page Number: "), 0, 1);
        importantQuotesGrid.add(pageNumberQ, 1, 1);
        importantQuotesGrid.add(new Label("Significant Quotes: "), 0, 3);
        importantQuotesGrid.add(importantQuotes, 1, 2, 3, 2);
        importantQuotesGrid.add(new Label("Quote Explanation: "), 0, 4);
        importantQuotesGrid.add(quoteExplanation, 0, 5, 3, 1);  
           
        
 
        importantQuotesGrid.add(quotesLabel, 6, 7);   
        

        // plot analysis grid
        GridPane plotAnalysisGrid = new GridPane();
        plotAnalysisGrid.setVgap(4);
        plotAnalysisGrid.setHgap(10);
        plotAnalysisGrid.setPadding(new Insets(5, 5, 5, 5));
        plotAnalysisGrid.add(new Label("Page Number: "), 0, 1);
        plotAnalysisGrid.add(pageNumberP, 1, 1);
        plotAnalysisGrid.add(new Label("Analysis Name: "), 0, 3);
        plotAnalysisGrid.add(plotAnalysis, 1, 2, 3, 2);
        plotAnalysisGrid.add(new Label("Plot Analysis: "), 0, 4);
        plotAnalysisGrid.add(analysisText, 0, 5, 3, 1);     
        
        
 

        plotAnalysisGrid.add(plotLabel, 6, 7);
        

 
        // additional notes grid
        GridPane additionalNotesGrid = new GridPane();
        additionalNotesGrid.setVgap(4);
        additionalNotesGrid.setHgap(10);
        additionalNotesGrid.setPadding(new Insets(5, 5, 5, 5));
        additionalNotesGrid.add(new Label("Page Number: "), 0, 1);
        additionalNotesGrid.add(pageNumberA, 1, 1);
        additionalNotesGrid.add(new Label("Title: "), 0, 3);
        additionalNotesGrid.add(additionalNotes, 1, 2, 3, 2);
        additionalNotesGrid.add(new Label("Additional Note: "), 0, 4);
        additionalNotesGrid.add(notes, 0, 5, 3, 1); 
 
 

 
        //Group root = (Group)scene2.getRoot();
 

        additionalNotesGrid.add(additonLabel, 6, 7);

        Group root = (Group)scene2.getRoot();


 
 
 
        switch (value) {
            case "Characters" : {
                window.setTitle("Characters");
                characterGrid.add(submitButton, 0, 6);
                 submitButton.setOnAction((ActionEvent event)->{
                    if(!pageNumberC.getText().isEmpty()&&!character.getText().isEmpty()&&!detailText.getText().isEmpty()){
                    File writeFile = new File("characters.csv");
                        writer(writeFile,pageNumberC,character,detailText);
                    }
                    else{
                        error(detailText,pageNumberC,character,charactersLabel); 
                        }
                        }
                        );
                        root.getChildren().add(characterGrid);
                        break;
                    
                    
    
                   
                }
                
                    
            case "Literary Devices" : {
                window.setTitle("Literary Devices");
                literaryDevicesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(!explanation.getText().isEmpty()&&!pageNumberL.getText().isEmpty()&&!literaryDevices.getText().isEmpty()){
                        File writeFile = new File("literaryDevices.csv");
                       writer(writeFile,pageNumberL,literaryDevices,explanation);
                    }
                    else{
                        error(explanation,pageNumberL,literaryDevices, literaryLabel);  
                       }
                    }
                    );
                root.getChildren().add(literaryDevicesGrid);
                break;
            } 
            case "Techniques" : {
                window.setTitle("Techniques");
                techniquesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberTech.getText().isEmpty()&&!techniques.getText().isEmpty()&&!impact.getText().isEmpty()){
                File writeFile = new File("techniques.csv");
                writer(writeFile,pageNumberTech,techniques,impact);
                    }
                    else{
                        error(impact,pageNumberTech,techniques,techniqueLabel); 

                    }
                    }
                    );
                root.getChildren().add(techniquesGrid);
                break;
            } 
            case "Themes" : {
                window.setTitle("Themes");
                themesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberTheme.getText().isEmpty()&&!themes.getText().isEmpty()&&!implied.getText().isEmpty()){
                        File writeFile = new File("themes.csv");
                        writer(writeFile,pageNumberTheme,themes,implied);
                    }
                
                else{
                    error(implied,pageNumberTheme,themes,themesLabel);  
                }
                }
                );
                root.getChildren().add(themesGrid);
                break;
            } 
            case "Important Quotes" : {
                window.setTitle("Important Quotes");
                importantQuotesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberQ.getText().isEmpty()&&!importantQuotes.getText().isEmpty()&&!quoteExplanation.getText().isEmpty()){
                File writeFile = new File("importantQuotes.csv");
                writer(writeFile,pageNumberQ,importantQuotes,quoteExplanation);

                }
                else{
                    error(quoteExplanation,pageNumberQ,importantQuotes,quotesLabel); 
                    }
                    }
                    );
                root.getChildren().add(importantQuotesGrid);
            
                break;
            } 
            case "Plot Analysis" : {
                window.setTitle("Plot Analysis");
                plotAnalysisGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberP.getText().isEmpty()&&!plotAnalysis.getText().isEmpty()&&!analysisText.getText().isEmpty()){
                File writeFile = new File("plotAnalysis.csv");
                writer(writeFile,pageNumberP,plotAnalysis,analysisText);
                    }
                else{
                error(analysisText,pageNumberP,plotAnalysis,plotLabel);   
                    }
                    }
                    );
                root.getChildren().add(plotAnalysisGrid);
                break;
            } 
            case "Additional Notes" : {
                window.setTitle("Additional Notes");
                additionalNotesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberA.getText().isEmpty()&&!additionalNotes.getText().isEmpty()&&!notes.getText().isEmpty()){
                File writeFile = new File("additionalNotes.csv");
                 writer(writeFile,pageNumberA,additionalNotes,notes);
                }
                }
                    );
                root.getChildren().add(additionalNotesGrid);
                break;
            }
        }
 
        window.setScene(scene2);
        window.show();
 
 
    }

    private static void error(TextArea textArea,TextField page, TextField topic, Label selected1) {
        if (textArea.getText().isEmpty()||page.getText().isEmpty()||topic.getText().isEmpty())
        {
        selected1.setText("Please complete all fields");
        }
        else {
        selected1.setText("success, saved in csv file");
        }
    }

    private static void writer(File writeFile, TextField page, TextField topic, TextArea details) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(writeFile, true));
            pw.write(page.getText()+"/"); 
            pw.write(topic.getText()+"/");
            pw.write(details.getText());
            pw.println();
            pw.flush();
            pw.close();
        }

        catch (IOException e) {
          e.printStackTrace();
        }
      
    }
}
class scene3 extends hello {

    public class Record {

        private SimpleStringProperty pageNumber, Topic, Description;

        // public Record(String pageNumber, String Topic, String Description) {
        //     this.pageNumber = new SimpleStringProperty(pageNumber);
        //     this.Topic = new SimpleStringProperty(Topic);
        //     this.Description = new SimpleStringProperty(Description);
        // }


        public String getPageNumber() {
            return pageNumber.get();
        }

        public String getTopic() {
            return Topic.get();
        }

        public String getDescription() {
            return Description.get();
        }

        Record(String pageNumber, String Topic, String Description) {
            this.pageNumber = new SimpleStringProperty(pageNumber);
            this.Topic = new SimpleStringProperty(Topic);
            this.Description = new SimpleStringProperty(Description);

        }
    }
    
 
    private final static TableView<Record> tableView = new TableView<>();

    private final static ObservableList<Record> dataList = FXCollections.observableArrayList();
 
    public void display2 (String value) { 

        //String categories[] = {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};

        Stage window2 = new Stage();
        Scene scene3 = new Scene(new Group(), 850, 450);
        //final ObservableList<Record> data = FXCollections.observableArrayList();  


        // TextField searchField = new TextField();
        // searchField.setPromptText("Search");
        // searchField.setMaxWidth(200);


        
        TableColumn columnA1 = new TableColumn("Page Number");
        columnA1.setCellValueFactory(new PropertyValueFactory<>("PageNumber"));
 
        TableColumn columnA2 = new TableColumn("Topic");
        columnA2.setCellValueFactory(new PropertyValueFactory<>("Topic"));
 
        TableColumn columnA3 = new TableColumn("Details");
        columnA3.setCellValueFactory(new PropertyValueFactory<>("Description"));
 
 
        tableView.setItems(dataList);
        Group root = (Group)scene3.getRoot();
 
        columnA1.setPrefWidth(300);
        columnA2.setPrefWidth(300);
        columnA3.setPrefWidth(240);
 
        tableView.setPrefHeight(440);
 
        tableView.getColumns().clear();
        System.out.println(value);

       

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.util.logging.Level;
import javafx.scene.Group;
import java.util.logging.Logger;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
 
public class hello extends Application {
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
        
        addNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> idk.display(newValue));
 
        
 
        EventHandler<ActionEvent> addFile = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Laksyha's part 
                // add file 
                // example of an action: 
            //    selected1.setText(addNotes.getValue() + " selected");
                
            }
 
        };
 
        addNotes.setOnAction(addFile);
 
 
 
        
        readNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> scene3.display2(newValue));
 
 
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
        //grid.add(selected1, 1, 27);
        grid.add(new Label("see notes: "),2,25);
        grid.add(readNotes, 2, 26);
        grid.add(selected2, 2, 27);
 
        Group root = (Group)scene1.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    
}
 
class idk extends hello {
    public static void display (String value) {
        Stage window = new Stage();
        Scene scene2 = new Scene(new Group(), 850, 450);
 
        TextField character = new TextField("");
        TextField literaryDevices = new TextField("");
        TextField techniques = new TextField("");
        TextField themes = new TextField("");
        TextField importantQuotes = new TextField("");
        TextField plotAnalysis = new TextField("");
        TextField additionalNotes = new TextField("");
 
        TextField pageNumberC = new TextField("");
        TextField pageNumberL = new TextField("");
        TextField pageNumberTech = new TextField("");
        TextField pageNumberTheme = new TextField("");
        TextField pageNumberQ = new TextField("");
        TextField pageNumberP = new TextField("");
        TextField pageNumberA = new TextField("");
 
        TextArea detailText = new TextArea ("");
        TextArea explanation = new TextArea ("");
        TextArea impact = new TextArea ("");
        TextArea implied = new TextArea ("");
        TextArea quoteExplanation = new TextArea ("");
        TextArea analysisText = new TextArea ("");
        TextArea notes = new TextArea ("");
 
        Button submitButton = new Button ("Submit");
        Label charactersLabel=new Label();
        Label literaryLabel= new Label();
        Label techniqueLabel = new Label();
        Label themesLabel = new Label(); 
        Label quotesLabel = new Label();
        Label plotLabel = new Label();
        Label additonLabel = new Label();
       
     
        // characters grid
        GridPane characterGrid = new GridPane();
        characterGrid.setVgap(4);
        characterGrid.setHgap(10);
        characterGrid.setPadding(new Insets(5, 5, 5, 5));
        characterGrid.add(new Label("Page Number: "), 0, 1);
        characterGrid.add(pageNumberC, 1, 1);
        characterGrid.add(new Label("Character: "), 0, 3);
        characterGrid.add(character, 1, 2, 3, 2);
        characterGrid.add(new Label("Character Detail: "), 0, 4);
        characterGrid.add(detailText, 0, 5, 3, 1); 
 
 
        // literary devices grid
        GridPane literaryDevicesGrid = new GridPane();
        literaryDevicesGrid.setVgap(4);
        literaryDevicesGrid.setHgap(10);
        literaryDevicesGrid.setPadding(new Insets(5, 5, 5, 5));
        literaryDevicesGrid.add(new Label("Page Number: "), 0, 1);
        literaryDevicesGrid.add(pageNumberL, 1, 1);
        literaryDevicesGrid.add(new Label("Literary Device: "), 0, 3);
        literaryDevicesGrid.add(literaryDevices, 1, 2, 3, 2);
        literaryDevicesGrid.add(new Label("Explanation: "), 0, 4);
        literaryDevicesGrid.add(explanation, 0, 5, 3, 1);   
          
        
 
        // techniques grid
        GridPane techniquesGrid = new GridPane();
        techniquesGrid.setVgap(4);
        techniquesGrid.setHgap(10);
        techniquesGrid.setPadding(new Insets(5, 5, 5, 5));
        techniquesGrid.add(new Label("Page Number: "), 0, 1);
        techniquesGrid.add(pageNumberTech, 1, 1);
        techniquesGrid.add(new Label("Technique used: "), 0, 3);
        techniquesGrid.add(techniques, 1, 2, 3, 2);
        techniquesGrid.add(new Label("How it was used/Impact: "), 0, 4);
        techniquesGrid.add(impact, 0, 5, 3, 1); 
            
        
 
        // themes grid
        GridPane themesGrid = new GridPane();
        themesGrid.setVgap(4);
        themesGrid.setHgap(10);
        themesGrid.setPadding(new Insets(5, 5, 5, 5));
        themesGrid.add(new Label("Page Number: "), 0, 1);
        themesGrid.add(pageNumberTheme, 1, 1);
        themesGrid.add(new Label("Themes: "), 0, 3);
        themesGrid.add(themes, 1, 2, 3, 2);
        themesGrid.add(new Label("How is it Implied?: "), 0, 4);
        themesGrid.add(implied, 0, 5, 3, 1);             
 
 
        // important quotes grid
        GridPane importantQuotesGrid = new GridPane();
        importantQuotesGrid.setVgap(4);
        importantQuotesGrid.setHgap(10);
        importantQuotesGrid.setPadding(new Insets(5, 5, 5, 5));
        importantQuotesGrid.add(new Label("Page Number: "), 0, 1);
        importantQuotesGrid.add(pageNumberQ, 1, 1);
        importantQuotesGrid.add(new Label("Significant Quotes: "), 0, 3);
        importantQuotesGrid.add(importantQuotes, 1, 2, 3, 2);
        importantQuotesGrid.add(new Label("Quote Explanation: "), 0, 4);
        importantQuotesGrid.add(quoteExplanation, 0, 5, 3, 1);  
           
        
 
        // plot analysis grid
        GridPane plotAnalysisGrid = new GridPane();
        plotAnalysisGrid.setVgap(4);
        plotAnalysisGrid.setHgap(10);
        plotAnalysisGrid.setPadding(new Insets(5, 5, 5, 5));
        plotAnalysisGrid.add(new Label("Page Number: "), 0, 1);
        plotAnalysisGrid.add(pageNumberP, 1, 1);
        plotAnalysisGrid.add(new Label("Analysis Name: "), 0, 3);
        plotAnalysisGrid.add(plotAnalysis, 1, 2, 3, 2);
        plotAnalysisGrid.add(new Label("Plot Analysis: "), 0, 4);
        plotAnalysisGrid.add(analysisText, 0, 5, 3, 1);     
        
        
 
        // additional notes grid
        GridPane additionalNotesGrid = new GridPane();
        additionalNotesGrid.setVgap(4);
        additionalNotesGrid.setHgap(10);
        additionalNotesGrid.setPadding(new Insets(5, 5, 5, 5));
        additionalNotesGrid.add(new Label("Page Number: "), 0, 1);
        additionalNotesGrid.add(pageNumberA, 1, 1);
        additionalNotesGrid.add(new Label("Title: "), 0, 3);
        additionalNotesGrid.add(additionalNotes, 1, 2, 3, 2);
        additionalNotesGrid.add(new Label("Additional Note: "), 0, 4);
        additionalNotesGrid.add(notes, 0, 5, 3, 1); 
 
 

 
        Group root = (Group)scene2.getRoot();
 
 
 
        switch (value) {
            case "Characters" : {
                window.setTitle("Characters");
                characterGrid.add(submitButton, 0, 6);
                 submitButton.setOnAction((ActionEvent event)->{
                    if(!pageNumberC.getText().isEmpty()&&!character.getText().isEmpty()&&!detailText.getText().isEmpty()){
                    File writeFile = new File("characters.csv");
                        writer(writeFile,pageNumberC,character,detailText);
                    }
                    else{
                        error(detailText,pageNumberC,character,charactersLabel); 
                        }
                        }
                        );
                        root.getChildren().add(characterGrid);
                        break;
                    
                    
    
                   
                }
                
                    
            case "Literary Devices" : {
                window.setTitle("Literary Devices");
                literaryDevicesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(!explanation.getText().isEmpty()&&!pageNumberL.getText().isEmpty()&&!literaryDevices.getText().isEmpty()){
                        File writeFile = new File("literaryDevices.csv");
                       writer(writeFile,pageNumberL,literaryDevices,explanation);
                    }
                    else{
                        error(explanation,pageNumberL,literaryDevices, literaryLabel);  
                       }
                    }
                    );
                root.getChildren().add(literaryDevicesGrid);
                break;
            } 
            case "Techniques" : {
                window.setTitle("Techniques");
                techniquesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberTech.getText().isEmpty()&&!techniques.getText().isEmpty()&&!impact.getText().isEmpty()){
                File writeFile = new File("techniques.csv");
                writer(writeFile,pageNumberTech,techniques,impact);
                    }
                    else{
                        error(impact,pageNumberTech,techniques,techniqueLabel); 

                    }
                    }
                    );
                root.getChildren().add(techniquesGrid);
                break;
            } 

            case "Themes" : {
                window.setTitle("Themes");
                themesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberTheme.getText().isEmpty()&&!themes.getText().isEmpty()&&!implied.getText().isEmpty()){
                        File writeFile = new File("themes.csv");
                        writer(writeFile,pageNumberTheme,themes,implied);
                    }
                
                else{
                    error(implied,pageNumberTheme,themes,themesLabel);  
                }
                }
                );
                root.getChildren().add(themesGrid);
                break;
            } 
            case "Important Quotes" : {
                window.setTitle("Important Quotes");
                importantQuotesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberQ.getText().isEmpty()&&!importantQuotes.getText().isEmpty()&&!quoteExplanation.getText().isEmpty()){
                File writeFile = new File("importantQuotes.csv");
                writer(writeFile,pageNumberQ,importantQuotes,quoteExplanation);

                }
                else{
                    error(quoteExplanation,pageNumberQ,importantQuotes,quotesLabel); 
                    }
                    }
                    );
                root.getChildren().add(importantQuotesGrid);
            
                break;
            } 
            case "Plot Analysis" : {
                window.setTitle("Plot Analysis");
                plotAnalysisGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberP.getText().isEmpty()&&!plotAnalysis.getText().isEmpty()&&!analysisText.getText().isEmpty()){
                File writeFile = new File("plotAnalysis.csv");
                writer(writeFile,pageNumberP,plotAnalysis,analysisText);
                    }
                else{
                error(analysisText,pageNumberP,plotAnalysis,plotLabel);   
                    }
                    }
                    );
                root.getChildren().add(plotAnalysisGrid);
                break;
            } 
            case "Additional Notes" : {
                window.setTitle("Additional Notes");
                additionalNotesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                if(!pageNumberA.getText().isEmpty()&&!additionalNotes.getText().isEmpty()&&!notes.getText().isEmpty()){
                File writeFile = new File("additionalNotes.csv");
                 writer(writeFile,pageNumberA,additionalNotes,notes);
                }
                }
                    );
                root.getChildren().add(additionalNotesGrid);
                break;
            }
        }
 
        window.setScene(scene2);
        window.show();
 
 
    }

    private static void error(TextArea textArea,TextField page, TextField topic, Label selected1) {
        if (textArea.getText().isEmpty()||page.getText().isEmpty()||topic.getText().isEmpty())
        {
        selected1.setText("Please complete all fields");
        }
        else {
        selected1.setText("success, saved in csv file");
        }
    }

    private static void writer(File writeFile, TextField page, TextField topic, TextArea details) {
        try {
      PrintWriter pw = new PrintWriter(new FileWriter(writeFile, true));
      pw.write(page.getText()+"|"); 
      pw.write(topic.getText()+"|");
      pw.write(details.getText());
      pw.println();
      pw.flush();
      pw.close();
      }
      catch (IOException e) {
          e.printStackTrace();
      }
      
}
}
class scene3 extends hello {

    static class Record {

        private SimpleStringProperty pageNumber, Topic, Description;

        // public Record(String pageNumber, String Topic, String Description) {
        //     this.pageNumber = new SimpleStringProperty(pageNumber);
        //     this.Topic = new SimpleStringProperty(Topic);
        //     this.Description = new SimpleStringProperty(Description);
        // }


        String getPageNumber() {
            return pageNumber.get();
        }

        String getTopicrName() {
            return Topic.get();
        }

        String getDescription() {
            return Description.get();
        }

        public Record(String pageNumber, String Topic, String Description) {
            this.pageNumber = new SimpleStringProperty(pageNumber);
            this.Topic = new SimpleStringProperty(Topic);
            this.Description = new SimpleStringProperty(Description);

        }
    }
    
 
    private final static TableView<Record> tableView = new TableView<>();
    private final static ObservableList<Record> dataList = FXCollections.observableArrayList();
 
    public static void display2 (String value) { 
        Stage window2 = new Stage();
        Scene scene3 = new Scene(new Group(), 850, 450);
        
        TableColumn columnA1 = new TableColumn("Page Number");
        columnA1.setCellValueFactory(new PropertyValueFactory<>("Page Number"));
 
        TableColumn columnA2 = new TableColumn("Topic");
        columnA2.setCellValueFactory(new PropertyValueFactory<>("Topic"));
 
        TableColumn columnA3 = new TableColumn("Details");
        columnA3.setCellValueFactory(new PropertyValueFactory<>("Details"));
 
 
        tableView.setItems(dataList);
        Group root = (Group)scene3.getRoot();
 
        columnA1.setPrefWidth(300);
        columnA2.setPrefWidth(300);
        columnA3.setPrefWidth(240);
 
        tableView.setPrefHeight(440);
 
        tableView.getColumns().clear();
        
        switch (value) {

            case "Characters" : {

            String CsvFile = "Characters.csv";
                String FieldDelimiter = "/";
    
                BufferedReader br; 
    
                try {
    
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);

                        dataList.add(record); 
                    } 
                }

                catch (FileNotFoundException ex) { 

                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);
                }

                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            }
            case "Literary Devices" : {

                String CsvFile = "literaryDevices.csv";
                    String FieldDelimiter = "/";
    
                    BufferedReader br; 
    
                try {
    
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);

                        dataList.add(record); 
                    } 
                }

                catch (FileNotFoundException ex) { 

                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);
                }


                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 

            case "Techniques" : {

                String CsvFile = "techniques.csv";
                    String FieldDelimiter = "/";
    
                    BufferedReader br; 
    
                try {
    
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);

                        dataList.add(record); 
                    } 
                }

                catch (FileNotFoundException ex) { 

                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);
                }


                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 

            case "Themes" : { 

                String CsvFile = "themes.csv"; 
                    String FieldDelimiter = "/";
    
                    BufferedReader br; 
    
                try {
    
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);

                        dataList.add(record); 
                    } 
                }

                catch (FileNotFoundException ex) { 

                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);
                }


                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 

            case "Important Quotes" : {

                String CsvFile = "importantQuotes.csv";
                    String FieldDelimiter = "/";
    
                    BufferedReader br; 
    
                try {
    
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);

                        dataList.add(record); 
                    } 
                }

                catch (FileNotFoundException ex) { 

                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);
                }


                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 
            case "Plot Analysis" : {

                String CsvFile = "plotAnalysis.csv";
                    String FieldDelimiter = "/";
    
                    BufferedReader br; 
    
                try {
    
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);

                        dataList.add(record); 
                    } 
                }

                catch (FileNotFoundException ex) { 

                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);
                }


                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            } 
            case "Additional Notes" : {

                String CsvFile = "Characters.csv";
                    String FieldDelimiter = "/";
    
                    BufferedReader br; 
    
                try {
    
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);

                        dataList.add(record); 
                    } 
                }

                catch (FileNotFoundException ex) { 

                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(scene3.class.getName()).log(Level.SEVERE, null, ex);
                }

                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            }
        }
        window2.setScene(scene3);
        window2.show();
    }

   
}
        