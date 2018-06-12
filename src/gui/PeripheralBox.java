/*
Class holds methods not essential to JavaFX and GUI that were causing too much clutter in main method.
 */


package gui;

import gui.inventoryView.InventoryView;
import inventory.LibraryDatabase;
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
                Novel.displayNovelInventory();
//                NovelView.viewInventory();
                break;
            case "Tourist Guide":
                TouristGuide.displayTouristGuideInventory();
                break;
            case "Children's Lit":
                ChildrensLiterature.displayChildrensLitInventory();
                break;
            case "Newspaper":
                Newspaper.displayNewspaperInventory();
                break;
            case "Magazine":
                Magazine.displayMagazineInventory();
                break;
            case "Comic":
                Comic.displayComicInventory();
                break;
            case "Movie":
                Movie.displayMovieInventory();
                break;
            case "Documentary":
                Documentary.displayDocumentaryInventory();
                break;
            case "Archive Footage":
                ArchiveFootage.displayInventory();
                break;
            case "Music":
                Music.displayInventory();
                break;
            case "Audiobook":
                Audiobook.displayInventory();
                break;
            case "Podcast":
                Podcast.displayPodcastInventory();
                break;
            case "Book":
                Book.displayBookInventory();
                break;
            case "Periodical":
                Periodical.displayPeriodicalInventory();
                break;
            case "Video":
                Video.displayVideoInventory();
                break;
            case "Audio":
                Audio.displayAudioInventory();
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

