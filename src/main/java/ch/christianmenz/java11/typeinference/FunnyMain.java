package ch.christianmenz.java11.typeinference;

public class FunnyMain {

    public static void main(String[] args) {
        var runnable = new Runnable() {

            @Override
            public void run() {

            }

            public void test() {
                System.out.println("hello world!");
            }
        };

        runnable.test(); // this ain't a runnable, it's an implementation of a runnable

    }
}
