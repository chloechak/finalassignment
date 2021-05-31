/* 
 * Date: May 28, 2021 
 * Names: 
 * Teacher: 
 * Description: 
 * 
*/

// Final Assignment

 
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 
import javafx.scene.control.cell.PropertyValueFactory;
 
import javax.swing.JOptionPane;
import javax.swing.text.TableView;
 
public class newscene extends Application {
    Scene scene1, scene2;
@@ -407,3 +412,114 @@ public static void display (String value) {
 
    }
}
class scenes3 extends scenes {
    private SimpleStringProperty pageNumber, Topic, Description;
 
    String getPageNumber() {
        return pageNumber.get();
    }
 
    String getTopicrName() {
        return Topic.get();
    }
 
    String getDescription() {
        return Description.get();
    }
 
    public void Record(String pageNumber, String Topic, String Description) {
        this.pageNumber = new SimpleStringProperty(pageNumber);
        this.Topic = new SimpleStringProperty(Topic);
        this.Description = new SimpleStringProperty(Description);
 
    }
 
    private final static TableView<Record> tableView = new TableView<>();
    private final static ObservableList<Record> dataList = FXCollections.observableArrayList();
 
    public static void display (String value) { 
        Stage window2 = new Stage();
        Scene scene3 = new Scene(new Group(), 850, 450);
 
        // Character read notes scene 
        TableColumn columnA1 = new TableColumn("Page Number");
        columnA1.setCellValueFactory(new PropertyValueFactory<>("Page Number"));
 
        TableColumn columnA2 = new TableColumn("Topic");
        columnA2.setCellValueFactory(new PropertyValueFactory<>("Topic"));
 
        TableColumn columnA3 = new TableColumn("Details");
        columnA3.setCellValueFactory(new PropertyValueFactory<>("Details"));
 
        // // Literary Devices read notes scene 
        // TableColumn columnB1 = new TableColumn("Page Number");
        // columnB1.setCellValueFactory(new PropertyValueFactory<>("Page Number"));
 
        // TableColumn columnB2 = new TableColumn("Literary Device");
        // columnB2.setCellValueFactory(new PropertyValueFactory<>("Literary Device"));
 
        // TableColumn columnB3 = new TableColumn("Explanation");
        // columnB3.setCellValueFactory(new PropertyValueFactory<>("Explanation"));
 
        // // Techniques read notes scene 
        // TableColumn columC1 = new TableColumn("Page Number");
        // columnA1.setCellValueFactory(new PropertyValueFactory<>("Page Number"));
 
        // TableColumn columnC2 = new TableColumn("Character Name");
        // columnA2.setCellValueFactory(new PropertyValueFactory<>("Character Name"));
 
        // TableColumn columnC3 = new TableColumn("Character Notes");
        // columnA3.setCellValueFactory(new PropertyValueFactory<>("Character Notes"));
 
        tableView.setItems(dataList);
        Group root = (Group)scene3.getRoot();
 
 
        switch (value) {
 
            case "Characters" : {
 
                String CsvFile = "Characters.csv";
                String FieldDelimiter = ",";
 
                BufferedReader br; 
 
                try {
 
                    br = new BufferedReader(new FileReader(CsvFile)); 
 
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
 
                        String[] fields = line.split(FieldDelimiter, -1); 
 
                        Record record =new Record(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]); 
                        dataList.add(record); 
                    } 
                }
 
                catch (FileNotFoundException ex) { 
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);    
                }
 
                catch (IOException ex) {
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);
                }
 
 
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            }
 
            case "Literary Devices" : {
 
                String CsvFile = "literaryDevices.csv";
                String FieldDelimiter = ",";
 
                BufferedReader br; 
 
                try {
 
                    br = new BufferedReader(new FileReader(CsvFile)); 
 
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
 
                        String[] fields = line.split(FieldDelimiter, -1); 
 
                        Record record =new Record(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]); 
                        dataList.add(record); 
                    } 
                }
 
                catch (FileNotFoundException ex) { 
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);    
                }
 
                catch (IOException ex) {
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            } 
 
            case "Techniques" : {
 
                String CsvFile = "Techniques.csv";
                String FieldDelimiter = ",";
 
                BufferedReader br; 
 
                try {
 
                    br = new BufferedReader(new FileReader(CsvFile)); 
 
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
 
                        String[] fields = line.split(FieldDelimiter, -1); 
 
                        Record record =new Record(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]); 
                        dataList.add(record); 
                    } 
                }
 
                catch (FileNotFoundException ex) { 
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);    
                }
 
                catch (IOException ex) {
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            } 
 
            case "Themes" : {
 
                String CsvFile = "Themes.csv";
                String FieldDelimiter = ",";
 
                BufferedReader br; 
 
                try {
 
                    br = new BufferedReader(new FileReader(CsvFile)); 
 
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
 
                        String[] fields = line.split(FieldDelimiter, -1); 
 
                        Record record =new Record(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]); 
                        dataList.add(record); 
                    } 
                }
 
                catch (FileNotFoundException ex) { 
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);    
                }
 
                catch (IOException ex) {
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            } 
 
            case "Important Quotes" : {
                String CsvFile = "importantQuotes.csv";
                String FieldDelimiter = ",";
 
                BufferedReader br; 
 
                try {
 
                    br = new BufferedReader(new FileReader(CsvFile)); 
 
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
 
                        String[] fields = line.split(FieldDelimiter, -1); 
 
                        Record record =new Record(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]); 
                        dataList.add(record); 
                    } 
                }
 
                catch (FileNotFoundException ex) { 
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);    
                }
 
                catch (IOException ex) {
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            }
 
            case "Plot Analysis" : {
 
                String CsvFile = "plotAnalysis.csv";
                String FieldDelimiter = ",";
 
                BufferedReader br; 
 
                try {
 
                    br = new BufferedReader(new FileReader(CsvFile)); 
 
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
 
                        String[] fields = line.split(FieldDelimiter, -1); 
 
                        Record record =new Record(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]); 
                        dataList.add(record); 
                    } 
                }
 
                catch (FileNotFoundException ex) { 
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);    
                }
 
                catch (IOException ex) {
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            }
 
            case "Additional Notes" : {
                String CsvFile = "customerDataFile.csv";
                String FieldDelimiter = ",";
 
                BufferedReader br; 
 
                try {
 
                    br = new BufferedReader(new FileReader(CsvFile)); 
 
                    String line; 
                    
                    while((line = br.readLine()) !=null) {
 
                        String[] fields = line.split(FieldDelimiter, -1); 
 
                        Record record =new Record(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]); 
                        dataList.add(record); 
                    } 
                }
 
                catch (FileNotFoundException ex) { 
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);    
                }
 
                catch (IOException ex) {
                    Logger.getLogger(draft4.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                tableView.getColumns().addAll(columnA1, columnA2, columnA3);
                root.getChildren().add(tableView);
 
                break;
            }
        }
        window2.setScene(scene3);
        window2.show();
