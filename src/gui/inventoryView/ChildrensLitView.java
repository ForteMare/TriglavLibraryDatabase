package gui.inventoryView;

import inventory.LibraryDatabase;
import inventory.print.book.ChildrensLiterature;
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

public class ChildrensLitView {

    public static void viewInventory() {

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
        TableColumn<ChildrensLiterature, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<ChildrensLiterature, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<ChildrensLiterature, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Author column
        TableColumn<ChildrensLiterature, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(100);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<ChildrensLiterature, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(100);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Hard cover column
        TableColumn<ChildrensLiterature, Boolean> hardCoverColumn = new TableColumn<>("Hard Cover");
        hardCoverColumn.setMinWidth(100);
        hardCoverColumn.setCellValueFactory(new PropertyValueFactory<>("hardCover"));

        //Year published column
        TableColumn<ChildrensLiterature, Integer> yearPublishedColumn = new TableColumn<>("Year Published");
        yearPublishedColumn.setMinWidth(100);
        yearPublishedColumn.setCellValueFactory(new PropertyValueFactory<>("yearPublished"));

        //DDC Location column
        TableColumn<ChildrensLiterature, String> ddcLocationColumn = new TableColumn<>("DDC Number");
        ddcLocationColumn.setMinWidth(100);
        ddcLocationColumn.setCellValueFactory(new PropertyValueFactory<>("ddcLocation"));

        //Illustrations column
        TableColumn<ChildrensLiterature, Boolean> illustrationsColumn = new TableColumn<>("Contains Illustrations");
        illustrationsColumn.setMinWidth(100);
        illustrationsColumn.setCellValueFactory(new PropertyValueFactory<>("illustration"));

        //Interactive column
        TableColumn<ChildrensLiterature, Boolean> interactiveColumn = new TableColumn<>("Interactive");
        interactiveColumn.setMinWidth(100);
        interactiveColumn.setCellValueFactory(new PropertyValueFactory<>("interactive"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<ChildrensLiterature> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, hardCoverColumn,
                yearPublishedColumn, illustrationsColumn, interactiveColumn);

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
    public static ObservableList<ChildrensLiterature> getInventory() {
        ObservableList<ChildrensLiterature> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getChildrenLitList());

        return inventory;
    }
}
