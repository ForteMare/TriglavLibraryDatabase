package gui.inventoryView;

import inventory.LibraryDatabase;
import inventory.multimedia.audio.Music;
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

public class MusicView {

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
        TableColumn<Music, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Music, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(100);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Music, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Publisher column
        TableColumn<Music, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(100);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        //SubDef column
        TableColumn<Music, String> subDefineColumn = new TableColumn<>("Genre");
        subDefineColumn.setMinWidth(100);
        subDefineColumn.setCellValueFactory(new PropertyValueFactory<>("subDefine"));

        //Format column
        TableColumn<Music, String> formatColumn = new TableColumn<>("Format");
        formatColumn.setMinWidth(100);
        formatColumn.setCellValueFactory(new PropertyValueFactory<>("format"));

        //Artist column
        TableColumn<Music, String> artistColumn = new TableColumn<>("Artist");
        artistColumn.setMinWidth(100);
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));

        //Album column
        TableColumn<Music, String> albumColumn = new TableColumn<>("Album");
        albumColumn.setMinWidth(100);
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Music> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, publisherColumn, subDefineColumn, formatColumn,
                artistColumn, albumColumn);

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
    public static ObservableList<Music> getInventory() {
        ObservableList<Music> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getMusicList());

        return inventory;
    }
}
