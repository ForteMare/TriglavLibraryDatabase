package inventory.print.book;

import inventory.LibraryDatabase;

public class ChildrensLiterature extends Book {
    private boolean illustration; // Meaning whether the child is supposed to read them or paint them
    private boolean interactive;

    public ChildrensLiterature() {
        this(false, false);
        setInternalID(15);
        setType(getClass().getSimpleName());
    }

    public ChildrensLiterature(boolean illustration, boolean interactive) {
        this.illustration = illustration;
        this.interactive = interactive;
        setInternalID(15);
        setType(getClass().getSimpleName());
    }

    public ChildrensLiterature(String title, String author, String subType, boolean hardCover, int yearPublished, String ddcLocation, boolean illustration, boolean interactive) {
        super(title, author, subType, hardCover, yearPublished, ddcLocation);
        this.illustration = illustration;
        this.interactive = interactive;
        setInternalID(15);
        setType(getClass().getSimpleName());
    }

    public boolean isIllustration() {
        return illustration;
    }

    public void setIllustration(boolean illustration) {
        this.illustration = illustration;
    }

    public boolean isInteractive() {
        return interactive;
    }

    public void setInteractive(boolean interactive) {
        this.interactive = interactive;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addChildrensBook(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "ChildrensLiterature{" +
                "illustration=" + illustration +
                ", interactive=" + interactive +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Picture book: ")
                .append(isIllustration())
                .append("\r\n")
                .append("Fairytale: ")
                .append(isInteractive())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isIllustration())
                .append("\r\n")
                .append(isInteractive())
                .append("\r\n");

        return sb;
    }
}
