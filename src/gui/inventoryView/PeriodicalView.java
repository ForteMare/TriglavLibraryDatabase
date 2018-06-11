package gui.inventoryView;

import inventory.LibraryDatabase;
import inventory.print.periodical.Periodical;
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

public class PeriodicalView {

    public static void viewInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Periodical Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Periodical, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Periodical, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Periodical, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Author column
        TableColumn<Periodical, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(100);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<Periodical, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(100);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Publication column
        TableColumn<Periodical, String> publicationColumn = new TableColumn<>("Publication Frequency");
        publicationColumn.setMinWidth(100);
        publicationColumn.setCellValueFactory(new PropertyValueFactory<>("publicationFrequency"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Periodical> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, publicationColumn);

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
    public static ObservableList<Periodical> getInventory() {
        ObservableList<Periodical> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getPeriodicalList());

        return inventory;
    }
}
