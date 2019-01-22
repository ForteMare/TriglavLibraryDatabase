package inventory.multimedia.audio;

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

public class Audiobook extends Audio {
    private double length;
    private String narrator;

    public Audiobook() {
        this(0.00, "Unknown narrator");

        setInternalID(14);
        setType(getClass().getSimpleName());
    }

    public Audiobook(double length, String narrator) {
        this.length = length;
        this.narrator = narrator;

        setInternalID(14);
        setType(getClass().getSimpleName());
    }

    public Audiobook(String title, String publisher, String subDefine, String format, double length, String narrator) {
        super(title, publisher, subDefine, format);
        this.length = length;
        this.narrator = narrator;

        setInternalID(14);
        setType(getClass().getSimpleName());
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addAudiobook(this);
        LibraryDatabase.addAudio(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Audiobook{" +
                "length=" + length +
                ", narrator='" + narrator + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Length: ")
                .append(getLength())
                .append("\r\n")
                .append("Narrator: ")
                .append(getNarrator())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getLength())
                .append("\r\n")
                .append(getNarrator())
                .append("\r\n");

        return sb;
    }

    public static void displayInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Full Library Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Audiobook, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Audiobook, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Audiobook, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Publisher column
        TableColumn<Audiobook, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(120);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        //SubDef column
        TableColumn<Audiobook, String> subDefineColumn = new TableColumn<>("Genre");
        subDefineColumn.setMinWidth(120);
        subDefineColumn.setCellValueFactory(new PropertyValueFactory<>("subDefine"));

        //Format column
        TableColumn<Audiobook, String> formatColumn = new TableColumn<>("Format");
        formatColumn.setMinWidth(120);
        formatColumn.setCellValueFactory(new PropertyValueFactory<>("format"));

        //Length column
        TableColumn<Audiobook, Double> lengthColumn = new TableColumn<>("Length (min)");
        lengthColumn.setMinWidth(120);
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));

        //Narrator column
        TableColumn<Audiobook, String> narratorColumn = new TableColumn<>("Format");
        narratorColumn.setMinWidth(120);
        narratorColumn.setCellValueFactory(new PropertyValueFactory<>("narrator"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Audiobook> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, publisherColumn, subDefineColumn, formatColumn,
                lengthColumn, narratorColumn);

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
    private static ObservableList<Audiobook> getInventory() {
        ObservableList<Audiobook> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getAudiobookList());

        return inventory;
    }
}
