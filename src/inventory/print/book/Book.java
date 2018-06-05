package inventory.print.book;

import inventory.LibraryDatabase;
import inventory.print.Print;

public class Book extends Print {
    private boolean hardCover;
    private int yearPublished;
    private String ddcLocation;

    public Book() {
        this(false, 1991, "Unknown Location");
        setInternalID(3);
        setType(getClass().getSimpleName());
    }

    public Book(boolean hardCover, int yearPublished, String ddcLocation) {
        this.hardCover = hardCover;
        this.yearPublished = yearPublished;
        this.ddcLocation = ddcLocation;
        setInternalID(3);
        setType(getClass().getSimpleName());
    }

    public Book(String title, String author, String subType, boolean hardCover, int yearPublished, String ddcLocation) {
        super(title, author, subType);
        this.hardCover = hardCover;
        this.yearPublished = yearPublished;
        this.ddcLocation = ddcLocation;
        setInternalID(3);
        setType(getClass().getSimpleName());

    }

    public boolean isHardCover() {
        return hardCover;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getDdcLocation() {
        return ddcLocation;
    }

    public void setDdcLocation(String ddcLocation) {
        this.ddcLocation = ddcLocation;
    }

    @Override
    public void addToDatabase() {

        LibraryDatabase.addBook(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "hardCover=" + hardCover +
                ", yearPublished=" + yearPublished +
                ", ddcLocation='" + ddcLocation + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Hard cover: ")
                .append(isHardCover())
                .append("\r\n")
                .append("Year Published: ")
                .append(getYearPublished())
                .append("\r\n")
                .append("DDC Location: ")
                .append(ddcLocation)
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isHardCover())
                .append("\r\n")
                .append(getYearPublished())
                .append("\r\n")
                .append(ddcLocation)
                .append("\r\n");

        return sb;
    }


}
