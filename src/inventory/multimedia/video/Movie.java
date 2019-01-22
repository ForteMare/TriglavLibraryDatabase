package inventory.multimedia.video;

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

public class Movie extends Video {
    private double ratingIMDB;
    private boolean hollywoodProduction;

    public Movie() {
        this(10.0, false);

        setInternalID(8);
        setType(getClass().getSimpleName());
    }

    public Movie(double ratingIMDB, boolean hollywoodProduction) {
        this.ratingIMDB = ratingIMDB;
        this.hollywoodProduction = hollywoodProduction;

        setInternalID(8);
        setType(getClass().getSimpleName());
    }

    public Movie(String title, String publisher, String subDefine, String director, String screenwriter, double ratingIMDB, boolean hollywoodProduction) {
        super(title, publisher, subDefine, director, screenwriter);
        this.ratingIMDB = ratingIMDB;
        this.hollywoodProduction = hollywoodProduction;

        setInternalID(8);
        setType(getClass().getSimpleName());
    }

    public double getRatingIMDB() {
        return ratingIMDB;
    }

    public void setRatingIMDB(double ratingIMDB) {
        this.ratingIMDB = ratingIMDB;
    }

    public boolean isHollywoodProduction() {
        return hollywoodProduction;
    }

    public void setHollywoodProduction(boolean hollywoodProduction) {
        this.hollywoodProduction = hollywoodProduction;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addMovie(this);
        LibraryDatabase.addVideo(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ratingIMDB=" + ratingIMDB +
                ", hollywoodProduction=" + hollywoodProduction +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("IMDb Rating: ")
                .append(getRatingIMDB())
                .append("\r\n")
                .append("Hollywood Production: ")
                .append(isHollywoodProduction())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getRatingIMDB())
                .append("\r\n")
                .append(isHollywoodProduction())
                .append("\r\n");

        return sb;
    }

    /*
    Every inventory subclass has FX methods. This was originally held in a class of its own,
    to reduce space and confusion, now classes are more self-contained.
    This method contains code *only* for displaying the window that contains a table with class content.
     */

    public static void displayMovieInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Movie Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Movie, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Movie, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Movie, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Publisher column
        TableColumn<Movie, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(120);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        //SubDef column
        TableColumn<Movie, String> subDefineColumn = new TableColumn<>("Genre");
        subDefineColumn.setMinWidth(120);
        subDefineColumn.setCellValueFactory(new PropertyValueFactory<>("subDefine"));

        //Director column
        TableColumn<Movie, String> directorColumn = new TableColumn<>("Director");
        directorColumn.setMinWidth(120);
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));

        //Screenwriter column
        TableColumn<Movie, String> screenWriterColumn = new TableColumn<>("Screenwriter");
        screenWriterColumn.setMinWidth(120);
        screenWriterColumn.setCellValueFactory(new PropertyValueFactory<>("screenwriter"));

        //Rating column
        TableColumn<Movie, Double> ratingColumn = new TableColumn<>("IMDb Rating");
        ratingColumn.setMinWidth(120);
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("ratingIMDB"));

        //Hollywood production column
        TableColumn<Movie, String> hollywoodColumn = new TableColumn<>("Hollywood Production");
        hollywoodColumn.setMinWidth(120);
        hollywoodColumn.setCellValueFactory(new PropertyValueFactory<>("hollywoodProduction"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Movie> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, publisherColumn, directorColumn, screenWriterColumn,
                ratingColumn, hollywoodColumn);

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
    private static ObservableList<Movie> getInventory() {
        ObservableList<Movie> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getMovieList());

        return inventory;
    }
}
