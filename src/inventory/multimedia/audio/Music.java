package inventory.multimedia.audio;

import inventory.LibraryDatabase;

public class Music extends Audio {
    private String artist;
    private String album;

    public Music() {
        this("Unknown artist", "Unknown album");
        setInternalID(10);
        setType(getClass().getSimpleName());
    }

    public Music(String artist, String album) {
        this.artist = artist;
        this.album = album;
        setInternalID(10);
        setType(getClass().getSimpleName());
    }

    public Music(String title, String publisher, String subDefine, String format, String artist, String album) {
        super(title, publisher, subDefine, format);
        this.artist = artist;
        this.album = album;
        setInternalID(10);
        setType(getClass().getSimpleName());
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addMusic(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Music{" +
                "artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnFinalInfo())
                .append("Artist: ")
                .append(getArtist())
                .append("\r\n")
                .append("Album: ")
                .append(getAlbum())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnRawInfo())
                .append(getArtist())
                .append("\r\n")
                .append(getAlbum())
                .append("\r\n");

        return sb;
    }
}
