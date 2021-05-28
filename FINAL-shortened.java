public class FinalAssignment2 {
    public final String categories[] = 
    {"Characters", "Literary Devices", "Techniques", "Themes", "Important Quotes", "Plot Analysis", "Additional Notes"};
    
    public Label selected1 = new Label();
    public Label selected2 = new Label(); // note, this variable is not used
    public Text welcome = new Text("Welcome to your note taker");
    
    public Button submitButton = new Button ("Submit");
    public TextField character = new TextField("");
    public TextField pageNumber = new TextField("");
    public TextArea detailText = new TextArea ("");
        
    public Scene scene1, scene2;
    
    public ComboBox addNotes = new ComboBox(FXCollections.observableArrayList(categories));
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Note Taker");
        
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
        }); 

        SetupWelcomeLabel();
        Scene1Setup();
        Scene2Setup();

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    public void SetupWelcomeLabel() {
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        welcome.setX(50); 
        welcome.setY(130);
    }
    
    public void Scene1Setup() {
        Scene scene1 = new Scene(new Group(), 950, 450);
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(welcome, 0, 0);
        grid.add(new Label("add notes: "), 1,25);
        grid.add(addNotes, 1, 26);
        grid.add(selected1, 1, 27);

        Group root = (Group)scene1.getRoot();
        root.getChildren().add(grid);
    }
    
    public void Scene2Setup() {
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
    }
}