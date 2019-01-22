package inventory.multimedia.video;

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

public class Documentary extends Video {
    private boolean color;

    public Documentary() {
        this(false);

        setInternalID(12);
        setType(getClass().getSimpleName());
    }

    public Documentary(boolean color) {
        this.color = color;

        setInternalID(12);
        setType(getClass().getSimpleName());
    }

    public Documentary(String title, String publisher, String subDefine, String director, String screenwriter, boolean color) {
        super(title, publisher, subDefine, director, screenwriter);
        this.color = color;
        setInternalID(12);
        setType(getClass().getSimpleName());
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addDocumentary(this);
        LibraryDatabase.addVideo(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Documentary{" +
                "color=" + color +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnFinalInfo())
                .append("Multicolor: ")
                .append(isColor())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnRawInfo())
                .append(isColor())
                .append("\r\n");

        return sb;
    }

    /*
    Every inventory subclass has FX methods. This was originally held in a class of its own,
    to reduce space and confusion, now classes are more self-contained.
    This method contains code *only* for displaying the window that contains a table with class content.
     */

    public static void displayDocumentaryInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Documentary Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Documentary, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Documentary, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Documentary, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Publisher column
        TableColumn<Documentary, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(120);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        //SubDef column
        TableColumn<Documentary, String> subDefineColumn = new TableColumn<>("Genre");
        subDefineColumn.setMinWidth(120);
        subDefineColumn.setCellValueFactory(new PropertyValueFactory<>("subDefine"));

        //Director column
        TableColumn<Documentary, String> directorColumn = new TableColumn<>("Director");
        directorColumn.setMinWidth(120);
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));

        //Screenwriter column
        TableColumn<Documentary, String> screenWriterColumn = new TableColumn<>("Screenwriter");
        screenWriterColumn.setMinWidth(120);
        screenWriterColumn.setCellValueFactory(new PropertyValueFactory<>("screenwriter"));

        //Screenwriter column
        TableColumn<Documentary, Boolean> colorColumn = new TableColumn<>("Multicolor");
        colorColumn.setMinWidth(120);
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Documentary> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, publisherColumn, directorColumn, screenWriterColumn, colorColumn);
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
    private static ObservableList<Documentary> getInventory() {
        ObservableList<Documentary> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getDocumentaryList());

        return inventory;
    }
}
