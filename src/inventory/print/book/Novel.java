package inventory.print.book;

import inventory.LibraryDatabase;

public class Novel extends Book {
    private String language;

    public Novel() {
        this("Unknown language");

        setInternalID(11);
        setType(getClass().getSimpleName());
    }

    public Novel(String language) {
        this.language = language;
        setInternalID(11);
        setType(getClass().getSimpleName());
    }

    public Novel(String title, String author, String subType, boolean hardCover, int yearPublished, String ddcLocation, String language) {
        super(title, author, subType, hardCover, yearPublished, ddcLocation);
        this.language = language;
        setInternalID(11);
        setType(getClass().getSimpleName());

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addNovel(this);
        LibraryDatabase.addBook(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Novel{" +
                "language='" + language + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Language: ")
                .append(getLanguage())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getLanguage())
                .append("\r\n");

        return sb;
    }
}
