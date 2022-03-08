public class MainClass {
    public static void main(String[] args) {

        // creating object
        MyInterface mi = new MyClass();

        // calling abstract method
        mi.computeArea();

        // calling method that is undefined in MyInterface and get error
        //mi.anotherMethod();
    }
}
