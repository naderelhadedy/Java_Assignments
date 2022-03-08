public class App {
    public static void main(String[] args) throws Exception {

        String str1 = "hi";
        String str2 = "Hi";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        String str = str1 + " " + str2;
        System.out.println(str);

        str += " captain";
        System.out.println(str);

        str = str.concat("!");
        System.out.println(str);
    }
}
