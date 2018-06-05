package inventory.print.periodical;

import inventory.LibraryDatabase;
import inventory.print.Print;

public class Periodical extends Print {
    private int publicationFrequency;

    public Periodical() {
        this(0);
        setInternalID(5);
        setType(getClass().getSimpleName());
    }

    public Periodical(int publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
        setInternalID(5);
        setType(getClass().getSimpleName());
    }

    public Periodical(String title, String author, String genre, int publicationFrequency) {
        super(title, author, genre);
        this.publicationFrequency = publicationFrequency;
        setInternalID(5);
        setType(getClass().getSimpleName());
    }

    public int getPublicationFrequency() {
        return publicationFrequency;
    }

    public void setPublicationFrequency(int publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addPeriodical(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Periodical{" +
                "publicationFrequency=" + publicationFrequency +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Publication frequency: ")
                .append(getPublicationFrequency())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getPublicationFrequency())
                .append("\r\n");

        return sb;
    }
}
