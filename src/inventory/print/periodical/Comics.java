package inventory.print.periodical;

import inventory.LibraryDatabase;

public class Comics extends Periodical {
    private boolean manga;
    private boolean graphicNovel;

    public Comics() {
        this(false, false);
        setInternalID(17);
        setType(getClass().getSimpleName());
    }

    public Comics(boolean manga, boolean graphicNovel) {
        this.manga = manga;
        this.graphicNovel = graphicNovel;
        setInternalID(17);
        setType(getClass().getSimpleName());
    }

    public Comics(String title, String author, String genre, String publicationFrequency, boolean manga, boolean graphicNovel) {
        super(title, author, genre, publicationFrequency);
        this.manga = manga;
        this.graphicNovel = graphicNovel;
        setInternalID(17);
        setType(getClass().getSimpleName());
    }

    public boolean isManga() {
        return manga;
    }

    public void setManga(boolean manga) {
        this.manga = manga;
    }

    public boolean isGraphicNovel() {
        return graphicNovel;
    }

    public void setGraphicNovel(boolean graphicNovel) {
        this.graphicNovel = graphicNovel;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addComics(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Comics{" +
                "manga=" + manga +
                ", graphicNovel=" + graphicNovel +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Manga: ")
                .append(isManga())
                .append("\r\n")
                .append("Graphic novel: ")
                .append(isGraphicNovel())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isManga())
                .append("\r\n")
                .append(isGraphicNovel())
                .append("\r\n");

        return sb;
    }
}
