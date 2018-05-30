/*
This class is fully committed to creating windows for adding content to the library.
 */

package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddItemBox {

    // Basic buttons
    private static Button accept;
    private static Button reject;

    // Layout Grid View is default for this action
    private static GridPane layout;

    // Scene
    private static Scene scene;

    // Stage
    private static Stage primaryStage;

    static void addNovel() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Novel");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a new novel: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("One Hundred Years of Solitude");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Gabriel Garcia Marquez");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Fiction", "Thriller", "Tragedy", "Western", "Science Fiction", "Romance");
        subTypeInput.setValue("Fiction");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Genre: ");

        // Adding fields specific for a book

        // Checkbox for hard-cover
        CheckBox hardCoverInput = new CheckBox();
        Label hardcoverLabel = new Label("Hard-cover: ");

        // Text field for year published
        TextField yearInput = new TextField();
        yearInput.setPromptText("2010");
        Label yearLabel = new Label("Year published: ");

        // Text field for entering DDC
        TextField ddcInput = new TextField();
        ddcInput.setPromptText("SF831.54");
        Label ddcLabel = new Label("Dewey Decimal System Location: ");

        // Adding fields specific for a novel

        // Choice box for language selection
        ChoiceBox<String> languageInput = new ChoiceBox<>();
        languageInput.getItems().addAll("English", "French", "German", "Italian", "Slovenian");
        languageInput.setValue("Slovenian");
        languageInput.setMinWidth(190);
        Label languageLabel = new Label("Language: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(yearLabel, 0, 5);
        layout.add(yearInput, 0, 6);
        layout.add(ddcLabel, 0, 7);
        layout.add(ddcInput, 0, 8);

        //Second column
        layout.add(languageLabel, 1, 1);
        layout.add(languageInput, 1, 2);
        layout.add(subTypeLabel, 1, 3);
        layout.add(subTypeInput, 1, 4);
        layout.add(availableLabel, 1, 5);
        layout.add(availableInput, 1, 6);
        layout.add(hardcoverLabel, 1, 7);
        layout.add(hardCoverInput, 1, 8);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addTouristGuide() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Tourist Guide");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a new tourist guide: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Biking in Southern Slovenia");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Janez Vidmar");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Biking", "Hiking", "Gastronomy", "Sightseeing", "Night Life");
        subTypeInput.setValue("Biking");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Type: ");

        // Adding fields from Book class

        // Checkbox for hard-cover
        CheckBox hardCoverInput = new CheckBox("Hard cover");
//        Label hardcoverLabel = new Label("Hard-cover: ");

        // Text field for year published
        TextField yearInput = new TextField();
        yearInput.setPromptText("2009");
        Label yearLabel = new Label("Year published: ");

        // Text field for entering DDC
        TextField ddcInput = new TextField();
        ddcInput.setPromptText("K889.2");
        Label ddcLabel = new Label("Dewey Decimal System Location: ");

        // Adding fields from Tourist Guide class

        // Input region
        ChoiceBox<String> regionInput = new ChoiceBox<>();
        regionInput.getItems().addAll("Lower Slovenia", "Upper Slovenia", "Europe", "Americas", "Africa", "Asia", "Oceania");
        regionInput.setValue("Lower Slovenia");
        regionInput.setMinWidth(190);
        Label regionLabel = new Label("Region: ");

        // Checkbox for hard-cover
        CheckBox mapInput = new CheckBox("Contains maps");
//        Label mapLabel = new Label("Contains maps: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(yearLabel, 0, 5);
        layout.add(yearInput, 0, 6);
        layout.add(ddcLabel, 0, 7);
        layout.add(ddcInput, 0, 8);

        //Second column
        layout.add(subTypeLabel, 1, 1);
        layout.add(subTypeInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);
        layout.add(regionLabel, 1, 5);
        layout.add(regionInput, 1, 6);
//        layout.add(hardcoverLabel, 1, 7);
        layout.add(hardCoverInput, 1, 7);
//        layout.add(mapLabel, 1, 9);
        layout.add(mapInput, 1, 8);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addChildrensLit() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Children's Literature");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a new book for children: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Where The Wild Things Are");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Maurice Sendak");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Rhythmic Book", "Folklore", "Fairytale", "Concept Book", "Picture Book");
        subTypeInput.setValue("Folklore");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Genre: ");

        // Fields specific for a book

        // Checkbox for hard-cover
        CheckBox hardCoverInput = new CheckBox("Hard-cover");
        Label hardcoverLabel = new Label("Hard-cover: ");

        // Text field for year published
        TextField yearInput = new TextField();
        yearInput.setPromptText("1991");
        Label yearLabel = new Label("Year published: ");

        // Text field for entering DDC
        TextField ddcInput = new TextField();
        ddcInput.setPromptText("B277.3");
        Label ddcLabel = new Label("Dewey Decimal System Location: ");

        // Fields specific for children's books

        // Checkbox for hard-cover
        CheckBox illustrationInput = new CheckBox("For illustration");
        Label illustrationLabel = new Label("For illustration: ");

        // Checkbox for hard-cover
        CheckBox interactiveInput = new CheckBox("Interactive book");
        Label interactiveLabel = new Label("Interactive book: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(yearLabel, 0, 5);
        layout.add(yearInput, 0, 6);
        layout.add(ddcLabel, 0, 7);
        layout.add(ddcInput, 0, 8);

        //Second column
        layout.add(subTypeLabel, 1, 1);
        layout.add(subTypeInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);
//        layout.add(hardcoverLabel, 1, 5);
        layout.add(hardCoverInput, 1, 6);
//        layout.add(illustrationLabel, 1, 7);
        layout.add(illustrationInput, 1, 7);
//        layout.add(interactiveLabel, 1, 9);
        layout.add(interactiveInput, 1, 8);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addNewspaper() {


        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Newspaper");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a newspaper: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("The Intercept");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Glenn Greenwald");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Broadsheet", "Niche", "Shopper Papers", "Mailed");
        subTypeInput.setValue("Broadsheet");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Type: ");

        // Adding items from Periodical class

        // Adding publication frequency
        ChoiceBox<String> publicationInput = new ChoiceBox<>();
        publicationInput.getItems().addAll("Annual", "Bi-annual", "Monthly", "Weekly", "Daily");
        publicationInput.setValue("Annual");
        publicationInput.setMinWidth(190);
        Label publicationLabel = new Label("Publication frequency:");

        // Items specific for the Newspaper class

        // Creating a choice box to covers two variables: tabloid and investigative journalism. This way only one option is available
        ChoiceBox<String> informationTypeInput = new ChoiceBox<>();
        informationTypeInput.getItems().addAll("Investigative Journalism", "Tabloid");
        informationTypeInput.setValue("Tabloid");
        informationTypeInput.setMinWidth(190);
        Label informationTypeLabel = new Label("Quality of information: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(subTypeLabel, 0, 5);
        layout.add(subTypeInput, 0, 6);

        // Second column
        layout.add(publicationLabel, 1, 1);
        layout.add(publicationInput, 1, 2);
        layout.add(informationTypeLabel, 1, 3);
        layout.add(informationTypeInput, 1, 4);
        layout.add(availableLabel, 1, 5);
        layout.add(availableInput, 1, 6);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 440);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addMagazine() {


        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Magazine");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a new magazine: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Popular Science");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Charles Donovan");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Popular Science", "Home Improvement", "Computers", "Video Games", "Beauty", "Hunting & Fishing", "Playboys");
        subTypeInput.setValue("Home Improvement");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Type: ");

        // Adding items from Periodical class

        // Adding publication frequency
        ChoiceBox<String> publicationInput = new ChoiceBox<>();
        publicationInput.getItems().addAll("Annual", "Bi-annual", "Monthly", "Weekly", "Daily");
        publicationInput.setValue("Annual");
        publicationInput.setMinWidth(190);
        Label publicationLabel = new Label("Publication frequency:");

        // Items specific to Magazine class

        // Check box for quality print
        CheckBox qualityPrintInput = new CheckBox();
        Label qualityPrintLabel = new Label("Quality print: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(subTypeLabel, 0, 5);
        layout.add(subTypeInput, 0, 6);

        // Second column
        layout.add(publicationLabel, 1, 1);
        layout.add(publicationInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);
        layout.add(qualityPrintLabel, 1, 5);
        layout.add(qualityPrintInput, 1, 6);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 440);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addComics() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Comics");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a comic: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("V for Vendetta");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Alan Moore");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Superhero", "Alternative", "Esoteric", "Fantasy", "Humor", "Romance");
        subTypeInput.setValue("Superhero");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Type: ");

        // Adding items from Periodical class

        // Adding publication frequency
        ChoiceBox<String> publicationInput = new ChoiceBox<>();
        publicationInput.getItems().addAll("Annual", "Bi-annual", "Monthly", "Weekly", "Daily");
        publicationInput.setValue("Annual");
        publicationInput.setMinWidth(190);
        Label publicationLabel = new Label("Publication frequency:");

        // Items specific to Comics class

        // Checking whether it is manga or a graphic novel
        ChoiceBox<String> graphicNovelInput = new ChoiceBox<>();
        graphicNovelInput.getItems().addAll("Manga", "Graphic Novel");
        graphicNovelInput.setValue("Graphic Novel");
        graphicNovelInput.setMinWidth(190);
        Label graphicNovelLabel = new Label("Graphic novel or manga: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(subTypeLabel, 0, 5);
        layout.add(subTypeInput, 0, 6);

        // Second column
        layout.add(graphicNovelLabel, 1, 1);
        layout.add(graphicNovelInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 440);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addMovie() {

    }

    static void addDocumentary() {

    }

    static void addArchiveFootage() {

    }

    static void addMusic() {

    }

    static void addAudioBook() {

    }

    static void addPodcast() {

    }

    static void addBook() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Book");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a new book: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("First as Tragedy, Then as Farce");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Slavoj Zizek");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Fiction", "Romance", "Commentary", "Review", "Cooking", "History", "Health");
        subTypeInput.setValue("Commentary");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Genre: ");

        // Adding fields specific for a book

        // Checkbox for hard-cover
        CheckBox hardCoverInput = new CheckBox();
        Label hardcoverLabel = new Label("Hard-cover: ");

        // Text field for year published
        TextField yearInput = new TextField();
        yearInput.setPromptText("2009");
        Label yearLabel = new Label("Year published: ");

        // Text field for entering DDC
        TextField ddcInput = new TextField();
        ddcInput.setPromptText("K889.2");
        Label ddcLabel = new Label("Dewey Decimal System Location: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(yearLabel, 0, 5);
        layout.add(yearInput, 0, 6);
        layout.add(ddcLabel, 0, 7);
        layout.add(ddcInput, 0, 8);

        //Second column
        layout.add(subTypeLabel, 1, 1);
        layout.add(subTypeInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);
        layout.add(hardcoverLabel, 1, 5);
        layout.add(hardCoverInput, 1, 6);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addPeriodical() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Periodical");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a new periodical: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Scientific American");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Print class

        // Text field for author
        TextField authorInput = new TextField();
        authorInput.setPromptText("Mike Muller");
        Label authorLabel = new Label("Author: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subTypeInput = new ChoiceBox<>();
        subTypeInput.getItems().addAll("Scientific Journal", "Industry Journal", "Economic Analysis");
        subTypeInput.setValue("Scientific Journal");
        subTypeInput.setMinWidth(190);
        Label subTypeLabel = new Label("Type: ");

        // Adding items from Periodical class

        // Adding publication frequency
        ChoiceBox<String> publicationInput = new ChoiceBox<>();
        publicationInput.getItems().addAll("Annual", "Bi-annual", "Monthly", "Weekly", "Daily");
        publicationInput.setValue("Annual");
        publicationInput.setMinWidth(190);
        Label publicationLabel = new Label("Publication frequency:");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(authorLabel, 0, 3);
        layout.add(authorInput, 0, 4);
        layout.add(subTypeLabel, 0, 5);
        layout.add(subTypeInput, 0, 6);

        // Second column
        layout.add(publicationLabel, 1, 1);
        layout.add(publicationInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 440);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addVideo() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Video");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up button actions
        accept.setOnAction(event -> System.out.println("Not set up yet"));
        reject.setOnAction(event -> primaryStage.close());

        // Instructions
        Label instructionsLabel = new Label("Add a new video: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Bojack Horseman");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Multimedia class

        // Text field for author
        TextField publisherInput = new TextField();
        publisherInput.setPromptText("Netflix");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("Vlog", "Culture", "Interview", "Webinar", "Event", "Tutorial", "Product Review");
        subDefInput.setValue("Vlog");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Type: ");

        // Adding Video class fields

        // Text field for year published
        TextField directorInput = new TextField();
        directorInput.setPromptText("Raphael Bob-Waksberg");
        Label directorLabel = new Label("Director: ");

        // Text field for year published
        TextField screenWriterInput = new TextField();
        screenWriterInput.setPromptText("Sarah Lynn");
        Label screenWriterLabel = new Label("Screenwriter: ");

        // Setting up the Grid Pane
        layout = new GridPane();
        layout.setPadding(new Insets(20, 45, 45, 45));
        layout.setHgap(70);
        layout.setVgap(15);

        // Adding Items to the Grid Pane

        // First column
        layout.add(instructionsLabel, 0, 0);
        layout.add(titleLabel, 0, 1);
        layout.add(titleInput, 0, 2);
        layout.add(directorLabel, 0, 3);
        layout.add(directorInput, 0, 4);
        layout.add(subDefLabel, 0, 5);
        layout.add(subDefInput, 0, 6);

        //Second column
        layout.add(publisherLabel, 1, 1);
        layout.add(publisherInput, 1, 2);
        layout.add(screenWriterLabel, 1, 3);
        layout.add(screenWriterInput, 1, 4);
        layout.add(availableLabel, 1, 5);
        layout.add(availableInput, 1, 6);


        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 430);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addAudio() {

    }

}

