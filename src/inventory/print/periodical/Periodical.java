package inventory.print.periodical;

import inventory.LibraryDatabase;
import inventory.print.Print;

public class Periodical extends Print {
    private String publicationFrequency;

    public Periodical() {
        this("None");
        setInternalID(5);
        setType(getClass().getSimpleName());
    }

    public Periodical(String publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
        setInternalID(5);
        setType(getClass().getSimpleName());
    }

    public Periodical(String title, String author, String genre, String publicationFrequency) {
        super(title, author, genre);
        this.publicationFrequency = publicationFrequency;
        setInternalID(5);
        setType(getClass().getSimpleName());
    }

    public String getPublicationFrequency() {
        return publicationFrequency;
    }

    public void setPublicationFrequency(String publicationFrequency) {
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
