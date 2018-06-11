/*
>> Every object that is created with the most encompassing constructor is automatically added to an ArrayList here
>> This class contains only static ArrayLists which essentially serve as a database of all objects.
>> This is my solution for keeping track of objects without utilizing overly complicated methods(), as proposed at FIS.
 */

package inventory;

import inventory.multimedia.Multimedia;
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

public class LibraryDatabase {

    /*
    >> Classes Print and Multimedia have not been included in this list, and these will probably never be added
    >> Setters will probably be deleted, as they serve no concievable purpose.
     */

    private static ArrayList<Inventory> inventoryList = new ArrayList<>();
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Video> videoList = new ArrayList<>();
    private static ArrayList<Periodical> periodicalList = new ArrayList<>();
    private static ArrayList<Audio> audioList = new ArrayList<>();
    private static ArrayList<TouristGuide> touristGuideList = new ArrayList<>();
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Newspaper> newspaperList = new ArrayList<>();
    private static ArrayList<Music> musicList = new ArrayList<>();
    private static ArrayList<Novel> novelList = new ArrayList<>();
    private static ArrayList<Documentary> documentaryList = new ArrayList<>();
    private static ArrayList<Magazine> magazineList = new ArrayList<>();
    private static ArrayList<Audiobook> audiobookList = new ArrayList<>();
    private static ArrayList<ChildrensLiterature> childrenLitList = new ArrayList<>();
    private static ArrayList<ArchiveFootage> archiveFootageList = new ArrayList<>();
    private static ArrayList<Comic> comicList = new ArrayList<>();
    private static ArrayList<Podcast> podcastList = new ArrayList<>();
    private static ArrayList<Print> printList = new ArrayList<>();
    private static ArrayList<Multimedia> multimediaList = new ArrayList<>();

    public LibraryDatabase() {

    }

    public static ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public static ArrayList<Book> getBookList() {
        return bookList;
    }

    public static ArrayList<Video> getVideoList() {
        return videoList;
    }

    public static ArrayList<Periodical> getPeriodicalList() {
        return periodicalList;
    }

    public static ArrayList<Audio> getAudioList() {
        return audioList;
    }

    public static ArrayList<TouristGuide> getTouristGuideList() {
        return touristGuideList;
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public static ArrayList<Newspaper> getNewspaperList() {
        return newspaperList;
    }

    public static ArrayList<Music> getMusicList() {
        return musicList;
    }

    public static ArrayList<Novel> getNovelList() {
        return novelList;
    }

    public static ArrayList<Documentary> getDocumentaryList() {
        return documentaryList;
    }

    public static ArrayList<Magazine> getMagazineList() {
        return magazineList;
    }

    public static ArrayList<Audiobook> getAudiobookList() {
        return audiobookList;
    }

    public static ArrayList<ChildrensLiterature> getChildrenLitList() {
        return childrenLitList;
    }

    public static ArrayList<ArchiveFootage> getArchiveFootageList() {
        return archiveFootageList;
    }

    public static ArrayList<Comic> getComicList() {
        return comicList;
    }

    public static ArrayList<Podcast> getPodcastList() {
        return podcastList;
    }

    public static ArrayList<Print> getPrintList() {
        return printList;
    }

    public static ArrayList<Multimedia> getMultimediaList() {
        return multimediaList;
    }

    // ######

    public static void addPrint(Print print) {
        printList.add(print);
    }

    public static void addMultimedia(Multimedia multimedia) {
        multimediaList.add(multimedia);
    }

    public static void addInventory(Inventory inventory) {
        inventoryList.add(inventory);
    }

    public static void addBook(Book book) {
        bookList.add(book);
    }

    public static void addVideo(Video video) {
        videoList.add(video);
    }

    public static void addPeriodical(Periodical periodical) {
        periodicalList.add(periodical);
    }

    public static void addAudio(Audio audio) {
        audioList.add(audio);
    }

    public static void addTouristGuide(TouristGuide touristGude) {
        touristGuideList.add(touristGude);
    }

    public static void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public static void addNewspaper(Newspaper newspaper) {
        newspaperList.add(newspaper);
    }

    public static void addMusic(Music music) {
        musicList.add(music);
    }

    public static void addNovel(Novel novel) {
        novelList.add(novel);
    }

    public static void addDocumentary(Documentary documentary) {
        documentaryList.add(documentary);
    }

    public static void addMagazine(Magazine magazine) {
        magazineList.add(magazine);
    }

    public static void addAudiobook(Audiobook audiobook) {
        audiobookList.add(audiobook);
    }

    public static void addChildrensBook(ChildrensLiterature childrensLiterature) {
        childrenLitList.add(childrensLiterature);
    }

    public static void addArchiveFootage(ArchiveFootage archiveFootage) {
        archiveFootageList.add(archiveFootage);
    }

    public static void addComics(Comic comic) {
        comicList.add(comic);
    }

    public static void addPodcast(Podcast podcast) {
        podcastList.add(podcast);
    }
}
