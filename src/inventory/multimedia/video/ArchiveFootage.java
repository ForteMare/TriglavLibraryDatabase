package inventory.multimedia.video;

import inventory.LibraryDatabase;

public class ArchiveFootage extends Video {
    private boolean regionalHistory;
    private boolean propaganda;

    public ArchiveFootage() {
        this(false, false);
        setInternalID(16);
        setType(getClass().getSimpleName());
    }

    public ArchiveFootage(boolean regionalHistory, boolean propaganda) {
        this.regionalHistory = regionalHistory;
        this.propaganda = propaganda;
        setInternalID(16);
        setType(getClass().getSimpleName());
    }

    public ArchiveFootage(String title, String publisher, String subDefine, String director, String screenwriter, boolean regionalHistory, boolean propaganda) {
        super(title, publisher, subDefine, director, screenwriter);
        this.regionalHistory = regionalHistory;
        this.propaganda = propaganda;
        setInternalID(16);
        setType(getClass().getSimpleName());
    }

    public boolean isRegionalHistory() {
        return regionalHistory;
    }

    public void setRegionalHistory(boolean regionalHistory) {
        this.regionalHistory = regionalHistory;
    }

    public boolean isPropaganda() {
        return propaganda;
    }

    public void setPropaganda(boolean propaganda) {
        this.propaganda = propaganda;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addArchiveFootage(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "ArchiveFootage{" +
                "regionalHistory=" + regionalHistory +
                ", propaganda=" + propaganda +
                '}';
    }

    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnFinalInfo())
                .append("Regional History: ")
                .append(isRegionalHistory())
                .append("\r\n")
                .append("Propaganda material: ")
                .append(isPropaganda())
                .append("\r\n");
        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.returnRawInfo())
                .append(isRegionalHistory())
                .append("\r\n")
                .append(isPropaganda())
                .append("\r\n");
        return sb;
    }
}


