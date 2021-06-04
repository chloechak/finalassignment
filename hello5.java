import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
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
 
public class hello5 extends Application {
    Scene scene1, scene2;
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        // main window/first stage 
        window = primaryStage;
        // title of window 
        window.setTitle("Note Taker");
        // first scene's dimensions 
        Scene scene1 = new Scene(new Group(), 950, 450);
        
        // Array to store the category names 
        String categories[] = {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};
 
        // new labels 
        Label selected1= new Label(); 
        Label selected2 = new Label();

        // new text 
        Text welcome = new Text();

        // Text's dimensions and style 
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        welcome.setX(50); 
        welcome.setY(130);      
        welcome.setText("Welcome to your note taker"); 
    
        // read notes combobox 
        ComboBox<String> readNotes = new ComboBox<>(FXCollections.observableArrayList(categories));
 
        // add notes combobox 
        ComboBox<String> addNotes = new ComboBox<>(FXCollections.observableArrayList(categories));
 
        // takes combobox options and allows it to switch scenes 
        addNotes.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> idk2.display(newValue));
        
        // adds action and tells user what is selected from the combobox
        EventHandler<ActionEvent> addFile = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selected1.setText(addNotes.getValue() + " selected");
            }
        };
 
        addNotes.setOnAction(addFile);
 
        readNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> new thirdScene().display2(newValue));
 
        // adds action and tells user what is selected from the combobox
        EventHandler<ActionEvent> addFile2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selected2.setText(readNotes.getValue() + " selected");
            }
        };
 
        readNotes.setOnAction(addFile2);
 
        // sets grid pane for the first scene and adds the components
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
 
class idk2 extends hello5 {
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

        Label charactersLabel2=new Label();
        Label literaryLabel2= new Label();
        Label techniqueLabel2 = new Label();
        Label themesLabel2 = new Label(); 
        Label quotesLabel2 = new Label();
        Label plotLabel2 = new Label();
        Label additonLabel2 = new Label();

        //TextField[] topics = new TextField[7];
        TextField[] topics = {character, literaryDevices, techniques, themes, importantQuotes, plotAnalysis, additionalNotes};

        TextField[] pageNum = {pageNumberC, pageNumberL, pageNumberTech, pageNumberTheme, pageNumberQ, pageNumberP, pageNumberA};

        TextArea[] fullNote = {detailText, explanation, impact, implied, quoteExplanation, analysisText, notes};
       

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
        characterGrid.add(charactersLabel, 5, 7);
        characterGrid.add(charactersLabel2, 5, 1);



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
        additionalNotesGrid.add(additonLabel, 6, 7);
        Group root = (Group)scene2.getRoot();

        switch (value) {
            case "Characters" : {
                window.setTitle("Characters");
                characterGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(checkingInt(pageNumberC,charactersLabel2,"enter a valid page number" )){
                        charactersLabel2.setText("page number valid"); 
                    if(!pageNumberC.getText().isEmpty()&&!character.getText().isEmpty()&&!detailText.getText().isEmpty()){
                            File writeFile = new File("characters.csv");
                            writer(writeFile,pageNumberC,character,detailText);
                            charactersLabel.setText("success, saved in csv file");
    
                        }
                        else{
                            error(detailText,pageNumberC,character,charactersLabel); 
    
                        }
                    }
             
                });
                root.getChildren().add(characterGrid);
                break;   
            }
                
                    
            case "Literary Devices" : {
                window.setTitle("Literary Devices");
                literaryDevicesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(checkingInt(pageNumberL,literaryLabel2,"enter a valid page number" )){
                        literaryLabel2.setText("page number valid");  
                    if(!explanation.getText().isEmpty()&&!pageNumberL.getText().isEmpty()&&!literaryDevices.getText().isEmpty()){
                        File writeFile = new File("literaryDevices.csv");
                       writer(writeFile,pageNumberL,literaryDevices,explanation);
                       literaryLabel.setText("success, saved in csv file");
                    }
                    else{
                    error(explanation,pageNumberL,literaryDevices, literaryLabel);  
                    }
                }
                });
                root.getChildren().add(literaryDevicesGrid);
                break;
            } 
            case "Techniques" : {
                window.setTitle("Techniques");
                techniquesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(checkingInt(pageNumberTech,techniqueLabel2,"enter a valid page number" )){
                        literaryLabel2.setText("page number valid");  
                    if(!pageNumberTech.getText().isEmpty()&&!techniques.getText().isEmpty()&&!impact.getText().isEmpty()){
                        File writeFile = new File("techniques.csv");
                        writer(writeFile,pageNumberTech,techniques,impact);
                        techniqueLabel.setText("success, saved in csv file");
                    }
                    else {
                        error(impact,pageNumberTech,techniques,techniqueLabel); 
                    }
                }
                });
                root.getChildren().add(techniquesGrid);
                break;
            } 
            case "Themes" : {
                window.setTitle("Themes");
                themesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(checkingInt(pageNumberTheme,themesLabel2,"enter a valid page number" )){
                        themesLabel2.setText("page number valid");  
                    if(!pageNumberTheme.getText().isEmpty()&&!themes.getText().isEmpty()&&!implied.getText().isEmpty()){
                        File writeFile = new File("themes.csv");
                        writer(writeFile,pageNumberTheme,themes,implied);
                        themesLabel.setText("success, saved in csv file");
                    }
                    else {
                        error(implied,pageNumberTheme,themes,themesLabel);  
                    }
                }
                });
                root.getChildren().add(themesGrid);
                break;
            } 
            case "Important Quotes" : {
                window.setTitle("Important Quotes");
                importantQuotesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(checkingInt(pageNumberQ,quotesLabel2,"enter a valid page number" )){
                        quotesLabel2.setText("page number valid");  
                    if(!pageNumberQ.getText().isEmpty()&&!importantQuotes.getText().isEmpty()&&!quoteExplanation.getText().isEmpty()){
                        File writeFile = new File("importantQuotes.csv");
                        writer(writeFile,pageNumberQ,importantQuotes,quoteExplanation);
                        quotesLabel.setText("success, saved in csv file");
                    }
                    else {
                        error(quoteExplanation,pageNumberQ,importantQuotes,quotesLabel); 
                    }
                }
                });
                root.getChildren().add(importantQuotesGrid);
                break;
            } 
            case "Plot Analysis" : {
                window.setTitle("Plot Analysis");
                plotAnalysisGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(checkingInt(pageNumberP,plotLabel2,"enter a valid page number" )){
                        plotLabel2.setText("page number valid");  
                    if(!pageNumberP.getText().isEmpty()&&!plotAnalysis.getText().isEmpty()&&!analysisText.getText().isEmpty()){
                        File writeFile = new File("plotAnalysis.csv");
                        writer(writeFile,pageNumberP,plotAnalysis,analysisText);
                        plotLabel.setText("success, saved in csv file");
                    }
                    else {
                        error(analysisText,pageNumberP,plotAnalysis,plotLabel);   
                    }
                }
                });
                root.getChildren().add(plotAnalysisGrid);
                break;
            } 
            case "Additional Notes" : {
                window.setTitle("Additional Notes");
                additionalNotesGrid.add(submitButton, 0, 6);
                submitButton.setOnAction((ActionEvent event)->{
                    if(checkingInt(pageNumberA,additonLabel2,"enter a valid page number" )){
                        quotesLabel2.setText("page number valid");  
                    if(!pageNumberA.getText().isEmpty()&&!additionalNotes.getText().isEmpty()&&!notes.getText().isEmpty()){
                        File writeFile = new File("additionalNotes.csv");
                        writer(writeFile,pageNumberA,additionalNotes,notes);
                        additonLabel.setText("success, saved in csv file");
                    }
                    else{
                        error(notes,pageNumberA,additionalNotes,additonLabel); 
                    }
                }
                });
                root.getChildren().add(additionalNotesGrid);
                break;
            }
        }
 
        window.setScene(scene2);
        window.show();
 
 
    }

    /**
     * Attemped Bubble Sort
    public void bubbleSort(TextField[] pageNum) {

        double temp;

        int x = Integer.parseInt(pageNum.length);

        for (int i = 0; i < pageNum.length - 1; i++) {
            // If j is greater than j+1, the program switches them
            for (int j = 0; j < pageNum.length - i - 1; j++) {
                // Uses bubble sort to order the numbers from smallest to greatest
                if (pageNum[j] > pageNum [j + 1]) {
                    temp = pageNum [j]; // Holds left variable
                    pageNum[j] = pageNum[j+1]; // Overwrites left element with right
                    pageNum[j+1] = temp;
                }
            }
        }
    }
     * 
     */

    private static void error(TextArea textArea,TextField page, TextField topic, Label selected1) {
        if (textArea.getText().isEmpty()||page.getText().isEmpty()||topic.getText().isEmpty())
        {
        selected1.setText("Please complete all fields");
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
    private static boolean checkingInt(TextField page, Label label2, String message) 
    { 
        try 
        { 
            Integer.parseInt(page.getText()); 
            return true; 
        } 
        catch (NumberFormatException e) 
        { 
            label2.setText(message);
            return false; 
        } 
    }
}

class thirdScene extends hello5 {
    
    public class Record {
        // states the properties that can be read and modified 
        private SimpleStringProperty pageNumber, Topic, Description;

        // Searches for the specific string pageNumber 
        public String getPageNumber() {
            return pageNumber.get();
        }

        // Searches for the specific string Topic 
        public String getTopic() {
            return Topic.get();
        }
        
        // Searches for the specific string pageNumber 
        public String getDescription() {
            return Description.get();
        }

        // records the values of the strings 
        Record(String pageNumber, String Topic, String Description) {
            this.pageNumber = new SimpleStringProperty(pageNumber);
            this.Topic = new SimpleStringProperty(Topic);
            this.Description = new SimpleStringProperty(Description);
        }
    }
    
    // creates new TableVIew to display the information in the csv files 
    private final static TableView<Record> tableView = new TableView<>();
    // creates observable list to store the values from the csv files
    private final static ObservableList<Record> dataList = FXCollections.observableArrayList();
 

    public void display2 (String value) { 
        // new stage 
        Stage window2 = new Stage();
        // new scene 
        Scene scene3 = new Scene(new Group(), 850, 450);
        
        // columns that will be displayed in the TableView
        TableColumn columnA1 = new TableColumn("Page Number");
        columnA1.setCellValueFactory(new PropertyValueFactory<>("PageNumber"));
 
        TableColumn columnA2 = new TableColumn("Topic");
        columnA2.setCellValueFactory(new PropertyValueFactory<>("Topic"));
 
        TableColumn columnA3 = new TableColumn("Details");
        columnA3.setCellValueFactory(new PropertyValueFactory<>("Description"));
 
        // adds the items from the observableLIst
        tableView.setItems(dataList);
        Group root = (Group)scene3.getRoot();
 
        // dimensions for the columns 
        columnA1.setPrefWidth(300);
        columnA2.setPrefWidth(300);
        columnA3.setPrefWidth(240);

        // tableView dimension
        tableView.setPrefHeight(440);
 
        // clears columns every time a new combobox option is opened 
        tableView.getColumns().clear();

        switch (value) {
 
            case "Characters" : {
               // window.show(); 
 
                window2.setTitle("Characters");
                
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
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            }
            case "Literary Devices" : {
                
                //window.show(); 
                
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
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
                window.setTitle("Literary Devices");
                break;
            } 
            
 
            case "Techniques" : {

                //window.setTitle("Techniques");
               // window.show(); 
 
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
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 
 
            case "Themes" : { 

             window2.setTitle("Themes");
            // window.show(); 
 
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
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
                window.setTitle("Themes"); 
                break;
            } 
 
            case "Important Quotes" : {

               // window.setTitle("Important Quotes");
          //  window.show(); 
 
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
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 
            case "Plot Analysis" : {

               // window.setTitle("Plot Analysis");
                //window.show(); 
 
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
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            } 
            case "Additional Notes" : {

             //window.setTitle("Additional Notes");
               //window.show(); 
 
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
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
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


