package inventory.print.book;

import inventory.LibraryDatabase;
import inventory.print.Print;
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

public class Book extends Print {
    private boolean hardCover;
    private int yearPublished;
    private String ddcLocation;

    public Book() {
        this(false, 1991, "Unknown Location");
        setInternalID(3);
        setType(getClass().getSimpleName());
    }

    public Book(boolean hardCover, int yearPublished, String ddcLocation) {
        this.hardCover = hardCover;
        this.yearPublished = yearPublished;
        this.ddcLocation = ddcLocation;
        setInternalID(3);
        setType(getClass().getSimpleName());
    }

    public Book(String title, String author, String subType, boolean hardCover, int yearPublished, String ddcLocation) {
        super(title, author, subType);
        this.hardCover = hardCover;
        this.yearPublished = yearPublished;
        this.ddcLocation = ddcLocation;
        setInternalID(3);
        setType(getClass().getSimpleName());

    }

    public boolean isHardCover() {
        return hardCover;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getDdcLocation() {
        return ddcLocation;
    }

    public void setDdcLocation(String ddcLocation) {
        this.ddcLocation = ddcLocation;
    }

    @Override
    public void addToDatabase() {

        LibraryDatabase.addBook(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "hardCover=" + hardCover +
                ", yearPublished=" + yearPublished +
                ", ddcLocation='" + ddcLocation + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Hard cover: ")
                .append(isHardCover())
                .append("\r\n")
                .append("Year Published: ")
                .append(getYearPublished())
                .append("\r\n")
                .append("DDC Location: ")
                .append(ddcLocation)
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isHardCover())
                .append("\r\n")
                .append(getYearPublished())
                .append("\r\n")
                .append(ddcLocation)
                .append("\r\n");

        return sb;
    }

    public static void displayInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Book Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Book, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Book, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
//
        //Author column
        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(100);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<Book, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(100);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Hard cover column
        TableColumn<Book, Boolean> hardCoverColumn = new TableColumn<>("Hard Cover");
        hardCoverColumn.setMinWidth(100);
        hardCoverColumn.setCellValueFactory(new PropertyValueFactory<>("hardCover"));

        //Year published column
        TableColumn<Book, Integer> yearPublishedColumn = new TableColumn<>("Year Published");
        yearPublishedColumn.setMinWidth(100);
        yearPublishedColumn.setCellValueFactory(new PropertyValueFactory<>("yearPublished"));

        //DDC Location column
        TableColumn<Book, String> ddcLocationColumn = new TableColumn<>("DDC Number");
        ddcLocationColumn.setMinWidth(100);
        ddcLocationColumn.setCellValueFactory(new PropertyValueFactory<>("ddcLocation"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Book> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, hardCoverColumn, yearPublishedColumn, ddcLocationColumn);

        // VBox for holding button controls
        VBox controls = new VBox(15);
        controls.setPadding(new Insets(10));
        controls.getChildren().addAll(table, close);

        // Setting up the scene
        Scene scene = new Scene(controls, 530, 480);

        // Setting up the stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    //Get all of the inventory
    private static ObservableList<Book> getInventory() {
        ObservableList<Book> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getBookList());

        return inventory;
    }

}
