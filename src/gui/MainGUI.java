/*
Triglav Library Database has two main classes.

>> For interacting with the program through JavaFX GUI, this is the main class.
>> For interacting with the program through IDE IO, Main is the main class
 */


package gui;

import inventory.InternalLibrary;
import inventory.Inventory;
import inventory.LibraryDatabase;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application {
    public static void main(String[] args) {

        // Delete this
        InternalLibrary.startDatabase();

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Add relevant buttons
            Button library = new Button("Library");
            Button addItem = new Button("Add Item");
            Button importLibrary = new Button("Import");
            Button exportLibrary = new Button("Export");
            Button about = new Button("About");
            Button exit = new Button("Exit");


            // Set button size
            library.setMinSize(90, 30);
            library.setMaxSize(30, 10);

            addItem.setMinSize(90, 30);
            addItem.setMaxSize(30, 10);

            importLibrary.setMinSize(90, 30);
            importLibrary.setMaxSize(30, 10);

            exportLibrary.setMinSize(90, 30);
            exportLibrary.setMaxSize(30, 10);

            about.setMinSize(90, 30);
            about.setMaxSize(30, 10);

            exit.setMinSize(90, 30);
            exit.setMaxSize(90, 30);

            // Control button commands

            // Pressing library button shows items in the library in TableView
            library.setOnAction(e -> AlertBox.showContent());

            // Adds a new item to the inventory
            addItem.setOnAction(e -> AlertBox.addToLibrary());

            // Imports library from a .txt file
            importLibrary.setOnAction(e -> AlertBox.generalNotification("Library Imported", "Library has been imported into the program"));

            // Exports library to a .txt file
            exportLibrary.setOnAction(e -> {
                try {
                    // Button press creates new window where user inputs file name. File name is sent to supportBox to be printed as export file name
                    PeripheralBox.printInfo(AlertBox.importExportBox("Export Library", "Enter File Name: "));
                } catch (Exception e1) {

                    System.out.println(e1.getMessage());
                    AlertBox.programError(e1.toString());
                }
            });

            // Shows credits
            about.setOnAction(e -> AlertBox.credits());

            // Safely exits the program
            exit.setOnAction(e -> Platform.exit());

            // Adding Table View of Inventory to the main screen

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

            TableView<Inventory> table = new TableView<>();
            table.setItems(getInventory());
            table.getColumns().addAll(statusColumn, typeColumn, titleColumn);

            // VBox for holding button controls
            VBox controls = new VBox(15);
            controls.setPadding(new Insets(10));
            controls.getChildren().addAll(library, addItem, importLibrary, exportLibrary, about, exit);

            // Main window will be made out of BorderPane
            BorderPane mainLayout = new BorderPane();
            mainLayout.setPadding(new Insets(10));
            mainLayout.setLeft(controls);
            mainLayout.setCenter(table);

            // Add layout to the scene
            Scene mainScene = new Scene(mainLayout, 550, 400);

            // Add scene to the stage
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("TRIGLAV\u2122 Library Database");

            // Show alert box when closing the program
            primaryStage.setOnCloseRequest(event -> {
                event.consume();
                PeripheralBox.closingProgram();
            });

            // Show
            primaryStage.show();

        } catch (Exception e) {
            AlertBox.programError(e.toString());
            System.out.println(e.toString());
        }

    }

    //Get all of the inventory
    public ObservableList<Inventory> getInventory() {
        ObservableList<Inventory> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getInventoryList());

        return inventory;
    }
}