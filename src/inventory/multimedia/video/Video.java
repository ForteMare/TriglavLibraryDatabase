package inventory.multimedia.video;

import inventory.LibraryDatabase;
import inventory.multimedia.Multimedia;
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

public class Video extends Multimedia {
    private String director;
    private String screenwriter;

    public Video() {
        this("Unknown Director", "Unknown Screenwriter");
        setInternalID(4);
        setType(getClass().getSimpleName());
    }

    public Video(String director, String screenwriter) {
        this.director = director;
        this.screenwriter = screenwriter;
        setInternalID(4);
        setType(getClass().getSimpleName());
    }

    public Video(String title, String publisher, String subDefine, String director, String screenwriter) {
        super(title, publisher, subDefine);
        this.director = director;
        this.screenwriter = screenwriter;
        setInternalID(4);
        setType(getClass().getSimpleName());
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addVideo(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Video{" +
                "director='" + director + '\'' +
                ", screenwriter='" + screenwriter + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Director: ")
                .append(getDirector())
                .append("\r\n")
                .append("Screenwriter: ")
                .append(getScreenwriter())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getDirector())
                .append("\r\n")
                .append(getScreenwriter())
                .append("\r\n");

        return sb;
    }

    public static void displayVideoInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Video Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Video, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Video, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Video, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Publisher column
        TableColumn<Video, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(120);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        //SubDef column
        TableColumn<Video, String> subDefineColumn = new TableColumn<>("Genre");
        subDefineColumn.setMinWidth(120);
        subDefineColumn.setCellValueFactory(new PropertyValueFactory<>("subDefine"));

        //Director column
        TableColumn<Video, String> directorColumn = new TableColumn<>("Director");
        directorColumn.setMinWidth(120);
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));

        //Screenwriter column
        TableColumn<Video, String> screenWriterColumn = new TableColumn<>("Screenwriter");
        screenWriterColumn.setMinWidth(120);
        screenWriterColumn.setCellValueFactory(new PropertyValueFactory<>("screenwriter"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Video> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, publisherColumn, directorColumn, screenWriterColumn);

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
    private static ObservableList<Video> getInventory() {
        ObservableList<Video> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getVideoList());

        return inventory;
    }
}
