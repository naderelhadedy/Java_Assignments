// NORMAL INNER CLASS

public class OuterClass {
    private int x;

    public void myMethod() {
        // create object from inner class inside a method in outer class
        MyInnerClass m = new MyInnerClass();
    }

    // inner class
    class MyInnerClass() {
        public void aMethod() {
            x = 3;
        }
    }
}



// if you want to call in another file
public class Test {
    public static void main(String[] args) {
        
        // create object from outer class first to create from inner class
        OuterClass obj = new OuterClass();
        // create object from inner class
        OuterClass.MyInnerClass m = obj.new MyInnerClass();
    }
}




public class OuterClass {
    private int x;

    public void myMethod() {
        // create object from inner class inside a method in outer class
        MyInnerClass m = new MyInnerClass();
    }

    // inner class
    class MyInnerClass() {
        int x;

        public void aMethod() {
            this.x = 10; // for inner variable x
            OuterClass.this.x = 3; // for outer variable x
        }
    }
}





// STATIC INNER CLASS

public class OuterClass {
    private int x;
    static int y;

    // inner class
    // can access static members only
    static class MyInnerClass() {
        public void aMethod() {
            //x = 3; // worng
            y = 3; // right
        }
    }
}


// if you want to call in another file
public class Test {
    public static void main(String[] args) {
        
        // create object like dealing with static member in outer class
        OuterClass.MyInnerClass m = OuterClass.new MyInnerClass();
    }
}




// LOCAL INNER CLASS


public class OuterClass {

    private int x;

    public void myMethod(final int a) {
        final int b;
        
        // local class inside a method
        class MyInnerClass() {
            public void aMethod() {
                // you can access members in outer level and final members in this level only
            }
        }

        // the object must be defined in the level of the class after it
        MyInnerClass m = new MyInnerClass();
    }
}





// ANONYMOUS INNER CLASS


public class MyClass extends Applet {
    int x;

    public void init() {
        // anonymous class implements runnable then created object and sent it to thread constructor and also overrides run method inside it
        Thread th = new Thread(new Runnable() {
            public void run() {
                // your code
            }
        });

        th.start();
    }
}