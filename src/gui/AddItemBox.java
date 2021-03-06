/*

 */

package gui;

import inventory.multimedia.audio.Audio;
import inventory.multimedia.audio.Audiobook;
import inventory.multimedia.audio.Music;
import inventory.multimedia.audio.Podcast;
import inventory.multimedia.video.ArchiveFootage;
import inventory.multimedia.video.Documentary;
import inventory.multimedia.video.Movie;
import inventory.multimedia.video.Video;
import inventory.print.book.Book;
import inventory.print.book.ChildrensLiterature;
import inventory.print.book.Novel;
import inventory.print.book.TouristGuide;
import inventory.print.periodical.Comic;
import inventory.print.periodical.Magazine;
import inventory.print.periodical.Newspaper;
import inventory.print.periodical.Periodical;
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

        accept.setOnAction(event -> {

            // Novel information input

            try {

                /* To prevent program from entering information even if it encounters exception, variables most prone
            to getting incorrect input are put first.
             */
                int userYear = Integer.parseInt(yearInput.getText());

                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();
                boolean userHardCover = hardCoverInput.isSelected();

                String userDDC = ddcInput.getText();

                String userLanguage = languageInput.getValue();

                Novel novel = new Novel(userTitle, userAuthor, userSubtype, userHardCover, userYear, userDDC, userLanguage);
                novel.setAvailability(userAvailability);
                novel.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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

        // Checkbox for whether it contains maps
        CheckBox mapInput = new CheckBox("Contains maps");

        // Adding button actions

        accept.setOnAction(event -> {

            // Tourist guide information
            try {

                /*
            To prevent program from entering information even if it encounters exception, variables most prone
            to getting incorrect input are put first.
             */
                int userYear = Integer.parseInt(yearInput.getText());

                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();
                boolean userHardCover = hardCoverInput.isSelected();

                String userDDC = ddcInput.getText();

                String userRegion = regionInput.getValue();
                boolean userMaps = mapInput.isSelected();

                TouristGuide touristGuide = new TouristGuide(userTitle, userAuthor, userSubtype, userHardCover, userYear, userDDC, userRegion, userMaps);
                touristGuide.setAvailability(userAvailability);
                touristGuide.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(hardCoverInput, 1, 7);
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

        // Checkbox for hard-cover
        CheckBox interactiveInput = new CheckBox("Interactive book");

        accept.setOnAction(event -> {

            // Children Lit information
            try {

                /* To prevent program from entering information even if it encounters exception, variables most prone
            to getting incorrect input are put first.
             */

                int userYear = Integer.parseInt(yearInput.getText());

                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();
                boolean userHardCover = hardCoverInput.isSelected();

                String userDDC = ddcInput.getText();

                boolean userIllustration = illustrationInput.isSelected();
                boolean userInteractive = interactiveInput.isSelected();

                ChildrensLiterature childrensLiterature = new ChildrensLiterature(userTitle, userAuthor, userSubtype,
                        userHardCover, userYear, userDDC, userIllustration, userInteractive);
                childrensLiterature.setAvailability(userAvailability);
                childrensLiterature.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(hardCoverInput, 1, 6);
        layout.add(illustrationInput, 1, 7);
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

        // Adding button actions
        accept.setOnAction(event -> {

            // Newspaper information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();

                String userPublication = publicationInput.getValue();

                boolean userInfoQuality;

                userInfoQuality = informationTypeInput.getValue().equals("Investigative Journalism");

                Newspaper newspaper = new Newspaper(userTitle, userAuthor, userSubtype, userPublication, userInfoQuality);
                newspaper.setAvailability(userAvailability);
                newspaper.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        scene = new Scene(layout, 550, 510);

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
        CheckBox qualityPrintInput = new CheckBox("Quality print: ");

        // Check box for quality print
        CheckBox containsNudityInput = new CheckBox("Contains nudity: ");

        // Adding button actions
        accept.setOnAction(event -> {

            // Magazine information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();

                String userPublication = publicationInput.getValue();

                boolean userQualityPrint = qualityPrintInput.isSelected();
                boolean userContainsNudity = containsNudityInput.isSelected();

                Magazine magazine = new Magazine(userTitle, userAuthor, userSubtype, userPublication, userQualityPrint, userContainsNudity);
                magazine.setAvailability(userAvailability);
                magazine.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(qualityPrintInput, 1, 5);
        layout.add(containsNudityInput, 1, 6);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addComics() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Comic");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

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

        CheckBox graphicNovelInput = new CheckBox("Graphic novel");
        CheckBox mangaInput = new CheckBox("Manga");

        // Adding button actions
        accept.setOnAction(event -> {

            // Comic information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();

                String userPublication = publicationInput.getValue();

                boolean userMangaSelect = mangaInput.isSelected();
                boolean userGraphicNovelSelect = graphicNovelInput.isSelected();

                Comic co1 = new Comic(userTitle, userAuthor, userSubtype, userPublication, userMangaSelect, userGraphicNovelSelect);
                co1.setAvailability(userAvailability);
                co1.addToDatabase();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(graphicNovelInput, 1, 5);
        layout.add(mangaInput, 1, 6);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void addMovie() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Movie");
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
        Label instructionsLabel = new Label("Add a new movie: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Cinema Paradiso");
        Label titleLabel = new Label("Title: ");

        // Choice box for availability
        ChoiceBox<String> availableInput = new ChoiceBox<>();
        availableInput.getItems().addAll("Available", "Reserved", "Unavailable");
        availableInput.setValue("Available");
        availableInput.setMinWidth(190);
        Label availableLabel = new Label("Status: ");

        // Adding fields for Multimedia class

        // Text field for publisher
        TextField publisherInput = new TextField();
        publisherInput.setPromptText("Cristaldi Film");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub definition
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("Action", "Adventure", "Horror", "Crime",
                "Science Fiction", "Epic", "Comedy");
        subDefInput.setValue("Action");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Type: ");

        // Adding Video class fields

        // Text field for year published
        TextField directorInput = new TextField();
        directorInput.setPromptText("Giuseppe Tornatore");
        Label directorLabel = new Label("Director: ");

        // Text field for screenwriter published
        TextField screenWriterInput = new TextField();
        screenWriterInput.setPromptText("Enzo Cannavale");
        Label screenWriterLabel = new Label("Screenwriter: ");

        // Fields from Movie class

        // Text field for IMDb rating
        TextField ratingInput = new TextField();
        ratingInput.setPromptText("7.4");
        Label ratingLabel = new Label("IMDb rating:");

        // Input whether movie is a Hollywood production
        CheckBox hollywoodInput = new CheckBox();
        Label hollywoodLabel = new Label("Hollywood production: ");

        // Adding button actions
        accept.setOnAction(event -> {

            // Movie information
            try {
                /*
                To prevent program from adding object and throwing exception, the exception-prone variable is set first.
                In case of error, immediately goes to catch.
                 */
                double userIMDBRating = Double.parseDouble(ratingInput.getText());

                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userDirector = directorInput.getText();
                String userScreenwriter = screenWriterInput.getText();


                boolean userHollywood = hollywoodInput.isSelected();

                Movie mov1 = new Movie(userTitle, userPublisher, userSubDef, userDirector, userScreenwriter, userIMDBRating, userHollywood);
                mov1.setAvailability(userAvailability);
                mov1.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(ratingLabel, 1, 3);
        layout.add(ratingInput, 1, 4);
        layout.add(availableLabel, 1, 5);
        layout.add(availableInput, 1, 6);
        layout.add(hollywoodLabel, 1, 7);
        layout.add(hollywoodInput, 1, 8);


        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addDocumentary() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Documentary");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Instructions
        Label instructionsLabel = new Label("Add a new documentary: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Planet Earth");
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
        publisherInput.setPromptText("BBC");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub definition
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("History", "Science", "Nature", "Space", "Culture");
        subDefInput.setValue("History");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Type: ");

        // Adding Video class fields

        // Text field for year published
        TextField directorInput = new TextField();
        directorInput.setPromptText("Justin Englishman");
        Label directorLabel = new Label("Director: ");

        // Text field for year published
        TextField screenWriterInput = new TextField();
        screenWriterInput.setPromptText("Todd Smith");
        Label screenWriterLabel = new Label("Screenwriter: ");

        // Documentary class variables

        // Set up option for adding color
        ChoiceBox<String> colorInput = new ChoiceBox<>();
        colorInput.getItems().addAll("Black & White", "Multicolor");
        colorInput.setValue("Multicolor");
        colorInput.setMinWidth(190);
        Label colorLabel = new Label("Documentary color: ");

        // Adding button actions
        accept.setOnAction(event -> {

            // Video information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userDirector = directorInput.getText();
                String userScreenwriter = screenWriterInput.getText();

                boolean userColor;

                userColor = colorInput.getValue().equals("Multicolor");

                Documentary doc1 = new Documentary(userTitle, userPublisher, userSubDef, userDirector, userScreenwriter, userColor);
                doc1.setAvailability(userAvailability);
                doc1.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(colorLabel, 1, 5);
        layout.add(colorInput, 1, 6);
        layout.add(availableLabel, 1, 7);
        layout.add(availableInput, 1, 8);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addArchiveFootage() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Archive Footage");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Instructions
        Label instructionsLabel = new Label("Add a new video: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Dolenjska 1951 - 1967");
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
        publisherInput.setPromptText("Yugofilm");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("Primary Source", "Secondary Source", "Recreated Event");
        subDefInput.setValue("Primary Source");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Historical significance: ");

        // Adding Video class fields

        // Text field for director
        TextField directorInput = new TextField();
        directorInput.setPromptText("Miroslav Sturmberger");
        Label directorLabel = new Label("Director: ");

        // Text field for year published
        TextField screenWriterInput = new TextField();
        screenWriterInput.setPromptText("Petar Zupancic");
        Label screenWriterLabel = new Label("Screenwriter: ");

        // Adding variables specific to Archive Footage class

        // What region the footage originates from
        ChoiceBox<String> regionInput = new ChoiceBox<>();
        regionInput.getItems().addAll("Footage related to Novo mesto", "Slovenian Archive");
        regionInput.setValue("Slovenian Archive");
        regionInput.setMinWidth(190);
        Label regionLabel = new Label("Footage content: ");

        // Check box for propaganda material
        CheckBox propagandaInput = new CheckBox("Propaganda material");

        // Check box for regional history
        CheckBox regionalHistoryInput = new CheckBox("Regional history");

        // Adding button actions
        accept.setOnAction(event -> {

            // Archive footage information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userDirector = directorInput.getText();
                String userScreenwriter = screenWriterInput.getText();

                boolean userRegionalHistory = regionalHistoryInput.isSelected();
                boolean userPropaganda = propagandaInput.isSelected();

                ArchiveFootage archive = new ArchiveFootage(userTitle, userPublisher, userSubDef, userDirector, userScreenwriter, userRegionalHistory, userPropaganda);
                archive.setAvailability(userAvailability);
                archive.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(regionLabel, 0, 7);
        layout.add(regionInput, 0, 8);

        //Second column
        layout.add(publisherLabel, 1, 1);
        layout.add(publisherInput, 1, 2);
        layout.add(screenWriterLabel, 1, 3);
        layout.add(screenWriterInput, 1, 4);
        layout.add(availableLabel, 1, 5);
        layout.add(availableInput, 1, 6);
        layout.add(propagandaInput, 1, 7);
        layout.add(regionalHistoryInput, 1, 8);


        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addMusic() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Music");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Instructions
        Label instructionsLabel = new Label("Add new music: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Tumbling Dice");
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
        publisherInput.setPromptText("LA Recordings");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub type
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("Classical", "Rock 'n' Roll", "Blues", "Jazz", "Soul", "Metal", "Ballad");
        subDefInput.setValue("Classical");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Genre: ");

        // Adding input for Audio class

        // Input sub type (previously called genre)
        ChoiceBox<String> fileFormatInput = new ChoiceBox<>();
        fileFormatInput.getItems().addAll("WAV", "MP3", "WMA", "AAC", "FLAC");
        fileFormatInput.setValue("MP3");
        fileFormatInput.setMinWidth(190);
        Label fileFormatLabel = new Label("File format: ");

        // Adding items specific to Music class

        // Adding artist
        TextField artistInput = new TextField();
        artistInput.setPromptText("The Rolling Stones");
        Label artistLabel = new Label("Artist / Band: ");

        // Adding album
        TextField albumInput = new TextField();
        albumInput.setPromptText("Sticky Fingers");
        Label albumLabel = new Label("Album: ");

        // Adding button actions
        accept.setOnAction(event -> {

            // Music information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userFormat = fileFormatInput.getValue();

                String userArtist = artistInput.getText();
                String userAlbum = albumInput.getText();

                Music music = new Music(userTitle, userPublisher, userSubDef, userFormat, userArtist, userAlbum);
                music.setAvailability(userAvailability);
                music.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(artistLabel, 0, 3);
        layout.add(artistInput, 0, 4);
        layout.add(albumLabel, 0, 5);
        layout.add(albumInput, 0, 6);

        //Second column
        layout.add(publisherLabel, 1, 1);
        layout.add(publisherInput, 1, 2);
        layout.add(subDefLabel, 1, 3);
        layout.add(subDefInput, 1, 4);
        layout.add(availableLabel, 1, 5);
        layout.add(availableInput, 1, 6);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addAudioBook() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Audiobook");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Instructions
        Label instructionsLabel = new Label("Add a new audiobook: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("The Gods Themselves");
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
        publisherInput.setPromptText("The Asimov Foundation");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("Horror", "Romance", "Action", "Mystery", "Comedy");
        subDefInput.setValue("Mystery");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Type: ");

        // Adding input for Audio class

        // Input sub type (previously called genre)
        ChoiceBox<String> fileFormatInput = new ChoiceBox<>();
        fileFormatInput.getItems().addAll("WAV", "MP3", "WMA", "AAC", "FLAC");
        fileFormatInput.setValue("MP3");
        fileFormatInput.setMinWidth(190);
        Label fileFormatLabel = new Label("File format: ");

        // Text field for length of the audiobook
        TextField lengthInput = new TextField();
        lengthInput.setPromptText("27.15");
        Label lengthLabel = new Label("Length in minutes: ");

        // Text field for narrator
        TextField narratorInput = new TextField();
        narratorInput.setPromptText("Stephen Fry");
        Label narratorLabel = new Label("Narrator: ");

        // Adding button actions
        accept.setOnAction(event -> {

            // Audio book  information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userFormat = fileFormatInput.getValue();

                double userLength = Double.parseDouble(lengthInput.getText());
                String userNarrator = narratorInput.getText();

                Audiobook audiobook = new Audiobook(userTitle, userPublisher, userSubDef, userFormat, userLength, userNarrator);
                audiobook.setAvailability(userAvailability);
                audiobook.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(publisherLabel, 0, 3);
        layout.add(publisherInput, 0, 4);
        layout.add(subDefLabel, 0, 5);
        layout.add(subDefInput, 0, 6);

        //Second column
        layout.add(fileFormatLabel, 1, 1);
        layout.add(fileFormatInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);
        layout.add(lengthLabel, 1, 5);
        layout.add(lengthInput, 1, 6);
        layout.add(narratorLabel, 1, 7);
        layout.add(narratorInput, 1, 8);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addPodcast() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Podcast");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Instructions
        Label instructionsLabel = new Label("Add a new podcast: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Escape Pod");
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
        publisherInput.setPromptText("Kaiju Entertainment");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("Improv", "News", "Society", "Blogging", "Interview", "Talk Show", "Radio Drama");
        subDefInput.setValue("Talk Show");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Type: ");

        // Adding input for Audio class

        // Input sub type (previously called genre)
        ChoiceBox<String> fileFormatInput = new ChoiceBox<>();
        fileFormatInput.getItems().addAll("WAV", "MP3", "WMA", "AAC", "FLAC");
        fileFormatInput.setValue("MP3");
        fileFormatInput.setMinWidth(190);
        Label fileFormatLabel = new Label("File format: ");

        // Adding items specific for Podcast class
        CheckBox offlineInput = new CheckBox("Available Offline");

        // Adding check box for popularity
        CheckBox featuredInput = new CheckBox("Popular / Featured");

        // Adding button actions
        accept.setOnAction(event -> {

            // Podcast information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userFormat = fileFormatInput.getValue();

                boolean userOffline = offlineInput.isSelected();
                boolean userFeatured = featuredInput.isSelected();

                Podcast podcast = new Podcast(userTitle, userPublisher, userSubDef, userFormat, userOffline, userFeatured);
                podcast.setAvailability(userAvailability);
                podcast.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());


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
        layout.add(publisherLabel, 0, 3);
        layout.add(publisherInput, 0, 4);
        layout.add(subDefLabel, 0, 5);
        layout.add(subDefInput, 0, 6);

        //Second column
        layout.add(fileFormatLabel, 1, 1);
        layout.add(fileFormatInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);
        layout.add(featuredInput, 1, 5);
        layout.add(offlineInput, 1, 6);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

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

        // Adding button actions

        accept.setOnAction(event -> {

            // Book information
            try {
                /*
                Parse variable goes first in case error is encoutnered, it goes straight to catch.
                 */

                int userYear = Integer.parseInt(yearInput.getText());

                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();
                boolean userHardCover = hardCoverInput.isSelected();

                String userDDC = ddcInput.getText();

                Book b1 = new Book(userTitle, userAuthor, userSubtype, userHardCover, userYear, userDDC);
                b1.setAvailability(userAvailability);

                b1.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });
        reject.setOnAction(event -> primaryStage.close());

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

        // Adding button actions
        accept.setOnAction(event -> {

            // Children Lit information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userAuthor = authorInput.getText();
                String userSubtype = subTypeInput.getValue();

                String userPublication = publicationInput.getValue();

                Periodical pe1 = new Periodical(userTitle, userAuthor, userSubtype, userPublication);
                pe1.setAvailability(userAvailability);
                pe1.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        scene = new Scene(layout, 550, 510);

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

        // Adding button actions
        accept.setOnAction(event -> {

            // Video information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userDirector = directorInput.getText();
                String userScreenwriter = screenWriterInput.getText();

                Video video1 = new Video(userTitle, userPublisher, userSubDef, userDirector, userScreenwriter);
                video1.setAvailability(userAvailability);
                video1.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void addAudio() {

        // Set the stage
        primaryStage = new Stage();
        primaryStage.setTitle("Audio");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Initiate Accept button
        accept = new Button("Save");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Initiate Reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Instructions
        Label instructionsLabel = new Label("Add a new audio file: ");

        // Adding fields for abstract Inventory class

        // Set title
        TextField titleInput = new TextField();
        titleInput.setPromptText("Triglav National Park Bird Noises");
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
        publisherInput.setPromptText("Birget Production");
        Label publisherLabel = new Label("Publisher: ");

        // Input sub type (previously called genre)
        ChoiceBox<String> subDefInput = new ChoiceBox<>();
        subDefInput.getItems().addAll("Ambient Noise", "Interview", "Court Recording", "ASMR");
        subDefInput.setValue("Ambient Noise");
        subDefInput.setMinWidth(190);
        Label subDefLabel = new Label("Type: ");

        // Adding input for Audio class

        // Input sub type (previously called genre)
        ChoiceBox<String> fileFormatInput = new ChoiceBox<>();
        fileFormatInput.getItems().addAll("WAV", "MP3", "WMA", "AAC", "FLAC");
        fileFormatInput.setValue("MP3");
        fileFormatInput.setMinWidth(190);
        Label fileFormatLabel = new Label("File format: ");

        // Adding button actions
        accept.setOnAction(event -> {

            // Audio information
            try {
                String userAvailability = availableInput.getValue();
                String userTitle = titleInput.getText();
                String userPublisher = publisherInput.getText();
                String userSubDef = subDefInput.getValue();

                String userFormat = fileFormatInput.getValue();

                Audio audio = new Audio(userTitle, userPublisher, userSubDef, userFormat);
                audio.setAvailability(userAvailability);
                audio.addToDatabase();

                primaryStage.close();

            } catch (Exception e) {
                AlertBox.programErrorSoft(e.toString());
            }
        });

        reject.setOnAction(event -> primaryStage.close());

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
        layout.add(publisherLabel, 0, 3);
        layout.add(publisherInput, 0, 4);
        layout.add(subDefLabel, 0, 5);
        layout.add(subDefInput, 0, 6);

        //Second column
        layout.add(fileFormatLabel, 1, 1);
        layout.add(fileFormatInput, 1, 2);
        layout.add(availableLabel, 1, 3);
        layout.add(availableInput, 1, 4);

        // Buttons
        layout.add(accept, 0, 11);
        layout.add(reject, 0, 12);

        // Set up the scene
        scene = new Scene(layout, 550, 510);

        // Activate the primary stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

}

