/*
Triglav Library Database has two main classes.

>> For interacting with the program through IDE IO, this is the main class.
>> For interacting with the program through JavaFX GUI, MainGUI is the main class.
 */

import inventory.InternalLibrary;
import inventory.Inventory;
import inventory.LibraryDatabase;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Inventory> libraryInventory = new ArrayList<>();

    public static void main(String[] args) {

        InternalLibrary.startDatabase();

//        System.out.println(LibraryDatabase.getNovelList().get(0).returnFinalInfo());

        System.out.println(LibraryDatabase.getNovelList().get(0).getType());
        System.out.println(LibraryDatabase.getNovelList().get(0).getTitle());
        System.out.println(LibraryDatabase.getNovelList().get(0).getAvailability());
        System.out.println(LibraryDatabase.getNovelList().get(0).getAuthor());
        System.out.println(LibraryDatabase.getNovelList().get(0).getSubType());
        System.out.println(LibraryDatabase.getNovelList().get(0).isHardCover());
        System.out.println(LibraryDatabase.getNovelList().get(0).getYearPublished());
        System.out.println(LibraryDatabase.getNovelList().get(0).getLanguage());

    }
}


















