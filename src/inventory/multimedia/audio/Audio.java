package inventory.multimedia.audio;

import inventory.LibraryDatabase;
import inventory.multimedia.Multimedia;

public class Audio extends Multimedia {
    private String format;

    public Audio() {
        this("mp3");
        setInternalID(6);
        setType(getClass().getSimpleName());
    }

    public Audio(String format) {
        this.format = format;
        setInternalID(6);
        setType(getClass().getSimpleName());
    }

    public Audio(String title, String publisher, String subDefine, String format) {
        super(title, publisher, subDefine);
        this.format = format;
        setInternalID(6);
        setType(getClass().getSimpleName());
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addAudio(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Audio{" +
                "format=" + format +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Format: ")
                .append(getFormat())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getFormat())
                .append("\r\n");

        return sb;
    }
}
