/*
>> Every object that is created with the most encompassing constructor is automatically added to an ArrayList here
>> This class contains only static ArrayLists which essentially serve as a database of all objects.
>> This is my solution for keeping track of objects without utilizing overly complicated methods(), as proposed at FIS.
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

    public LibraryDatabase() {

    }

    public static ArrayList<Inventory> getInventoryList() {
        return inventoryList;
    }

    public static void setInventoryList(ArrayList<Inventory> inventoryList) {
        LibraryDatabase.inventoryList = inventoryList;
    }

    public static ArrayList<Book> getBookList() {
        return bookList;
    }

    public static void setBookList(ArrayList<Book> bookList) {
        LibraryDatabase.bookList = bookList;
    }

    public static ArrayList<Video> getVideoList() {
        return videoList;
    }

    public static void setVideoList(ArrayList<Video> videoList) {
        LibraryDatabase.videoList = videoList;
    }

    public static ArrayList<Periodical> getPeriodicalList() {
        return periodicalList;
    }

    public static void setPeriodicalList(ArrayList<Periodical> periodicalList) {
        LibraryDatabase.periodicalList = periodicalList;
    }

    public static ArrayList<Audio> getAudioList() {
        return audioList;
    }

    public static void setAudioList(ArrayList<Audio> audioList) {
        LibraryDatabase.audioList = audioList;
    }

    public static ArrayList<TouristGuide> getTouristGuideList() {
        return touristGuideList;
    }

    public static void setTouristGuideList(ArrayList<TouristGuide> touristGuideList) {
        LibraryDatabase.touristGuideList = touristGuideList;
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public static void setMovieList(ArrayList<Movie> movieList) {
        LibraryDatabase.movieList = movieList;
    }

    public static ArrayList<Newspaper> getNewspaperList() {
        return newspaperList;
    }

    public static void setNewspaperList(ArrayList<Newspaper> newspaperList) {
        LibraryDatabase.newspaperList = newspaperList;
    }

    public static ArrayList<Music> getMusicList() {
        return musicList;
    }

    public static void setMusicList(ArrayList<Music> musicList) {
        LibraryDatabase.musicList = musicList;
    }

    public static ArrayList<Novel> getNovelList() {
        return novelList;
    }

    public static void setNovelList(ArrayList<Novel> novelList) {
        LibraryDatabase.novelList = novelList;
    }

    public static ArrayList<Documentary> getDocumentaryList() {
        return documentaryList;
    }

    public static void setDocumentaryList(ArrayList<Documentary> documentaryList) {
        LibraryDatabase.documentaryList = documentaryList;
    }

    public static ArrayList<Magazine> getMagazineList() {
        return magazineList;
    }

    public static void setMagazineList(ArrayList<Magazine> magazineList) {
        LibraryDatabase.magazineList = magazineList;
    }

    public static ArrayList<Audiobook> getAudiobookList() {
        return audiobookList;
    }

    public static void setAudiobookList(ArrayList<Audiobook> audiobookList) {
        LibraryDatabase.audiobookList = audiobookList;
    }

    public static ArrayList<ChildrensLiterature> getChildrenLitList() {
        return childrenLitList;
    }

    public static void setChildrenLitList(ArrayList<ChildrensLiterature> childrenLitList) {
        LibraryDatabase.childrenLitList = childrenLitList;
    }

    public static ArrayList<ArchiveFootage> getArchiveFootageList() {
        return archiveFootageList;
    }

    public static void setArchiveFootageList(ArrayList<ArchiveFootage> archiveFootageList) {
        LibraryDatabase.archiveFootageList = archiveFootageList;
    }

    public static ArrayList<Comic> getComicList() {
        return comicList;
    }

    public static void setComicList(ArrayList<Comic> comicList) {
        LibraryDatabase.comicList = comicList;
    }

    public static ArrayList<Podcast> getPodcastList() {
        return podcastList;
    }

    public static void setPodcastList(ArrayList<Podcast> podcastList) {
        LibraryDatabase.podcastList = podcastList;
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
