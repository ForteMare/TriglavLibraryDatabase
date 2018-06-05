package inventory.multimedia.audio;

import inventory.LibraryDatabase;

public class Audiobook extends Audio {
    private double length;
    private String narrator;

    public Audiobook() {
        this(0.00, "Unknown narrator");
        setInternalID(14);
        setType(getClass().getSimpleName());
    }

    public Audiobook(double length, String narrator) {
        this.length = length;
        this.narrator = narrator;

        setInternalID(14);
        setType(getClass().getSimpleName());
    }

    public Audiobook(String title, String publisher, String subDefine, String format, double length, String narrator) {
        super(title, publisher, subDefine, format);
        this.length = length;
        this.narrator = narrator;

        setInternalID(14);
        setType(getClass().getSimpleName());
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addAudiobook(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Audiobook{" +
                "length=" + length +
                ", narrator='" + narrator + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Length: ")
                .append(getLength())
                .append("\r\n")
                .append("Narrator: ")
                .append(getNarrator())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getLength())
                .append("\r\n")
                .append(getNarrator())
                .append("\r\n");

        return sb;
    }
}
