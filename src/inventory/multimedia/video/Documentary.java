package inventory.multimedia.video;

import inventory.LibraryDatabase;

public class Documentary extends Video {
    private boolean color;

    public Documentary() {
        this(false);
        setInternalID(12);
        setType(getClass().getSimpleName());
    }

    public Documentary(boolean color) {
        this.color = color;
        setInternalID(12);
        setType(getClass().getSimpleName());
    }

    public Documentary(String title, String publisher, String subDefine, String director, String screenwriter, boolean color) {
        super(title, publisher, subDefine, director, screenwriter);
        this.color = color;
        setInternalID(12);
        setType(getClass().getSimpleName());
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addDocumentary(this);
        LibraryDatabase.addVideo(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Documentary{" +
                "color=" + color +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnFinalInfo())
                .append("Multicolor: ")
                .append(isColor())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnRawInfo())
                .append(isColor())
                .append("\r\n");

        return sb;
    }
}
