/*
Parent abstract class of all items available in the library.

>> All the classes that extend Inventory are absolutely identical in structure, only that they hold different variables.
 */

package inventory;

public abstract class Inventory {

    private int internalID; // This variable identifies type of an object (book, music) by using an integer. Not available to end-user.
    private String type; // This String tells end-user what object s/he is interacting with. Holds class name
    private String title; // The lowest common denominator of this library is 'title'. Every inventory object has a title, no matter the type.
    private String availability; // Whether object is reserved or checked out...

    // Default constructor
    public Inventory() {
        this(0, Inventory.class.getName(), "Unknown Title", "Available");
    }

    // Full constructor
    public Inventory(int internalID, String type, String title, String availability) {
        this.internalID = internalID;
        this.type = type;
        this.title = title;
        this.availability = availability;

    }

    public int getInternalID() {
        return internalID;
    }

    public void setInternalID(int internalID) {
        this.internalID = internalID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // Abstract methods that are going to be used in sub-classes

    /*
    CLARIFICATION:
    - returnFinalInfo() holds data on classes but with String-type descriptions attached. Useful for
    printing info to .txt and having it look nice.
    - returnRawInfo() holds the same data as returnFinalInfo() but without descriptive strings.
    Originally, latter was to be used with I/O, .txt reading specifically.
    - addToDatabase() is currently inactive and may be deleted.
     */
    public abstract StringBuilder returnFinalInfo();
    public abstract StringBuilder returnRawInfo();
    public abstract void addToDatabase();
}
