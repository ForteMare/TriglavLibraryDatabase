package inventory.multimedia.video;

import inventory.LibraryDatabase;
import inventory.multimedia.Multimedia;

public class Video extends Multimedia {
    private String director;
    private String screenwriter;

    public Video() {
        this("Unknown Director", "Unknown Screenwriter");
        setInternalID(4);
        setType(getClass().getSimpleName());
    }

    public Video(String director, String screenwriter) {
        this.director = director;
        this.screenwriter = screenwriter;
        setInternalID(4);
        setType(getClass().getSimpleName());
    }

    public Video(String title, String publisher, String subDefine, String director, String screenwriter) {
        super(title, publisher, subDefine);
        this.director = director;
        this.screenwriter = screenwriter;
        setInternalID(4);
        setType(getClass().getSimpleName());
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addVideo(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Video{" +
                "director='" + director + '\'' +
                ", screenwriter='" + screenwriter + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Director: ")
                .append(getDirector())
                .append("\r\n")
                .append("Screenwriter: ")
                .append(getScreenwriter())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getDirector())
                .append("\r\n")
                .append(getScreenwriter())
                .append("\r\n");

        return sb;
    }
}
