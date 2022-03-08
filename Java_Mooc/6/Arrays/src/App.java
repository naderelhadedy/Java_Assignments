public class App {
    public static void main(String[] args) throws Exception {
        /*
        // array of primitive data type

        // declaring array of integers
        int [] myArr;
        // creating new object of array and assigning the size of array
        myArr = new int [3];
        // assigning values for indices of array
        myArr[0] = 10;
        myArr[1] = 20;
        myArr[2] = 30;

        System.out.println(myArr[0]);
        */

        /*
        // array of object reference data type

        // can be declared in one line like this
        String [] namesArr = new String [2];
        //namesArr = new String [2];
        namesArr[0] = "hello";
        namesArr[1] = "honey!";
        System.out.println(namesArr[1].length());
        */


        // array of arrays
        int [][] myBigArray = new int [3][2];
        myBigArray[0][0] = 50;
        System.out.println(myBigArray[0][0]);
    }
}
