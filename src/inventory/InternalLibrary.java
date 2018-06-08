/*
This class is temporary.

>> It contains objects that help me with building the program without having to rely on import - export.
 */

package inventory;

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

import java.util.ArrayList;

public class InternalLibrary {

    private static ArrayList<Inventory> libraryInventory = new ArrayList<>();

    public static void startDatabase() {

        Book book = new Book("Na Drini Cuprija", "Ivo Andric", "Historical Fiction", true, 1959, "CPT.223");
        book.addToDatabase();

        Periodical periodical = new Periodical("The New New Times", "Mr Meow Meow", "CatNews", "Annual");
        periodical.addToDatabase();

        Video video = new Video("Unmarked WWII Footage", "Unknown Publisher", "History", "Cpt Brian", "Unknown");
        video.addToDatabase();

        Audio audio = new Audio();
        audio.addToDatabase();

        TouristGuide touristGuide = new TouristGuide();
        touristGuide.addToDatabase();

        Newspaper newspaper = new Newspaper();
        newspaper.addToDatabase();

        Movie movie = new Movie();
        movie.addToDatabase();

        Music music = new Music();
        music.addToDatabase();

        Novel novel = new Novel();
        novel.addToDatabase();

        Magazine magazine = new Magazine();
        magazine.addToDatabase();

        Documentary documentary = new Documentary();
        documentary.addToDatabase();

        Audiobook audiobook = new Audiobook();
        audiobook.addToDatabase();

        ChildrensLiterature childrensLiterature = new ChildrensLiterature();
        childrensLiterature.addToDatabase();

        Comic comic = new Comic();
        comic.addToDatabase();

        ArchiveFootage archiveFootage = new ArchiveFootage();
        archiveFootage.addToDatabase();

        Podcast podcast = new Podcast();
        podcast.addToDatabase();
    }
}
