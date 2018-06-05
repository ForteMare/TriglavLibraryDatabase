package inventory.print.periodical;

import inventory.LibraryDatabase;

public class Newspaper extends Periodical {
    private boolean tabloid;

    public Newspaper() {
        this(false);
        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public Newspaper(boolean tabloid) {
        this.tabloid = tabloid;
        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public Newspaper(String title, String author, String genre, String publicationFrequency, boolean tabloid) {
        super(title, author, genre, publicationFrequency);
        this.tabloid = tabloid;
        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public boolean isTabloid() {
        return tabloid;
    }

    public void setTabloid(boolean tabloid) {
        this.tabloid = tabloid;
    }


    @Override
    public void addToDatabase() {
        LibraryDatabase.addNewspaper(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "tabloid=" + tabloid +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Tabloid: ")
                .append(isTabloid())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isTabloid())
                .append("\r\n");

        return sb;
    }
}
