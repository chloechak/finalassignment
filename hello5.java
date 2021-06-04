/*
 * Date: May 21, 2021
 * Names: Chloe Chak, Lakysha Moonemalle, Chloe Hoang and Dhruvika Bhatia 
 * Teacher: Mr. Ho
 * Description: Virtual Note Taker - Culminating 
*/ 


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

 /**
  * @author chloe chak
  */

public class noteTaker extends Application {
    Scene scene1, scene2;
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * @author Chloe Chak
     * Description: displays the primary stage and its components 
     * 
     * @param primaryStage: the first stage 
     */
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

        // new text for title 
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
        addNotes.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> secondScene.display(newValue));
        
        // adds action and tells user what is selected from the combobox
        EventHandler<ActionEvent> addFile = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selected1.setText(addNotes.getValue() + " selected");
            }
        };
        // sets the action
        addNotes.setOnAction(addFile);
 
        // takes combobox options and allows it to switch scenes 
        readNotes.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> new thirdScene().display2(newValue));
 
        // adds action and tells user what is selected from the combobox
        EventHandler<ActionEvent> addFile2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selected2.setText(readNotes.getValue() + " selected");
            }
        };
        // sets the action
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
        // adds the grid to the scene 
        root.getChildren().add(grid);
        // sets the scene 
        primaryStage.setScene(scene1);
        // shows scene 
        primaryStage.show();
    }
    
    
}
/**
 * @author - Chloe Hoang and Lakysha 
 */
class secondScene extends noteTaker {

    /**
     * 
     * @author - Chloe Hoang and Lakysha
     * Description - Sets the second scene interface and components where the user writes their notes
     * 
     * @param value - switches the window interface depending on the topic chosen
     */

    public static void display (String value) {

        // sets a new stage for the second window 
        Stage window = new Stage();
        // sets the dimensions for the second window
        Scene scene2 = new Scene(new Group(), 850, 450);
 
        // Creates a TextField for the Topic of notes (ex. "O Romeo, Romeo, wherefore art thou Romeo?"")
        TextField character = new TextField("");
        TextField literaryDevices = new TextField("");
        TextField techniques = new TextField("");
        TextField themes = new TextField("");
        TextField importantQuotes = new TextField("");
        TextField plotAnalysis = new TextField("");
        TextField additionalNotes = new TextField("");
 
        // Creates a TextField for the page number the note is on (ex. "26")
        TextField pageNumberC = new TextField("");
        TextField pageNumberL = new TextField("");
        TextField pageNumberTech = new TextField("");
        TextField pageNumberTheme = new TextField("");
        TextField pageNumberQ = new TextField("");
        TextField pageNumberP = new TextField("");
        TextField pageNumberA = new TextField("");
 
        // Creates a TextField for the details of the note (ex. "Leaning out of her upstairs window...")
        TextArea detailText = new TextArea ("");
        TextArea explanation = new TextArea ("");
        TextArea impact = new TextArea ("");
        TextArea implied = new TextArea ("");
        TextArea quoteExplanation = new TextArea ("");
        TextArea analysisText = new TextArea ("");
        TextArea notes = new TextArea ("");
 
        // Button that allows the user to save their notes int the csv file
        Button submitButton = new Button ("Submit");

        // Text to state if the file was able to save or if there was an error
        Label charactersLabel=new Label();
        Label literaryLabel= new Label();
        Label techniqueLabel = new Label();
        Label themesLabel = new Label(); 
        Label quotesLabel = new Label();
        Label plotLabel = new Label();
        Label additonLabel = new Label();

        // Text to state if the page number is valid or not (checks if its empty, and checks if user properly inputted a number - without a letter)
        Label charactersLabel2=new Label();
        Label literaryLabel2= new Label();
        Label techniqueLabel2 = new Label();
        Label themesLabel2 = new Label(); 
        Label quotesLabel2 = new Label();
        Label plotLabel2 = new Label();
        Label additonLabel2 = new Label();

        //TextField[] topics = new TextField[7];

        // Array for topic
        TextField[] topics = {character, literaryDevices, techniques, themes, importantQuotes, plotAnalysis, additionalNotes};

        // Array for page number
        TextField[] pageNum = {pageNumberC, pageNumberL, pageNumberTech, pageNumberTheme, pageNumberQ, pageNumberP, pageNumberA};

        // Array for detailed note 
        TextArea[] fullNote = {detailText, explanation, impact, implied, quoteExplanation, analysisText, notes};
       

        // characters grid
        GridPane characterGrid = new GridPane();
        // Sets horizontal and vertical gaps between rows
        characterGrid.setVgap(4);
        characterGrid.setHgap(10);
        // Sets the value of the property padding
        characterGrid.setPadding(new Insets(5, 5, 5, 5));
        // Sets the location of the page number label and text box
        characterGrid.add(new Label("Page Number: "), 0, 1);
        characterGrid.add(pageNumberC, 1, 1);
        // Sets the location of the character label and text box
        characterGrid.add(new Label("Character: "), 0, 3);
        characterGrid.add(character, 1, 2, 3, 2);
        // Sets the location of the detailed note label and text box
        characterGrid.add(new Label("Character Detail: "), 0, 4);
        characterGrid.add(detailText, 0, 5, 3, 1); 
        // Sets the location of the validation labels 
        characterGrid.add(charactersLabel, 5, 7);
        characterGrid.add(charactersLabel2, 5, 1);

        // literary devices grid
        GridPane literaryDevicesGrid = new GridPane();
        // Sets horizontal and vertical gaps between rows
        literaryDevicesGrid.setVgap(4);
        literaryDevicesGrid.setHgap(10);
        // Sets the value of the property padding
        literaryDevicesGrid.setPadding(new Insets(5, 5, 5, 5));
        // Sets the location of the page number label and text box
        literaryDevicesGrid.add(new Label("Page Number: "), 0, 1);
        literaryDevicesGrid.add(pageNumberL, 1, 1);
        // Sets the location of the literary device label and text box
        literaryDevicesGrid.add(new Label("Literary Device: "), 0, 3);
        literaryDevicesGrid.add(literaryDevices, 1, 2, 3, 2);
        // Sets the location of the detailed note label and text box
        literaryDevicesGrid.add(new Label("Explanation: "), 0, 4);
        literaryDevicesGrid.add(explanation, 0, 5, 3, 1);   
        // Sets the location of the validation labels 
        literaryDevicesGrid.add(literaryLabel, 6, 7); 

        // techniques grid
        GridPane techniquesGrid = new GridPane();
        // Sets horizontal and vertical gaps between rows
        techniquesGrid.setVgap(4);
        techniquesGrid.setHgap(10);
        // Sets the value of the property padding
        techniquesGrid.setPadding(new Insets(5, 5, 5, 5));
        // Sets the location of the page number label and text box
        techniquesGrid.add(new Label("Page Number: "), 0, 1);
        techniquesGrid.add(pageNumberTech, 1, 1);
        // Sets the location of the technique label and text box
        techniquesGrid.add(new Label("Technique used: "), 0, 3);
        techniquesGrid.add(techniques, 1, 2, 3, 2);
        // Sets the location of the detailed note label and text box
        techniquesGrid.add(new Label("How it was used/Impact: "), 0, 4);
        techniquesGrid.add(impact, 0, 5, 3, 1); 
        // Sets the location of the validation labels 
        techniquesGrid.add(techniqueLabel, 6, 7);

        // themes grid
        GridPane themesGrid = new GridPane();
        // Sets horizontal and vertical gaps between rows
        themesGrid.setVgap(4);
        themesGrid.setHgap(10);
        // Sets the value of the property padding
        themesGrid.setPadding(new Insets(5, 5, 5, 5));
        // Sets the location of the page number label and text box
        themesGrid.add(new Label("Page Number: "), 0, 1);
        themesGrid.add(pageNumberTheme, 1, 1);
        // Sets the location of the themes label and text box
        themesGrid.add(new Label("Themes: "), 0, 3);
        themesGrid.add(themes, 1, 2, 3, 2);
        // Sets the location of the detailed note label and text box
        themesGrid.add(new Label("How is it Implied?: "), 0, 4);
        themesGrid.add(implied, 0, 5, 3, 1);            
        // Sets the location of the validation labels  
        themesGrid.add(themesLabel, 6, 7);

        // important quotes grid
        GridPane importantQuotesGrid = new GridPane();
        // Sets horizontal and vertical gaps between rows
        importantQuotesGrid.setVgap(4);
        importantQuotesGrid.setHgap(10);
        // Sets the value of the property padding
        importantQuotesGrid.setPadding(new Insets(5, 5, 5, 5));
        // Sets the location of the page number label and text box
        importantQuotesGrid.add(new Label("Page Number: "), 0, 1);
        importantQuotesGrid.add(pageNumberQ, 1, 1);
        // Sets the location of the significant quotes label and text box
        importantQuotesGrid.add(new Label("Significant Quotes: "), 0, 3);
        importantQuotesGrid.add(importantQuotes, 1, 2, 3, 2);
        // Sets the location of the detailed note label and text box
        importantQuotesGrid.add(new Label("Quote Explanation: "), 0, 4);
        importantQuotesGrid.add(quoteExplanation, 0, 5, 3, 1);  
        // Sets the location of the validation labels 
        importantQuotesGrid.add(quotesLabel, 6, 7);   

        // plot analysis grid
        GridPane plotAnalysisGrid = new GridPane();
        // Sets horizontal and vertical gaps between rows
        plotAnalysisGrid.setVgap(4);
        plotAnalysisGrid.setHgap(10);
        // Sets the value of the property padding
        plotAnalysisGrid.setPadding(new Insets(5, 5, 5, 5));
        // Sets the location of the page number label and text box
        plotAnalysisGrid.add(new Label("Page Number: "), 0, 1);
        plotAnalysisGrid.add(pageNumberP, 1, 1);
        // Sets the location of the analysis label and text box
        plotAnalysisGrid.add(new Label("Analysis Name: "), 0, 3);
        plotAnalysisGrid.add(plotAnalysis, 1, 2, 3, 2);
        // Sets the location of the detailed note label and text box
        plotAnalysisGrid.add(new Label("Plot Analysis: "), 0, 4);
        plotAnalysisGrid.add(analysisText, 0, 5, 3, 1);     
        // Sets the location of the validation labels 
        plotAnalysisGrid.add(plotLabel, 6, 7);

        // additional notes grid
        GridPane additionalNotesGrid = new GridPane();
        // Sets horizontal and vertical gaps between rows
        additionalNotesGrid.setVgap(4);
        additionalNotesGrid.setHgap(10);
        // Sets the value of the property padding
        additionalNotesGrid.setPadding(new Insets(5, 5, 5, 5));
        // Sets the location of the page number label and text box
        additionalNotesGrid.add(new Label("Page Number: "), 0, 1);
        additionalNotesGrid.add(pageNumberA, 1, 1);
        // Sets the location of the title label and text box
        additionalNotesGrid.add(new Label("Title: "), 0, 3);
        additionalNotesGrid.add(additionalNotes, 1, 2, 3, 2);
        // Sets the location of the detailed note label and text box
        additionalNotesGrid.add(new Label("Additional Note: "), 0, 4);
        additionalNotesGrid.add(notes, 0, 5, 3, 1); 
        // Sets the location of the validation labels 
        additionalNotesGrid.add(additonLabel, 6, 7);

        // Grants user to read file
        Group root = (Group)scene2.getRoot();

        //the switch value will switch scenes when needed 
        switch (value) {
            //charcters scene
            case "Characters" : {
                //set the title as characters
                window.setTitle("Characters");
                //place the submit button
                characterGrid.add(submitButton, 0, 6);
                //the submit button needs an action so the tasks are done
                submitButton.setOnAction((ActionEvent event)->{
                    //the method 
                    if(checkingInt(pageNumberC,charactersLabel2,"enter a valid page number" )){
                        charactersLabel2.setText("page number valid"); 
                    //if all the areas and text fields are filled put it into the csv file
                    if(!pageNumberC.getText().isEmpty()&&!character.getText().isEmpty()&&!detailText.getText().isEmpty()){
                        //the file name is characters
                            File writeFile = new File("characters.csv");
                            //add the writer method so the data gets placed in the csv file
                            writer(writeFile,pageNumberC,character,detailText);
                            charactersLabel.setText("success, saved in csv file");
    
                        }
                        //if the text boes arent all filled up then output error message
                        else{
                            error(detailText,pageNumberC,character,charactersLabel); 
    
                        }
                    }
             
                });
                //place the charcter grid 
                root.getChildren().add(characterGrid);
                // break it so all functions stop here
                break;   
            }
                
            //switch to literacy devices screen
            case "Literary Devices" : {
                //set window title
                window.setTitle("Literary Devices");
                //place the submit button
                literaryDevicesGrid.add(submitButton, 0, 6);
                //the submit button's action will allow the processes to continue
                submitButton.setOnAction((ActionEvent event)->{
                    //check if the page number is valid
                    checkingInt(pageNumberL,literaryLabel2,"enter a valid page number" );
                    //output that the page number valid if it is
                       literaryLabel2.setText("page number valid");  
                       //check if the text boxes are empty, if they arent execute the next couple of lines of code
                    if(!explanation.getText().isEmpty()&&!pageNumberL.getText().isEmpty()&&!literaryDevices.getText().isEmpty()){
                        //name the file
                        File writeFile = new File("literaryDevices.csv");
                    //write user inputs into the file
                       writer(writeFile,pageNumberL,literaryDevices,explanation);
                       //display success message 
                       literaryLabel.setText("success, saved in csv file");
                    }
                    //if the textboxes arent all filled then output the error
                    else{
                    error(explanation,pageNumberL,literaryDevices, literaryLabel);  
                    }
                
                });
                //set the literary Devices grid
                root.getChildren().add(literaryDevicesGrid);
                //break program
                break;
            }
            //switch to techniques 
            case "Techniques" : {
            //set window title
                window.setTitle("Techniques");
                //set the submit button
                techniquesGrid.add(submitButton, 0, 6);
                //the button should be an action so the next steps can be executed
                submitButton.setOnAction((ActionEvent event)->{
                    //check if the page number is valid
                    if(checkingInt(pageNumberTech,techniqueLabel2,"enter a valid page number" )){
                        literaryLabel2.setText("page number valid");  
                        //check if all text fields are completed
                    if(!pageNumberTech.getText().isEmpty()&&!techniques.getText().isEmpty()&&!impact.getText().isEmpty()){
                        //add file name to place all user inputs
                        File writeFile = new File("techniques.csv");
                        //add method to write all inputs in file
                        writer(writeFile,pageNumberTech,techniques,impact);
                        techniqueLabel.setText("success, saved in csv file");
                    }
                    //if textfields are incomplete show next error
                    else {
                        error(impact,pageNumberTech,techniques,techniqueLabel); 
                    }
                }
                });
                //place the techniques grid
                root.getChildren().add(techniquesGrid);
                //break it here so no more actions happen in this scene
                break;
            } 
            //switch to the themes frame
            case "Themes" : {
                //set the title for the window 
                window.setTitle("Themes");
                //place the submit button
                themesGrid.add(submitButton, 0, 6);
                //set the submit button as an actio so the next steps can be taken
                submitButton.setOnAction((ActionEvent event)->{
                    //check if the page number is valid 
                    if(checkingInt(pageNumberTheme,themesLabel2,"enter a valid page number" )){
                        themesLabel2.setText("page number valid");  
                    //check if all the text fields are complete 
                    if(!pageNumberTheme.getText().isEmpty()&&!themes.getText().isEmpty()&&!implied.getText().isEmpty()){
                        //write the file name into the file variable
                        File writeFile = new File("themes.csv");
                        //write user inputs into the file
                        writer(writeFile,pageNumberTheme,themes,implied);
                        //output that the data was added to the csv 
                        themesLabel.setText("success, saved in csv file");
                    }
                    //if the text areas and text fields are not completed show error
                    else {
                        error(implied,pageNumberTheme,themes,themesLabel);  
                    }
                }
                });
                //Place the themesGrid 
                root.getChildren().add(themesGrid);
                //break here so the scene is done
                break;
            } 
            //switch to the inportant quotes scene
            case "Important Quotes" : {
                //set the title 
                window.setTitle("Important Quotes");
                //place submit button
                importantQuotesGrid.add(submitButton, 0, 6);
                //add action to button so next steps are executed
                submitButton.setOnAction((ActionEvent event)->{
                    //check if the page number is valud
                    if(checkingInt(pageNumberQ,quotesLabel2,"enter a valid page number" )){
                        quotesLabel2.setText("page number valid");  
                        //check if all text areas and text fields are filles
                    if(!pageNumberQ.getText().isEmpty()&&!importantQuotes.getText().isEmpty()&&!quoteExplanation.getText().isEmpty()){
                        //file name is the important quotes file
                        File writeFile = new File("importantQuotes.csv");
                        //write intot he file
                        writer(writeFile,pageNumberQ,importantQuotes,quoteExplanation);
                        //output sucess message
                        quotesLabel.setText("success, saved in csv file");
                    }
                    //if all areas arent filled then show error
                    else {
                        error(quoteExplanation,pageNumberQ,importantQuotes,quotesLabel); 
                    }
                }
                });
                //ste the grid
                root.getChildren().add(importantQuotesGrid);
                //break program
                break;
            } 
            //switch to the plot screen
            case "Plot Analysis" : {
                //set the title
                window.setTitle("Plot Analysis");
                //add subit button
                plotAnalysisGrid.add(submitButton, 0, 6);
                //add action to button
                submitButton.setOnAction((ActionEvent event)->{
                    //check if the page number is valid
                    if(checkingInt(pageNumberP,plotLabel2,"enter a valid page number" )){
                        plotLabel2.setText("page number valid");  
                        //check if the the text fields are complete
                    if(!pageNumberP.getText().isEmpty()&&!plotAnalysis.getText().isEmpty()&&!analysisText.getText().isEmpty()){
                        //set the file name
                        File writeFile = new File("plotAnalysis.csv");
                        //add the user inputs into the file
                        writer(writeFile,pageNumberP,plotAnalysis,analysisText);
                        //add message
                        plotLabel.setText("success, saved in csv file");
                    }
                    //if the text areas arent complete then show error
                    else {
                        error(analysisText,pageNumberP,plotAnalysis,plotLabel);   
                    }
                }
                });
                //set the grid
                root.getChildren().add(plotAnalysisGrid);
                //break the scene
                break;
            } 
            //switch to the additonal notes screen
            case "Additional Notes" : {
                //set the title 
                window.setTitle("Additional Notes");
                //add the submit button
                additionalNotesGrid.add(submitButton, 0, 6);
                //add action to button
                submitButton.setOnAction((ActionEvent event)->{
                    //check if page numebrs valid
                    if(checkingInt(pageNumberA,additonLabel2,"enter a valid page number" )){
                        //if it is valid output success
                        quotesLabel2.setText("page number valid");  
                        //check if the text areas or text fields are empty. If they are filled then do next tasks
                    if(!pageNumberA.getText().isEmpty()&&!additionalNotes.getText().isEmpty()&&!notes.getText().isEmpty()){
                        //set the file name
                        File writeFile = new File("additionalNotes.csv");
                        //write into the file if the text fields are completed
                        writer(writeFile,pageNumberA,additionalNotes,notes);
                        additonLabel.setText("success, saved in csv file");
                    }
                    //of the etxt fields are empty output error
                    else{
                        error(notes,pageNumberA,additionalNotes,additonLabel); 
                    }
                }
                });
                //set the grid
                root.getChildren().add(additionalNotesGrid);
                //break the scene
                break;
            }
        }
        //set the window scene2
        window.setScene(scene2);
        //show the window 
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

/**
 * description- this method will display the message that the text fields/text area isnt completed and must be completed 
 * @author - Lakysha
 * @param textArea- text area is for checking if the text area of each scene is filled
 * @param page - checking if the page number text field is filled
 * @param topic -checking if the topic text field is filled
 * @param selected1 -placing and showing the error message 
 */
     private static void error(TextArea textArea,TextField page, TextField topic, Label selected1) {
        if (textArea.getText().isEmpty()||page.getText().isEmpty()||topic.getText().isEmpty())
        {
        selected1.setText("Please complete all fields");
        }
   
    }

/**
 * description- this is a void method that will write into the csv file 
 * @author - Lakysha
 * @param writeFile -write file is the file with the needed file name
 * @param page -page is the page number and will be displayed in the file
 * @param topic -topic is the topic  and will be displayed in the filec
 * @param details -details is the user inputs for the details and will be displayed in the file
 */
    private static void writer(File writeFile, TextField page, TextField topic, TextArea details) {
        //try will try the tasks
        try {
            //print write will allow content to be placed in the csv file. Sets to true so nothing gets overwritten
            PrintWriter pw = new PrintWriter(new FileWriter(writeFile, true));
            //print the page,topic and details number with the delimeter on the csv file
            pw.write(page.getText()+"/"); 
            pw.write(topic.getText()+"/");
            pw.write(details.getText());
            //add a line so it skips one
            pw.println();
            //flush will clear streams an dmake sure so over wrting happens
            pw.flush();
            //close it
            pw.close();
        }
        //catch with the exception
        catch (IOException e) {
          e.printStackTrace();
        }
      
    }
    /**
     * descripition- this is a boolean method that returns true if the page number is an integer and false if its not an integer
     * @author - Lakysha
     * @param page -the page number of each scene is needed so it can be converted to an int
     * @param label2 -label 2 will show the message
     * @param message -the string that will be outputted
     * @return -returns true or false
     */
    private static boolean checkingInt(TextField page, Label label2, String message) 
    { 
        //try these tasks 
        try 
        { 
            //change the page number into an int
            Integer.parseInt(page.getText()); 
            //if its an int retrun true
            return true; 
        } 
        //if try doesnt execute
        catch (NumberFormatException e) 
        { 
            //output the label
            label2.setText(message);
            //if its not an int return false
            return false; 
        } 
    }
}

 /**
  * @author Chloe Chak and Dhruvika
  */
class thirdScene extends noteTaker {
    
    /**
     * @author Chloe Chak 
     */
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

        /**
         * Chloe Chak 
         * 
         * Description: takes the value of the user inputs from the csv file and records it 
         * 
         * @param pageNumber: stores page number from the csv file
         * @param Topic: stores the character name, literary device used etc... 
         * @param Description: stores user input fo the description of their topic 
         */
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
 
    /**
     * Chloe Chak : tableview 
     * Dhruvika: switch statement 
     * 
     * Description: creates the tableview in a new scene and adds the recorded information into it 
     * 
     * @param value: takes the option chosen from the combobox 
     */

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

        
        // This is a switch statment, allows expression values are compared with case values
        switch (value) {
 
            // Each value in a switch statement is a case 
            // Characters case
            case "Characters" : {

                // Setting the title for this window 
                window2.setTitle("Characters");
                
                // Storing the CSV file and dilimiter as a string
                String CsvFile = "Characters.csv";
                String FieldDelimiter = "/";
                
                // Buffered reader allows the text file to be read from user input 
                // Buffered reader was used because it is faster than scanner and ONLY reads character stream
                BufferedReader br; 
    
                // Try and Catch - allows for code to be tested for errors
                try {
    
                    // Buffer reader is reading file
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    // While loop for printing the user input on the table
                    while((line = br.readLine()) !=null) {
    
                        // Dilimiter is being implemented 
                        String[] fields = line.split(FieldDelimiter, -1); 

                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        dataList.add(record); 
                    } 
                }
 
                
                // Must include if file is not found - if try is unable to be executed 
                catch (FileNotFoundException ex) { 
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                // GUI portion 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            }

            // Each value in a switch statement is a case 
            // Literary Devices case
            case "Literary Devices" : {
                
                // Setting the title
                window2.setTitle("Literary Devices"); 
                
                // Storing the CSV file and dilimiter as a string
                String CsvFile = "literaryDevices.csv";
                String FieldDelimiter = "/";
    
                // Buffered reader allows the text file to be read from user input 
                // Buffered reader was used because it is faster than scanner and ONLY reads character stream
                BufferedReader br; 
    
                // Try and Catch -  allows for code to be tested for errors
                try {
    
                    // Buffer reader is reading file
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    // While loop for printing the user input on the table 
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);
 
                        dataList.add(record); 
                    } 
                }
 
                // Must include if file is not found - if try is unable to be executed
                catch (FileNotFoundException ex) { 
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                // GUI portion 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
                window.setTitle("Literary Devices");
                break;
            } 
            
 
            // Each value in a switch statement is a case 
            // Techniques case
            case "Techniques" : {

                // Setting the title for the window 
                window2.setTitle("Techniques"); 
 
                // Storing the CSV file and dilimiter as a string
                String CsvFile = "techniques.csv";
                String FieldDelimiter = "/";
    
                
                // Buffered reader allows the text file to be read from user input 
                // Buffered reader was used because it is faster than scanner and ONLY reads character stream
                BufferedReader br; 
    
                // Try and Catch -  allows for code to be tested for errors
                try {
    
                    // Buffer reader is reading file
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    // While loop for printing the user input on the table 
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);
 
                        dataList.add(record); 
                    } 
                }
 
                // Must include if file is not found - if try is unable to be executed
                catch (FileNotFoundException ex) { 
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 
                // GUI (JavaFX) portion 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 
 
            // Each value in a switch statement is a case 
            // Themes case
            case "Themes" : { 
                
                // Setting the title 
                window2.setTitle("Themes"); 
 
                // Storing the CSV file and dilimiter as a string
                String CsvFile = "themes.csv"; 
                String FieldDelimiter = "/";
    
                // Buffered reader allows the text file to be read from user input 
                // Buffered reader was used because it is faster than scanner and ONLY reads character stream
                BufferedReader br; 
    
                // Try and Catch -  allows for code to be tested for errors
                try {
    
                    // Buffer reader is reading file
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    // While loop for printing the user input on the table
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);
 
                        dataList.add(record); 
                    } 
                }
 
                // Must include if file is not found - if try is unable to be executed
                catch (FileNotFoundException ex) { 
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 
                // GUI (JavaFX) Portion 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
                
                break;
            } 
 
            // Each value in a switch statement is a case 
            // Important Quotes case
            case "Important Quotes" : {
                
                // Setting the title 
                window2.setTitle("Important Quotes");
 
 
                // Storing the CSV file and dilimiter as a string
                String CsvFile = "importantQuotes.csv";
                String FieldDelimiter = "/";
    
                // Buffered reader allows the text file to be read from user input 
                // Buffered reader was used because it is faster than scanner and ONLY reads character stream
                BufferedReader br; 
    
                // Try and Catch -  allows for code to be tested for errors
                try {
    
                    // Buffer reader is reading file
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    // While loop for printing the user input on the table
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);
 
                        dataList.add(record); 
                    } 
                }
 
                // Must include if file is not found - if try is unable to be executed
                catch (FileNotFoundException ex) { 
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                // GUI (JavaFX) Portion 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().addAll(tableView);
 
                break;
            } 


            // Each value in a switch statement is a case 
            // Plot Analysis case
            case "Plot Analysis" : {
                
                // Setting the title 
                window2.setTitle("Plot Analysis");
              
 
                // Storing the CSV file and dilimiter as a string
                String CsvFile = "plotAnalysis.csv";
                String FieldDelimiter = "/";
    
                // Buffered reader allows the text file to be read from user input 
                // Buffered reader was used because it is faster than scanner and ONLY reads character stream
                BufferedReader br; 
    
                // Try and Catch -  allows for code to be tested for errors
                try {
    
                    // Buffer reader is reading file
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    // While loop for printing the user input on the table
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);
 
                        dataList.add(record); 
                    } 
                }
 
                // Must include if file is not found - if try is unable to be executed
                catch (FileNotFoundException ex) { 
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                // GUI (JavaFX) Portion 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            } 

            // Each value in a switch statement is a case 
            // Additional Notes case
            case "Additional Notes" : {
                
                // Setting the title 
                window2.setTitle("Additional Notes");
             
 
                // Storing the CSV file and dilimiter as a string
                String CsvFile = "additionalNotes.csv";
                String FieldDelimiter = "/";
    
                // Buffered reader allows the text file to be read from user input 
                // Buffered reader was used because it is faster than scanner and ONLY reads character stream
                BufferedReader br; 
    
                // Try and Catch -  allows for code to be tested for errors
                try {
    
                    // Buffer reader is reading file
                    br = new BufferedReader(new FileReader(CsvFile)); 
    
                    String line; 
                    
                    // While loop for printing the user input on the table
                    while((line = br.readLine()) !=null) {
    
                        String[] fields = line.split(FieldDelimiter, -1); 
                        Record record = new Record(fields[0], fields[1], fields[2]); 
                        System.out.println(fields[0]);
                        System.out.println(fields[1]);
                        System.out.println(fields[2]);
 
                        dataList.add(record); 
                    } 
                }
 
                // Must include if file is not found - if try is unable to be executed
                catch (FileNotFoundException ex) { 
 
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);    
                }
    
                catch (IOException ex) {
                    Logger.getLogger(thirdScene.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                // GUI (JavaFX) Portion 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            }
        }

        // Shows the window 
        window2.setScene(scene3);
        window2.show();
    }
}


