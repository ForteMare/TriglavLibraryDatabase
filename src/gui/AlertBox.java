/*
SLAVE

MainGUI calls all additional windows from here.

It would be ideal for this class not to call any further FX classes, that all calling commands are done from the main class.
This is not a priority for now, however.
 */

package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

class AlertBox {

    // For retrieving exit options.
    private static boolean answer;

    // For holding information from the text box
    private static String s;

    private static Button accept;
    private static Button reject;

    private static Label messageLabel;

    // Layouts to be used
    private static HBox hBox;
    private static VBox vBox;

    private static Scene scene;
    private static Stage primaryStage;

    static String importExportBox(String title, String actionPerformed) {

        // Create secondary stage: if primaryStage initialized, other alert boxes will collide with it. Window will not close
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle(title);
        secondaryStage.initModality(Modality.APPLICATION_MODAL);

        // Setting up the accept button
        accept = new Button("Ok");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Setting up the reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up the message label
        messageLabel = new Label(actionPerformed);

        // Setting up the text box
        TextField fileName = new TextField("Library Inventory");

        // Button actions
        accept.setOnAction(event -> {
            s = (fileName.getText());
            AlertBox.generalNotification("Library Exported", "Library \"" + s + ".txt\" has been exported from the program.");
        });

        reject.setOnAction(event -> secondaryStage.close());

        // Layout design
        hBox = new HBox(10, messageLabel);
        hBox.getChildren().addAll(fileName, accept, reject);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);

        // Setting up the scene
        scene = new Scene(hBox, 530, 80);

        // Finalize stage
        secondaryStage.setScene(scene);
        secondaryStage.showAndWait();

        return s;
    }


    static void addToLibrary() {

        // Set up the primary stage
        primaryStage = new Stage();
        primaryStage.setTitle("Add New Item");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Setting up the accept button
        accept = new Button("Ok");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Setting up the reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up the message label
        messageLabel = new Label("Enter item you want to add to the library: ");

        // Making a choice box
        ChoiceBox<String> selectionChoice = new ChoiceBox<>();
        selectionChoice.getItems().addAll("Book", "Novel", "Tourist Guide", "Children's Lit", "Periodical",
                "Newspaper", "Magazine", "Comic", "Video", "Movie", "Documentary",
                "Archive Footage", "Audio", "Music", "Audiobook", "Podcast");

        // Set default value of choice box
        selectionChoice.setValue("Novel");

        // Button actions
        // Confirming gets value from selectionChoice drop box and sends it to supportBox for evaluation. supportBox evaluates, calls AddItemBox class
        accept.setOnAction(event -> PeripheralBox.ItemSelect(selectionChoice.getValue()));
        reject.setOnAction(event -> primaryStage.close());

        // Layout design
        hBox = new HBox(10, messageLabel);
        hBox.getChildren().addAll(selectionChoice, accept, reject);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.BASELINE_LEFT);

        // Setting up the scene
        scene = new Scene(hBox, 650, 80);

        // Launch stage stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void showContent() {

        // Set up the primary stage
        primaryStage = new Stage();
        primaryStage.setTitle("Show Database");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Setting up the accept button
        accept = new Button("Ok");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Setting up the reject button
        reject = new Button("Cancel");
        reject.setMinSize(90, 30);
        reject.setMaxSize(30, 10);

        // Setting up the message label
        messageLabel = new Label("Enter item you want to add to the library: ");

        // Making a choice box
        ChoiceBox<String> selectionChoice = new ChoiceBox<>();
        selectionChoice.getItems().addAll("Inventory", "Book", "Novel", "Tourist Guide", "Children's Lit", "Periodical",
                "Newspaper", "Magazine", "Comic", "Video", "Movie", "Documentary",
                "Archive Footage", "Audio", "Music", "Audiobook", "Podcast");

        // Set default value of choice box
        selectionChoice.setValue("Novel");

        // Button actions
        // Confirming gets value from selectionChoice drop box and sends it to supportBox for evaluation. supportBox evaluates, calls AddItemBox class
        accept.setOnAction(event -> PeripheralBox.ItemRead(selectionChoice.getValue()));
        reject.setOnAction(event -> primaryStage.close());

        // Layout design
        hBox = new HBox(10, messageLabel);
        hBox.getChildren().addAll(selectionChoice, accept, reject);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.BASELINE_LEFT);

        // Setting up the scene
        scene = new Scene(hBox, 650, 80);

        // Launch stage stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static void generalNotification(String title, String actionPerformed) {

        // Setting up the primary stage
        primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Setting up the accept button
        accept = new Button("OK");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Setting up the message label
        messageLabel = new Label(actionPerformed);

        // Layout design
        vBox = new VBox(10);
        vBox.getChildren().addAll(messageLabel, accept);
        vBox.setAlignment(Pos.CENTER);

        // Button action
        accept.setOnAction(event -> primaryStage.close());

        // Setting up the scene
        scene = new Scene(vBox, 420, 120);

        // Finalize stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void credits() {
        // Credits roll:
        String creditsRoll = "";

        creditsRoll += "Program Name: TRIGLAV\u2122 Library Database\n\n" +
                "Build: v 0.9.4 BETA,\tMade on: May 20, 2018\n\n" +
                "Program Powered by: Java Virtual Machine\n\n" +
                "Created by: Luka Sapund\u017ei\u0107\n\n\n\n" +
                "\t\tSpecial Thanks To:\n\n" +
                "- Faculty of Information Studies in Novo Mesto\n" +
                "- Prof. Dr. Bernard \u017denko\n" +
                "- Course Assistant Borut Lu\u017ear\n\n" +
                "- COLO Laboratory Experts Slovenia\n\n" +
                "- Dr. Philip Birget\n" +
                "- Denis Pingin\n" +
                "- Nikola Voji\u010Di\u0107\n" +
                "- Dr. Pavel Zheltov\n";

        // Setting up the primary stage
        primaryStage = new Stage();
        primaryStage.setTitle("About This Software");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Setting up the accept button
        accept = new Button("OK");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Setting up the label
        messageLabel = new Label(creditsRoll);

        // Layout design
        vBox = new VBox(45);
        vBox.getChildren().addAll(messageLabel, accept);
        vBox.setAlignment(Pos.CENTER);

        // Button action
        accept.setOnAction(event -> primaryStage.close());

        // Setting up the scene
        scene = new Scene(vBox, 550, 550);

        // Finalize stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    static boolean confirmExit(String title, String message) {

        // Initiate primary stage
        primaryStage = new Stage();

        // Declare buttons
        accept = new Button("Yes");
        reject = new Button("No");

        // Set button size
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);
        reject.setMinSize(90, 30);
        reject.setMaxSize(90, 30);

        // Declare label
        messageLabel = new Label();
        messageLabel.setText(message);

        // Set up layout
        vBox = new VBox(10);
        vBox.getChildren().addAll(messageLabel, accept, reject);
        vBox.setAlignment(Pos.CENTER);

        // Set action on buttons
        accept.setOnAction(event -> {
            answer = true;
            primaryStage.close();
        });

        reject.setOnAction(event -> {
            answer = false;
            primaryStage.close();
        });

        // Add layout to the scene
        scene = new Scene(vBox, 310, 170);

        // Add scene to stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);

        // Command for making the window stick
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.showAndWait();

        // Return user decision on closing the window
        return answer;
    }

    static void programErrorSoft(String exceptionType) {

        // Setting up the primary stage
        primaryStage = new Stage();
        primaryStage.setTitle("SYSTEM ERROR");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Setting up the accept button
        accept = new Button("OK");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Setting up the message label
        Label programEndLabel = new Label("Software has encountered an error. Program has been terminated.");
        messageLabel = new Label("Error type: " + exceptionType);

        // Layout design
        vBox = new VBox(10);
        vBox.getChildren().addAll(programEndLabel, messageLabel, accept);
        vBox.setAlignment(Pos.CENTER);

        // Button action
        accept.setOnAction(event -> primaryStage.close());

        // Setting up the scene
        scene = new Scene(vBox, 420, 120);

        // Finalize stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    static void programError(String exceptionType) {

        // Setting up the primary stage
        primaryStage = new Stage();
        primaryStage.setTitle("SYSTEM ERROR");
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // Setting up the accept button
        accept = new Button("OK");
        accept.setMinSize(90, 30);
        accept.setMaxSize(30, 10);

        // Setting up the message label
        Label programEndLabel = new Label("Software has encountered an error. Program has been terminated.");
        messageLabel = new Label("Error type: " + exceptionType);

        // Layout design
        vBox = new VBox(10);
        vBox.getChildren().addAll(programEndLabel, messageLabel, accept);
        vBox.setAlignment(Pos.CENTER);

        // Button action
        accept.setOnAction(event -> System.exit(0));

        // Setting up the scene
        scene = new Scene(vBox, 420, 120);

        // Finalize stage
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
}
