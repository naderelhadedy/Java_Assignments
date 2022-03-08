// creating class
public class SerratedDisc {

    // creating private attributes
    private int size;
    private int numberOfPins;

    // creating static attribute
    private static String COMPNAME;

    // setter method for private attribute
    public void setSize(int size) {
        this.size = size;
    }

    // setter method for private attribute
    public void setNumberOfPins(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    // getter method for private attribute
    public int getSize() {
        return size;
    }

    // getter method for private attribute
    public int getNumberOfPins() {
        return numberOfPins;
    }

    // creating static method
    public static void setCOMPNAME(String name) {
        COMPNAME = name;
    }

    // another static method
    public static String getCOMPNAME() {
        return COMPNAME;
    }

    // constructor method
    public SerratedDisc(int size, int numberOfPins) {
        this.size = size;
        this.numberOfPins = numberOfPins;
    }

    // class method
    public void spin() {
        
        System.out.println("The Disc is spinning now");
    }
}