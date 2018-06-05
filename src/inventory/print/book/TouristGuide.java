package inventory.print.book;

import inventory.LibraryDatabase;

public class TouristGuide extends Book {
    private String region;
    private boolean includesMap;

    public TouristGuide() {
        this("Unknown region", false);
        setInternalID(7);
        setType(getClass().getSimpleName());
    }

    public TouristGuide(String region, boolean includesMap) {
        this.region = region;
        this.includesMap = includesMap;
        setInternalID(7);
        setType(getClass().getSimpleName());
    }

    public TouristGuide(String title, String author, String subType, boolean hardCover, int yearPublished, String ddcLocation, String region, boolean includesMap) {
        super(title, author, subType, hardCover, yearPublished, ddcLocation);
        this.region = region;
        this.includesMap = includesMap;
        setInternalID(7);
        setType(getClass().getSimpleName());
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isIncludesMap() {
        return includesMap;
    }

    public void setIncludesMap(boolean includesMap) {
        this.includesMap = includesMap;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addTouristGuide(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "TouristGuide{" +
                "region='" + region + '\'' +
                ", includesMap=" + includesMap +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("Region: ")
                .append(getRegion())
                .append("\r\n")
                .append("Hiking trails: ")
                .append(isIncludesMap())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getRegion())
                .append("\r\n")
                .append(isIncludesMap())
                .append("\r\n");

        return sb;
    }
}
