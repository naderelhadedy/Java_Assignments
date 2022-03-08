public class MainClass {
    public static void main(String[] args) {

        // initialize an object
        SerratedDisc myCar = new SerratedDisc(5, 3);

        // calling methods

        myCar.setSize(10);
        int resultOfSize = myCar.getSize();

        System.out.println("Size value is " + resultOfSize);

        myCar.spin();

        // calling static methods
        SerratedDisc.setCOMPNAME("Hello from main class");
        String resultOfName = SerratedDisc.getCOMPNAME();

        System.out.println(resultOfName);
    }
}
