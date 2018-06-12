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

public class Magazine extends Periodical {
    private boolean qualityPrint;
    private boolean containsNudity;

    public Magazine() {
        this(false, false);
        setInternalID(13);
        setType(getClass().getSimpleName());
    }

    public Magazine(boolean qualityPrint, boolean containsNudity) {
        this.qualityPrint = qualityPrint;
        this.containsNudity = containsNudity;
        setInternalID(13);
        setType(getClass().getSimpleName());
    }

    public Magazine(String title, String author, String genre, String publicationFrequency, boolean qualityPrint, boolean containsNudity) {
        super(title, author, genre, publicationFrequency);
        this.qualityPrint = qualityPrint;
        this.containsNudity = containsNudity;
        setInternalID(13);
        setType(getClass().getSimpleName());
    }

    public boolean isQualityPrint() {
        return qualityPrint;
    }

    public void setQualityPrint(boolean qualityPrint) {
        this.qualityPrint = qualityPrint;
    }

    public boolean isContainsNudity() {
        return containsNudity;
    }

    public void setContainsNudity(boolean containsNudity) {
        this.containsNudity = containsNudity;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addMagazine(this);
        LibraryDatabase.addPeriodical(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "qualityPrint=" + qualityPrint +
                ", containsNudity=" + containsNudity +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Quality print: ")
                .append(isQualityPrint())
                .append("\r\n")
                .append("For minors: ")
                .append(isContainsNudity())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isQualityPrint())
                .append("\r\n")
                .append(isContainsNudity())
                .append("\r\n");

        return sb;
    }

    public static void displayMagazineInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Magazine Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Magazine, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Magazine, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Magazine, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Author column
        TableColumn<Magazine, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(100);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<Magazine, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(100);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Publication column
        TableColumn<Magazine, String> publicationColumn = new TableColumn<>("Publication Frequency");
        publicationColumn.setMinWidth(100);
        publicationColumn.setCellValueFactory(new PropertyValueFactory<>("publicationFrequency"));

        //Quality Print column
        TableColumn<Magazine, Boolean> qualityPrintColumn = new TableColumn<>("Quality Print");
        qualityPrintColumn.setMinWidth(100);
        qualityPrintColumn.setCellValueFactory(new PropertyValueFactory<>("qualityPrint"));

        //Nudity column
        TableColumn<Magazine, Boolean> nudityColumn = new TableColumn<>("Contains Nudity");
        nudityColumn.setMinWidth(100);
        nudityColumn.setCellValueFactory(new PropertyValueFactory<>("containsNudity"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Magazine> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, publicationColumn,
                qualityPrintColumn, nudityColumn);

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
    private static ObservableList<Magazine> getInventory() {
        ObservableList<Magazine> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getMagazineList());

        return inventory;
    }
}
