/*
Class holds methods not essential to JavaFX and GUI that were causing too much clutter in main method.
 */


package gui;

import inventory.LibraryDatabase;
import javafx.application.Platform;

import java.io.File;
import java.io.PrintWriter;


class PeripheralBox {

    /*
    I was unable to find an FX control that would substitute itemSelect.
    If more time is available, this method should be thrown out.
     */
    static void ItemSelect(String userSelect) {

        // Remove SYSOUT in final stage of the program.

        switch (userSelect) {
            case "Novel":
                System.out.println("Novel");
                AddItemBox.addNovel();
                break;
            case "Tourist Guide":
                System.out.println("Tourist Guide");
                AddItemBox.addTouristGuide();
                break;
            case "Children's Lit":
                System.out.println("Children's Lit");
                AddItemBox.addChildrensLit();
                break;
            case "Newspaper":
                System.out.println("Newspaper");
                AddItemBox.addNewspaper();
                break;
            case "Magazine":
                System.out.println("Magazine");
                AddItemBox.addMagazine();
                break;
            case "Comic":
                System.out.println("Comic");
                AddItemBox.addComics();
                break;
            case "Movie":
                System.out.println("Movie");
                AddItemBox.addMovie();
                break;
            case "Documentary":
                System.out.println("Documentary");
                AddItemBox.addDocumentary();
                break;
            case "Archive Footage":
                System.out.println("Archive Footage");
                AddItemBox.addArchiveFootage();
                break;
            case "Music":
                System.out.println("Music");
                AddItemBox.addMusic();
                break;
            case "Audiobook":
                System.out.println("Audiobook");
                AddItemBox.addAudioBook();
                break;
            case "Podcast":
                System.out.println("Podcast");
                AddItemBox.addPodcast();
                break;
            case "Book":
                System.out.println("Book");
                AddItemBox.addBook();
                break;
            case "Periodical":
                System.out.println("Periodical");
                AddItemBox.addPeriodical();
                break;
            case "Video":
                System.out.println("Video");
                AddItemBox.addVideo();
                break;
            case "Audio":
                System.out.println("Audio");
                AddItemBox.addAudio();
                break;
            default:
                AlertBox.programError("Error occurred in switch statement in PeripheralBox class");

        }
    }

        // Method for closing the program, delete if not used multiple times until end-product.

        static void closingProgram () {
            try {
                boolean answer = AlertBox.confirmExit("Exit Program", "Are you sure you want to exit the program?");
                if (answer) {
                    Platform.exit();
                }
            } catch (Exception e) {
                AlertBox.programError(e.toString());

            }
        }

        static void printInfo (String fileName) throws Exception {

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

        static void importInfo () throws Exception {

        }
    }

