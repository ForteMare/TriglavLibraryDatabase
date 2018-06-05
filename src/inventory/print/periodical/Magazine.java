package inventory.print.periodical;

import inventory.LibraryDatabase;

public class Magazine extends Periodical {
    private boolean qualityPrint;
    private boolean containsNudity;

    public Magazine() {
        this(false, false);
        setInternalID(13);
        setType(getClass().getSimpleName());
    }

    public Magazine(boolean qualityPrint, boolean containsNudity) {
        this.qualityPrint = qualityPrint;
        this.containsNudity = containsNudity;
        setInternalID(13);
        setType(getClass().getSimpleName());
    }

    public Magazine(String title, String author, String genre, int publicationFrequency, boolean qualityPrint, boolean containsNudity) {
        super(title, author, genre, publicationFrequency);
        this.qualityPrint = qualityPrint;
        this.containsNudity = containsNudity;
        setInternalID(13);
        setType(getClass().getSimpleName());
    }

    public boolean isQualityPrint() {
        return qualityPrint;
    }

    public void setQualityPrint(boolean qualityPrint) {
        this.qualityPrint = qualityPrint;
    }

    public boolean isContainsNudity() {
        return containsNudity;
    }

    public void setContainsNudity(boolean containsNudity) {
        this.containsNudity = containsNudity;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addMagazine(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "qualityPrint=" + qualityPrint +
                ", containsNudity=" + containsNudity +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Quality print: ")
                .append(isQualityPrint())
                .append("\r\n")
                .append("For minors: ")
                .append(isContainsNudity())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(isQualityPrint())
                .append("\r\n")
                .append(isContainsNudity())
                .append("\r\n");

        return sb;
    }
}
