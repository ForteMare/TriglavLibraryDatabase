package inventory.print.book;

import inventory.LibraryDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Novel extends Book {
    private String language;

    public Novel() {
        this("Unknown language");

        setInternalID(11);
        setType(getClass().getSimpleName());
    }

    public Novel(String language) {
        this.language = language;
        setInternalID(11);
        setType(getClass().getSimpleName());
    }

    public Novel(String title, String author, String subType, boolean hardCover, int yearPublished, String ddcLocation, String language) {
        super(title, author, subType, hardCover, yearPublished, ddcLocation);
        this.language = language;
        setInternalID(11);
        setType(getClass().getSimpleName());

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addNovel(this);
        LibraryDatabase.addBook(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Novel{" +
                "language='" + language + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Language: ")
                .append(getLanguage())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getLanguage())
                .append("\r\n");

        return sb;
    }

    public static void displayNovelInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Novel Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Novel, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Novel, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Novel, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Author column
        TableColumn<Novel, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(120);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<Novel, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(120);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Hard cover column
        TableColumn<Novel, Boolean> hardCoverColumn = new TableColumn<>("Hard Cover");
        hardCoverColumn.setMinWidth(120);
        hardCoverColumn.setCellValueFactory(new PropertyValueFactory<>("hardCover"));

        //Year published column
        TableColumn<Novel, Integer> yearPublishedColumn = new TableColumn<>("Year Published");
        yearPublishedColumn.setMinWidth(120);
        yearPublishedColumn.setCellValueFactory(new PropertyValueFactory<>("yearPublished"));

        //DDC Location column
        TableColumn<Novel, String> ddcLocationColumn = new TableColumn<>("DDC Number");
        ddcLocationColumn.setMinWidth(120);
        ddcLocationColumn.setCellValueFactory(new PropertyValueFactory<>("ddcLocation"));

        //Language column
        TableColumn<Novel, String> languageColumn = new TableColumn<>("Language");
        languageColumn.setMinWidth(120);
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Novel> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, hardCoverColumn,
                yearPublishedColumn, ddcLocationColumn, languageColumn);

        // VBox for holding button controls
        VBox controls = new VBox(15);
        controls.setPadding(new Insets(10));
        controls.getChildren().addAll(table, close);

        // Setting up the scene
        Scene scene = new Scene(controls, 1150, 450);

        // Setting up the stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    //Get all of the inventory
    private static ObservableList<Novel> getInventory() {
        ObservableList<Novel> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getNovelList());

        return inventory;
    }
}
