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


    @Override
    public void start(Stage primaryStage) {

        /*
        This is a default inventory that comes with this program.
        - It serves for testing the program
        - It is a part of the grading criteria to have some data in the Library Database
         */

        InternalLibrary.startDatabase();

        try {
            // General control buttons
            Button library = new Button("View...");
            Button addItem = new Button("Add Item");
            Button importLibrary = new Button("Import");
            Button exportLibrary = new Button("Export");
            Button about = new Button("About");
            Button exit = new Button("Exit");

            // Inventory display control buttons
            Button delete = new Button("Delete");

            // Set button size
            library.setPrefSize(90, 30);
            addItem.setPrefSize(90, 30);
            importLibrary.setPrefSize(90, 30);
            exportLibrary.setPrefSize(90, 30);
            about.setPrefSize(90, 30);
            exit.setPrefSize(90, 30);

            // Inventory buttons should maybe be different size
            delete.setPrefSize(90, 30);

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

            // Control button commands

            // ##
            delete.setOnAction(event -> {
                Inventory selectedItem = table.getSelectionModel().getSelectedItem();
                table.getItems().remove(selectedItem);

                LibraryDatabase.getInventoryList().remove(selectedItem);
                LibraryDatabase.getNovelList().remove(selectedItem);
                LibraryDatabase.getMovieList().remove(selectedItem);

                //??????????
            });


            // Pressing library button shows items in the library in TableView
            library.setOnAction(e -> AlertBox.contentSelect());

            // Adds a new item to the inventory
            addItem.setOnAction(e -> AlertBox.contentAdd());

            // Imports library from a .txt file
            importLibrary.setOnAction(e -> AlertBox.generalNotification("Library Imported", "Library has been imported into the program"));

            // Exports library to a .txt file
            exportLibrary.setOnAction(e -> {
                try {
                    // Button press creates new window where user inputs file name. File name is sent to supportBox to be printed as export file name
                    SupportBox.printInfo(AlertBox.importExportBox("Export Library", "Enter File Name: "));
                } catch (Exception e1) {

                    System.out.println(e1.getMessage());
                    AlertBox.programFatalError(e1.toString());
                }
            });

            // Shows credits
            about.setOnAction(e -> AlertBox.credits());

            // Safely exits the program
            exit.setOnAction(e -> Platform.exit());

            // VBox for holding Table and control buttons.
            VBox tableControls = new VBox(15);
            tableControls.setPadding(new Insets(10));
            tableControls.getChildren().addAll(table, delete);

            // VBox for holding button controls
            VBox masterControls = new VBox(15);
            masterControls.setPadding(new Insets(10));
            masterControls.getChildren().addAll(library, addItem, importLibrary, exportLibrary, about, exit);

            // Main window will be made out of BorderPane
            BorderPane mainLayout = new BorderPane();
            mainLayout.setPadding(new Insets(10));
            mainLayout.setLeft(masterControls);
            mainLayout.setCenter(tableControls);

            // Add layout to the scene
            Scene mainScene = new Scene(mainLayout, 600, 520);

            // Add scene to the stage
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("TRIGLAV\u2122 Library Database");

            // Show alert box when closing the program
            primaryStage.setOnCloseRequest(event -> {
                event.consume();
                SupportBox.closingProgram();
            });

            // Show
            primaryStage.show();

        } catch (Exception e) {
            AlertBox.programFatalError(e.toString());
            System.out.println(e.toString());
        }

    }

    //Get all of the inventory
    private ObservableList<Inventory> getInventory() {
        ObservableList<Inventory> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getInventoryList());

        return inventory;
    }
}