package inventory.multimedia;

import inventory.Inventory;

public class Multimedia extends Inventory {
    private String publisher;
    private String subDefine;

    // Empty constructor sets default information without which the program wouldn't work properly. Calls standard constructor
    public Multimedia() {
        this("Unknown publisher", "Unknown unknown subDefine");
        setInternalID(2);
        setType(getClass().getSimpleName());
    }

    // Standard constructor takes in information available in this class
    public Multimedia(String publisher, String subDefine) {
        this.publisher = publisher;
        this.subDefine = subDefine;
        setInternalID(2);
        setType(getClass().getSimpleName());
    }

    // Extended constructor takes in information from class and superclass
    public Multimedia(String title, String publisher, String subDefine) {
        this(publisher, subDefine);
        setTitle(title);
        setInternalID(2);
        setType(getClass().getSimpleName());

    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubDefine() {
        return subDefine;
    }

    public void setSubDefine(String subDefine) {
        this.subDefine = subDefine;
    }

    @Override
    public void addToDatabase() {
        // See whether it needs to be activated at any point.
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "publisher='" + publisher + '\'' +
                ", subDefine='" + subDefine + '\'' +
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
                .append("Publisher: ")
                .append(getPublisher())
                .append("\r\n")
                .append("Sub Type: ")
                .append(getSubDefine())
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
                .append(getPublisher())
                .append("\r\n")
                .append(getSubDefine())
                .append("\r\n");

        return sb;
    }
}
