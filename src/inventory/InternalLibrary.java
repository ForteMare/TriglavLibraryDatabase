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
import inventory.print.Print;
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

        Print print = new Print("Journal of Science", "Multiple Authors", "Academia");
        print.addToDatabase();

        Book book = new Book("Na Drini cuprija", "Ivo Andric", "Historical Fiction", true, 1953, "CD-PPT");
        book.addToDatabase();

        Periodical periodical = new Periodical("Scientific American", "Multiple Authors", "Popular Science", "Weekly");
        periodical.addToDatabase();

        TouristGuide touristGuide = new TouristGuide("Biking in Slovenia", "Luka Vidmar", "Outdoors",
                false, 2015, "CCTQ5", "Dolenjska", true);
        touristGuide.addToDatabase();

        Newspaper newspaper = new Newspaper("The Intercept", "Glenn Greenwald", "Investigative Journalism", "Daily", false);
        newspaper.addToDatabase();

        Novel novel = new Novel("One Hundred Years of Solitude", "Gabriel Garcia Marques",
                "Magical Realism", false, 1991, "KWMN.541", "Spanish");
        novel.addToDatabase();

        Magazine magazine = new Magazine("Car World", "Multiple Authors", "Technology", "Monthly", true, false);
        magazine.addToDatabase();

        ChildrensLiterature childrensLiterature = new ChildrensLiterature("Winnie The Pooh", "That British Guy",
                "Bednight Stories", false, 2001, "KPTZ13", true, false);
        childrensLiterature.addToDatabase();

        Comic comic = new Comic("Captain America", "Jimmy Larson", "Superhero", "Monthly", false, false);
        comic.addToDatabase();

        Video video = new Video("Vienna in 1931", "Schonbrunn Blick", "Historical Footage", "Joseph Oppenheimer", "Robert Schmidt");
        video.addToDatabase();

        Audio audio = new Audio("Sounds of Schwarzwald Forest", "BayernInteractive", "Nature Sounds", "MP3");
        audio.addToDatabase();

        Movie movie = new Movie("A Clockwork Orange", "Tristar Columbia", "Cult",
                "Stanley Kubrick", "Conrad Lawrence", 8.8, false);
        movie.addToDatabase();

        Music music = new Music("The Queen", "Queen Productions", "Rock Opera", "FLAC", "Freddie Mercury", "Fat Bottomed Girls");
        music.addToDatabase();

        Documentary documentary = new Documentary("Planet Earth", "BBC Channel 4", "Nature",
                "Billy Timmons", "Josh Chaney", true);
        documentary.addToDatabase();

        Audiobook audiobook = new Audiobook("Ender's Game", "EscapePod", "Science Fiction", "MKV", 180.53, "Orson Scott Card");
        audiobook.addToDatabase();

        ArchiveFootage archiveFootage = new ArchiveFootage("The Second Session of AVNOJ", "RT Jugoslavije",
                "Propaganda", "Blazo Jelacic", "Edvard Stangelj", true, true);
        archiveFootage.addToDatabase();

        Podcast podcast = new Podcast("This American Life", "PBC Social", "Culture", "WAV", true, true);
        podcast.addToDatabase();

    }
}
