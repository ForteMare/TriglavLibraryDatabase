/*
This class is temporary.

>> It contains objects that help me with building the program without having to rely on import - export.
 */

package inventory;

import inventory.multimedia.audio.Podcast;
import inventory.multimedia.video.Movie;
import inventory.print.book.Novel;

import java.util.ArrayList;

public class DefaultLibrary {

    private static ArrayList<Inventory> libraryInventory = new ArrayList<>();

    public static void startDatabase() {

        Movie m1 = new Movie("A Clockwork Orange", "20th Century Fox", "Psycho-drama", "Stanley Kubrick", "Mike Peterson", 8.7, true);
        Movie m2 = new Movie("Apocalypse Now", "Zoetrop Studios", "Drama", "Francis Ford Coppola", "John Milius", 7.7, true);
        Movie m3 = new Movie("Pan's Labyrinth", "Universal Studios", "Drama", "Guillermo del Toro", "Jacob White", 8.1, false);
        Movie m4 = new Movie("Cinema Paradiso", "Palermo Mare", "Coming of Age", "Giuseppe Tornatore", "Ricardo Fiore", 9.4, false);

        Novel n1 = new Novel("Things Fall Apart", "Chinua Achebe", "Fiction", true, 1995, "DC.51C3", "English");
        Podcast p1 = new Podcast("Escape Pod", "Daikaiju", "Science Fiction", "MP3", false, false);


    }
}
