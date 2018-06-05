/*
Triglav Library Database has two main classes.

>> For interacting with the program through IDE IO, this is the main class.
>> For interacting with the program through JavaFX GUI, MainLaunchGUI is the main class.
 */

import inventory.BasicLibrary;
import inventory.Inventory;
import inventory.LibraryDatabase;

import java.util.ArrayList;

public class Controls {

    private static ArrayList<Inventory> libraryInventory = new ArrayList<>();

    public static void main(String[] args) {

        BasicLibrary.startDatabase();


        for (int i = 0; i < LibraryDatabase.getInventoryList().size(); i++) {
            if(LibraryDatabase.getInventoryList().get(i).getInternalID() == 8) {
                System.out.println(LibraryDatabase.getInventoryList().get(i).returnFinalInfo());
            }
        }
    }
}


















