package inventory.multimedia.video;

import inventory.LibraryDatabase;

public class Movie extends Video {
    private double ratingIMDB;
    private boolean hollywoodProduction;

    public Movie() {
        this(10.0, false);
        setInternalID(8);
        setType(getClass().getSimpleName());
    }

    public Movie(double ratingIMDB, boolean hollywoodProduction) {
        this.ratingIMDB = ratingIMDB;
        this.hollywoodProduction = hollywoodProduction;
        setInternalID(8);
        setType(getClass().getSimpleName());
    }

    public Movie(String title, String publisher, String subDefine, String director, String screenwriter, double ratingIMDB, boolean hollywoodProduction) {
        super(title, publisher, subDefine, director, screenwriter);
        this.ratingIMDB = ratingIMDB;
        this.hollywoodProduction = hollywoodProduction;
        setInternalID(8);
        setType(getClass().getSimpleName());
    }

    public double getRatingIMDB() {
        return ratingIMDB;
    }

    public void setRatingIMDB(double ratingIMDB) {
        this.ratingIMDB = ratingIMDB;
    }

    public boolean isHollywoodProduction() {
        return hollywoodProduction;
    }

    public void setHollywoodProduction(boolean hollywoodProduction) {
        this.hollywoodProduction = hollywoodProduction;
    }

    @Override
    public void addToDatabase() {
        LibraryDatabase.addMovie(this);
        LibraryDatabase.addVideo(this);
        LibraryDatabase.addInventory(this);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ratingIMDB=" + ratingIMDB +
                ", hollywoodProduction=" + hollywoodProduction +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnFinalInfo())
                .append("IMDb Rating: ")
                .append(getRatingIMDB())
                .append("\r\n")
                .append("Hollywood Production: ")
                .append(isHollywoodProduction())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.returnRawInfo())
                .append(getRatingIMDB())
                .append("\r\n")
                .append(isHollywoodProduction())
                .append("\r\n");

        return sb;
    }
}
