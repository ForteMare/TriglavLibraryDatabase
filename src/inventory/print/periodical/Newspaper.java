package inventory.print.periodical;

import inventory.LibraryDatabase;

public class Newspaper extends Periodical {
    private boolean tabloid;
    private boolean investigativeJournalism;

    public Newspaper() {
        this(false, false);
        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public Newspaper(boolean tabloid, boolean investigativeJournalism) {
        this.tabloid = tabloid;
        this.investigativeJournalism = investigativeJournalism;
        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public Newspaper(String title, String author, String genre, int publicationFrequency, boolean tabloid, boolean investigativeJournalism) {
        super(title, author, genre, publicationFrequency);
        this.tabloid = tabloid;
        this.investigativeJournalism = investigativeJournalism;
        setInternalID(9);
        setType(getClass().getSimpleName());
    }

    public boolean isTabloid() {
        return tabloid;
    }

    public void setTabloid(boolean tabloid) {
        this.tabloid = tabloid;
    }

    public boolean isInvestigativeJournalism() {
        return investigativeJournalism;
    }

    public void setInvestigativeJournalism(boolean investigativeJournalism) {
        this.investigativeJournalism = investigativeJournalism;
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
                ", investigativeJournalism=" + investigativeJournalism +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Tabloid: ")
                .append(isTabloid())
                .append("\r\n")
                .append("Investigative journalism: ")
                .append(isInvestigativeJournalism())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isTabloid())
                .append("\r\n")
                .append(isInvestigativeJournalism())
                .append("\r\n");

        return sb;
    }
}
