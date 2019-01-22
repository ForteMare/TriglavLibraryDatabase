package inventory.print.periodical;

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

public class Newspaper extends Periodical {
    private boolean tabloid;

    public Newspaper() {
        this(false);

        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public Newspaper(boolean tabloid) {
        this.tabloid = tabloid;

        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public Newspaper(String title, String author, String genre, String publicationFrequency, boolean tabloid) {
        super(title, author, genre, publicationFrequency);
        this.tabloid = tabloid;

        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public boolean isTabloid() {
        return tabloid;
    }

    public void setTabloid(boolean tabloid) {
        this.tabloid = tabloid;
    }


    @Override
    public void addToDatabase() {
        LibraryDatabase.addNewspaper(this);
        LibraryDatabase.addPeriodical(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "tabloid=" + tabloid +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Tabloid: ")
                .append(isTabloid())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isTabloid())
                .append("\r\n");

        return sb;
    }

    /*
    Every inventory subclass has FX methods. This was originally held in a class of its own,
    to reduce space and confusion, now classes are more self-contained.
    This method contains code *only* for displaying the window that contains a table with class content.
     */

    public static void displayNewspaperInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Newspaper Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Newspaper, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Newspaper, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Newspaper, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Author column
        TableColumn<Newspaper, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(120);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<Newspaper, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(120);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Publication column
        TableColumn<Newspaper, String> publicationColumn = new TableColumn<>("Publication Frequency");
        publicationColumn.setMinWidth(120);
        publicationColumn.setCellValueFactory(new PropertyValueFactory<>("publicationFrequency"));

        //Tabloid column
        TableColumn<Newspaper, Boolean> tabloidColumn = new TableColumn<>("Tabloid");
        tabloidColumn.setMinWidth(120);
        tabloidColumn.setCellValueFactory(new PropertyValueFactory<>("tabloid"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Newspaper> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, publicationColumn,
                tabloidColumn);

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
    private static ObservableList<Newspaper> getInventory() {
        ObservableList<Newspaper> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getNewspaperList());

        return inventory;
    }
}
