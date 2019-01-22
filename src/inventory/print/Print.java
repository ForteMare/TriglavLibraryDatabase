package inventory.print;

import inventory.Inventory;

public class Print extends Inventory {
    private String author;
    private String subType; // Previously called genre. Now it will hold more general sub-type which can be genre or anything else.

    // Empty constructor sets default information without which the program wouldn't work properly. Calls standard constructor
    public Print() {
        this("Unknown author", "Unknown subType");
        setInternalID(1);
        setType(getClass().getSimpleName());
    }

    // Standard constructor takes in information available in this class
    public Print(String author, String subType) {
        this.author = author;
        this.subType = subType;
        setInternalID(1);
        setType(getClass().getSimpleName());
    }

    // Extended constructor takes in information from class and superclass
    public Print(String title, String author, String subType) {
        this(author, subType);
        setTitle(title);
        setInternalID(1);
        setType(getClass().getSimpleName());

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    @Override
    public void addToDatabase() {
        // To be determined whether I wish to activate it in this class.
    }

    @Override
    public String toString() {
        return "Print{" +
                "author='" + author + '\'' +
                ", subType='" + subType + '\'' +
                '}';
    }

    @Override
    public StringBuilder returnFinalInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item: ")
                .append(getType())
                .append("\r\n")
                .append("Title: ")
                .append(getTitle())
                .append("\r\n")
                .append("Author: ")
                .append(getAuthor())
                .append("\r\n")
                .append("Genre: ")
                .append(getSubType())
                .append("\r\n");

        return sb;
    }

    @Override
    public StringBuilder returnRawInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType())
                .append("\r\n")
                .append(getTitle())
                .append("\r\n")
                .append(getAuthor())
                .append("\r\n")
                .append(getSubType())
                .append("\r\n");

        return sb;
    }
}

