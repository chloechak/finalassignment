/*
 * Date: May 19, 2021
 * Name: Dhruvika Bhatia 
 * Teacher: Mr. Ho
 * Description: Methods Portion of CHLOE H's part - graphics designer
 *
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

class MethodsExtendApp {

        launch(args);

    }
}

class newNoteApp {

    public static void main(String[] args) {
        display(value);
        display2(value2);
        display3(value3);
        display4(value4);
        display5(value5);
        display6(value6);
        display7(value7);
        display8(value8);
        display9(value9);
        display10(value10);
        display11(value11);
        display12(value12);
        display13(value13);
        display14(value14);
        display15(value15);
        display16(value16);
        display17(value17);
        display18(value18);
        display19(value19);

    }

    static void display (String value) {

        display = value; 

        Scene scene2 = new Scene(new Group(), 850, 450);

        TextField character = new TextField("");
        TextField literaryDevices = new TextField("");
        TextField techniques = new TextField("");
        TextField themes = new TextField("");
        TextField importantQuotes = new TextField("");
        TextField plotAnalysis = new TextField("");
        TextField additionalNotes = new TextField("");

    }

     static void display2 (String value2) {

        TextField pageNumberC = new TextField("");
        TextField pageNumberL = new TextField("");
        TextField pageNumberTech = new TextField("");
        TextField pageNumberTheme = new TextField("");
        TextField pageNumberQ = new TextField("");
        TextField pageNumberP = new TextField("");
        TextField pageNumberA = new TextField("");

    }

    static void display3 (String value3) {

        TextField pageNumberC = new TextField("");
        TextField pageNumberL = new TextField("");
        TextField pageNumberTech = new TextField("");
        TextField pageNumberTheme = new TextField("");
        TextField pageNumberQ = new TextField("");
        TextField pageNumberP = new TextField("");
        TextField pageNumberA = new TextField("");

    }

    public static void display4 (String value4) {

        TextArea detailText = new TextArea ("");
        TextArea explanation = new TextArea ("");
        TextArea impact = new TextArea ("");
        TextArea implied = new TextArea ("");
        TextArea quoteExplanation = new TextArea ("");
        TextArea analysisText = new TextArea ("");
        TextArea notes = new TextArea ("");

    }

    public static void display5(String value5) {

        Button submitButton = new Button ("Submit");

    }

    public static void display6 (String value6) {

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

    }

     static void display7 (String value7) {

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

    }

     static void display8 (String value8) {

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
         
    }

     static void display9 (String value9) {

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

    }

     static void display10 (String value10) {

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

    }

     static void display11 (String value11){

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
    }

    public static void display12 (String value12) {

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
         
    }

    public static void display13 (String value13) {

        witch (value) {
            
            case "Characters" : {
                Stage characterWindow = new Stage();
                characterWindow.setTitle("Characters");
                // window.setHeight(450);
                // window.setWidth(250);

                root.getChildren().add(characterGrid);
                characterGrid.add(submitButton, 0, 6);
                break;
            }
    }

    public static void display14 (String value14) {

        case "Literary Devices" : {
            Stage literaryDevicesWindow = new Stage();
            literaryDevicesWindow.setTitle("Literary Devices");
            // window.setHeight(450);
            // window.setWidth(250);

            root.getChildren().add(literaryDevicesGrid);
            literaryDevicesGrid.add(submitButton, 0, 6);
            break;
        } 
    }
    
    public static void display15 (String value15) {

        case "Techniques" : {
            Stage techniquesWindow = new Stage();
            techniquesWindow.setTitle("Techniques");
            // window.setHeight(450);
            // window.setWidth(250);

            root.getChildren().add(techniquesGrid);
            techniquesGrid.add(submitButton, 0, 6);
            break;
        } 
    }

    public static void display16 (String value16) {

        case "Themes" : {
            Stage themesWindow = new Stage();
            themesWindow.setTitle("Themes");
            // window.setHeight(450);
            // window.setWidth(250);

            root.getChildren().add(themesGrid);
            themesGrid.add(submitButton, 0, 6);
            break;
        } 
    }

    public static void display17 (String value17) {

        case "Important Quotes" : {
            Stage importantQuotesWindow = new Stage();
            importantQuotesWindow.setTitle("Important Quotes");
            // window.setHeight(450);
            // window.setWidth(250);

            root.getChildren().add(importantQuotesGrid);
            importantQuotesGrid.add(submitButton, 0, 6);
            break;
        } 
    }

    public static void display18 (String value18) {

        case "Plot Analysis" : {
            Stage plotAnalysisWindow = new Stage();
            plotAnalysisWindow.setTitle("Plot Analysiss");
            // window.setHeight(450);
            // window.setWidth(250);

            root.getChildren().add(plotAnalysisGrid);
            plotAnalysisGrid.add(submitButton, 0, 6);
            break;
        } 
    }

    public static void display19 (String value19) {

        case "Additional Notes" : {
            Stage additionalNotesWindow = new Stage();
            additionalNotesWindow.setTitle("Additional Notes");
            // window.setHeight(450);
            // window.setWidth(250);

            root.getChildren().add(additionalNotesGrid);
            additionalNotesGrid.add(submitButton, 0, 6);
            break;
        }
    }
}




