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

public class Comic extends Periodical {
    private boolean manga;
    private boolean graphicNovel;

    public Comic() {
        this(false, false);
        setInternalID(17);
        setType(getClass().getSimpleName());
    }

    public Comic(boolean manga, boolean graphicNovel) {
        this.manga = manga;
        this.graphicNovel = graphicNovel;
        setInternalID(17);
        setType(getClass().getSimpleName());
    }

    public Comic(String title, String author, String genre, String publicationFrequency, boolean manga, boolean graphicNovel) {
        super(title, author, genre, publicationFrequency);
        this.manga = manga;
        this.graphicNovel = graphicNovel;
        setInternalID(17);
        setType(getClass().getSimpleName());
    }

    public boolean isManga() {
        return manga;
    }

    public void setManga(boolean manga) {
        this.manga = manga;
    }

    public boolean isGraphicNovel() {
        return graphicNovel;
    }

    public void setGraphicNovel(boolean graphicNovel) {
        this.graphicNovel = graphicNovel;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addComics(this);
        LibraryDatabase.addPeriodical(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Comic{" +
                "manga=" + manga +
                ", graphicNovel=" + graphicNovel +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Manga: ")
                .append(isManga())
                .append("\r\n")
                .append("Graphic novel: ")
                .append(isGraphicNovel())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isManga())
                .append("\r\n")
                .append(isGraphicNovel())
                .append("\r\n");

        return sb;
    }

    public static void displayComicInventory() {

        // Set up the primary stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Comics Inventory");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate button
        Button close = new Button("Close");

        // Set button size
        close.setMinSize(90, 30);
        close.setMaxSize(30, 10);

        //Title column
        TableColumn<Comic, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(210);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //Type column
        TableColumn<Comic, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(120);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //Status column
        TableColumn<Comic, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setMinWidth(120);
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        //Author column
        TableColumn<Comic, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(120);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        //SubType column
        TableColumn<Comic, String> subTypeColumn = new TableColumn<>("Genre");
        subTypeColumn.setMinWidth(120);
        subTypeColumn.setCellValueFactory(new PropertyValueFactory<>("subType"));

        //Publication column
        TableColumn<Comic, String> publicationColumn = new TableColumn<>("Publication Frequency");
        publicationColumn.setMinWidth(120);
        publicationColumn.setCellValueFactory(new PropertyValueFactory<>("publicationFrequency"));

        //Manga column
        TableColumn<Comic, Boolean> mangaColumn = new TableColumn<>("Manga");
        mangaColumn.setMinWidth(120);
        mangaColumn.setCellValueFactory(new PropertyValueFactory<>("manga"));

        //Graphic novel column
        TableColumn<Comic, String> graphicNovelColumn = new TableColumn<>("Graphic Novel");
        graphicNovelColumn.setMinWidth(120);
        graphicNovelColumn.setCellValueFactory(new PropertyValueFactory<>("graphicNovel"));

        // Button action
        close.setOnAction(event -> primaryStage.close());

        TableView<Comic> table = new TableView<>();
        table.setItems(getInventory());
        table.getColumns().addAll(statusColumn, typeColumn, titleColumn, authorColumn, subTypeColumn, publicationColumn,
                mangaColumn, graphicNovelColumn);

        // VBox for holding button controls
        VBox controls = new VBox(15);
        controls.setPadding(new Insets(10));
        controls.getChildren().addAll(table, close);

        // Setting up the scene
        Scene scene = new Scene(controls, 950, 450);

        // Setting up the stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    //Get all of the inventory
    private static ObservableList<Comic> getInventory() {
        ObservableList<Comic> inventory = FXCollections.observableArrayList();

        inventory.addAll(LibraryDatabase.getComicList());

        return inventory;
    }
}
