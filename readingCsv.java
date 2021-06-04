public static String[][] processCSV(String csv) {
    String[] lines = csv.split("[\n\r]");

    String[][] result = new String[lines.length][];

    for (int lineNum = 0; lineNum < lines.length; lineNum++) {
        String line = lines[lineNum];
        String[] items = line.split(",");

        result[lineNum] = new String[items.length];
        System.arraycopy(items, 0, result[lineNum], 0, items.length);
    }

    return result;
}

@Override
public void start(Stage primaryStage) {

    String[][] data = processCSV("item1,item2,item3\nitem4,item5,item6");

    StackPane root = new StackPane();
    ObservableList<String[]> dataList = FXCollections.observableArrayList();
    dataList.addAll(Arrays.asList(data));
    dataList.remove(0);//remove titles from data
    TableView<String[]> table = new TableView<>();
    for (int i = 0; i < data[0].length; i++) {
        TableColumn<String[], String> tc = new TableColumn<>(data[0][i]);
        final int colNo = i;
        tc.setCellValueFactory(p -> new SimpleStringProperty((p.getValue()[colNo])));
        tc.setPrefWidth(90);
        table.getColumns().add(tc);
    }
    table.setItems(dataList);
    root.getChildren().add(table);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
}