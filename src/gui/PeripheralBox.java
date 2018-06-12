/*
Class holds methods not essential to JavaFX and GUI that were causing too much clutter in main method.
 */


package gui;

import gui.inventoryView.*;
import inventory.LibraryDatabase;
import inventory.print.book.Novel;
import javafx.application.Platform;

import java.io.File;
import java.io.PrintWriter;


class PeripheralBox {

    /*
    I was unable to find an FX control that would substitute itemSelect.
    If more time is available, this method should be thrown out.
     */
    static void ItemSelect(String userSelect) {

        switch (userSelect) {
            case "Novel":
                AddItemBox.addNovel();
                break;
            case "Tourist Guide":
                AddItemBox.addTouristGuide();
                break;
            case "Children's Lit":
                AddItemBox.addChildrensLit();
                break;
            case "Newspaper":
                AddItemBox.addNewspaper();
                break;
            case "Magazine":
                AddItemBox.addMagazine();
                break;
            case "Comic":
                AddItemBox.addComics();
                break;
            case "Movie":
                AddItemBox.addMovie();
                break;
            case "Documentary":
                AddItemBox.addDocumentary();
                break;
            case "Archive Footage":
                AddItemBox.addArchiveFootage();
                break;
            case "Music":
                AddItemBox.addMusic();
                break;
            case "Audiobook":
                AddItemBox.addAudioBook();
                break;
            case "Podcast":
                AddItemBox.addPodcast();
                break;
            case "Book":
                AddItemBox.addBook();
                break;
            case "Periodical":
                AddItemBox.addPeriodical();
                break;
            case "Video":
                AddItemBox.addVideo();
                break;
            case "Audio":
                AddItemBox.addAudio();
                break;
            default:
                AlertBox.programError("Error occurred in switch statement in PeripheralBox class");

        }
    }

    static void ItemRead(String userSelect) {

        switch (userSelect) {
            case "Inventory":
                InventoryView.viewInventory();
                break;
            case "Novel":
                Novel.displayInventory();
                break;
            case "Tourist Guide":
                TouristGuideView.viewInventory();
                break;
            case "Children's Lit":
                ChildrensLitView.viewInventory();
                break;
            case "Newspaper":
                NewspaperView.viewInventory();
                break;
            case "Magazine":
                MagazineView.viewInventory();
                break;
            case "Comic":
                ComicView.viewInventory();
                break;
            case "Movie":
                MovieView.viewInventory();
                break;
            case "Documentary":
                DocumentaryView.viewInventory();
                break;
            case "Archive Footage":
                ArchiveFootageView.viewInventory();
                break;
            case "Music":
                MusicView.viewInventory();
                break;
            case "Audiobook":
                AudiobookView.viewInventory();
                break;
            case "Podcast":
                PodcastView.viewInventory();
                break;
            case "Book":
                BookView.viewInventory();
                break;
            case "Periodical":
                PeriodicalView.viewInventory();
                break;
            case "Video":
                VideoView.viewInventory();
                break;
            case "Audio":
                AudioView.viewInventory();
                break;
            default:
                AlertBox.programError("Error occurred in switch statement in PeripheralBox class");

        }
    }

    // Method for closing the program, delete if not used multiple times until end-product.

    static void closingProgram() {
        try {
            boolean answer = AlertBox.confirmExit("Exit Program", "Are you sure you want to exit the program?");
            if (answer) {
                Platform.exit();
            }
        } catch (Exception e) {
            AlertBox.programError(e.toString());

        }
    }

    static void printInfo(String fileName) throws Exception {

        // User will probably not think about adding a .txt at the end of the file name
        fileName += ".txt";

        // Creating object
        File rawExportFile, finalExportFile;
        rawExportFile = new File("IO Inventory Data.txt");
        finalExportFile = new File(fileName);

        // Creating a file
        PrintWriter printRawInventory, printFinalInventory;
        printRawInventory = new PrintWriter(rawExportFile);
        printFinalInventory = new PrintWriter(finalExportFile);

        // Print into file
        for (int i = 0; i < LibraryDatabase.getInventoryList().size(); i++) {
            printRawInventory.print(LibraryDatabase.getInventoryList().get(i).returnRawInfo());
            printFinalInventory.print(LibraryDatabase.getInventoryList().get(i).returnFinalInfo() + "\r\n");
        }

        printRawInventory.close();
        printFinalInventory.close();
    }

}

