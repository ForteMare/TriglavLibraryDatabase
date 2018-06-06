package gui.retrieveInventory;

import inventory.Inventory;
import inventory.LibraryDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryView {

    public static void viewItems() {

        //Title column
        TableColumn<Inventory, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Inventory, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Inventory, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        TableView<Inventory> table = new TableView<Inventory>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn);

        // VBox for holding button controls
        VBox controls = new VBox(15);
        controls.setPadding(new Insets(10));
        controls.getChildren().addAll(table);

        Scene scene = new Scene(controls, 550, 550);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Get all of the inventory
    public static ObservableList<Inventory> getInventory() {
        ObservableList<Inventory> inventory = FXCollections.observableArrayList();

        for (int i = 0; i < LibraryDatabase.getInventoryList().size(); i++) {
            inventory.add(LibraryDatabase.getInventoryList().get(i));
        }

        return inventory;
    }
}
