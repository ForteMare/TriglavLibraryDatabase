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

public class TouristGuide extends Book {
    private String region;
    private boolean includesMap;

    public TouristGuide() {
        this("Unknown region", false);
        setInternalID(7);
        setType(getClass().getSimpleName());
    }

    public TouristGuide(String region, boolean includesMap) {
        this.region = region;
        this.includesMap = includesMap;
        setInternalID(7);
        setType(getClass().getSimpleName());
    }

    public TouristGuide(String title, String author, String subType, boolean hardCover, int yearPublished, String ddcLocation, String region, boolean includesMap) {
        super(title, author, subType, hardCover, yearPublished, ddcLocation);
        this.region = region;
        this.includesMap = includesMap;
        setInternalID(7);
        setType(getClass().getSimpleName());
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isIncludesMap() {
        return includesMap;
    }

    public void setIncludesMap(boolean includesMap) {
        this.includesMap = includesMap;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addTouristGuide(this);
        LibraryDatabase.addBook(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "TouristGuide{" +
                "region='" + region + '\'' +
                ", includesMap=" + includesMap +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Region: ")
                .append(getRegion())
                .append("\r\n")
                .append("Hiking trails: ")
                .append(isIncludesMap())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getRegion())
                .append("\r\n")
                .append(isIncludesMap())
                .append("\r\n");

        return sb;
    }

    public static void displayTouristGuideInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Tourist Guide Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<TouristGuide, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<TouristGuide, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<TouristGuide, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
//
        //Author column
        TableColumn<TouristGuide, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(120);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<TouristGuide, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(120);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Hard cover column
        TableColumn<TouristGuide, String> hardCoverColumn = new TableColumn<>("Hard Cover");
        hardCoverColumn.setMinWidth(120);
        hardCoverColumn.setCellValueFactory(new PropertyValueFactory<>("hardCover"));

        //Year published column
        TableColumn<TouristGuide, String> yearPublishedColumn = new TableColumn<>("Year Published");
        yearPublishedColumn.setMinWidth(120);
        yearPublishedColumn.setCellValueFactory(new PropertyValueFactory<>("yearPublished"));

        //DDC Location column
        TableColumn<TouristGuide, String> ddcLocationColumn = new TableColumn<>("DDC Number");
        ddcLocationColumn.setMinWidth(120);
        ddcLocationColumn.setCellValueFactory(new PropertyValueFactory<>("ddcLocation"));

        //DDC Location column
        TableColumn<TouristGuide, String> regionColumn = new TableColumn<>("Region");
        regionColumn.setMinWidth(120);
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));

        //DDC Location column
        TableColumn<TouristGuide, String> containsMapsColumn = new TableColumn<>("Maps Included");
        containsMapsColumn.setMinWidth(120);
        containsMapsColumn.setCellValueFactory(new PropertyValueFactory<>("ddcLocation"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<TouristGuide> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, hardCoverColumn,
                yearPublishedColumn, ddcLocationColumn, regionColumn, containsMapsColumn);

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
    private static ObservableList<TouristGuide> getInventory() {
        ObservableList<TouristGuide> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getTouristGuideList());

        return inventory;
    }
}
