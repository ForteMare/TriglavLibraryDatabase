package inventory.multimedia.audio;

import inventory.LibraryDatabase;

public class Podcast extends Audio {
    private boolean availableOffline;
    private boolean featuredOnItunes;

    public Podcast() {
        this(false, false);
        setInternalID(18);
        setType(getClass().getSimpleName());
    }

    public Podcast(boolean availableOffline, boolean featuredOnItunes) {
        this.availableOffline = availableOffline;
        this.featuredOnItunes = featuredOnItunes;
        setInternalID(18);
        setType(getClass().getSimpleName());
    }

    public Podcast(String title, String publisher, String subDefine, String format, boolean availableOffline, boolean featuredOnItunes) {
        super(title, publisher, subDefine, format);
        this.availableOffline = availableOffline;
        this.featuredOnItunes = featuredOnItunes;
        setInternalID(18);
        setType(getClass().getSimpleName());
    }

    public boolean isAvailableOffline() {
        return availableOffline;
    }

    public void setAvailableOffline(boolean availableOffline) {
        this.availableOffline = availableOffline;
    }

    public boolean isFeaturedOnItunes() {
        return featuredOnItunes;
    }

    public void setFeaturedOnItunes(boolean featuredOnItunes) {
        this.featuredOnItunes = featuredOnItunes;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addPodcast(this);
        LibraryDatabase.addAudio(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "availableOffline=" + availableOffline +
                ", featuredOnItunes=" + featuredOnItunes +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Available Offline: ")
                .append(isAvailableOffline())
                .append("\r\n")
                .append("Featured on Itunes: ")
                .append(isFeaturedOnItunes())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isAvailableOffline())
                .append("\r\n")
                .append(isFeaturedOnItunes())
                .append("\r\n");

        return sb;
    }
}
