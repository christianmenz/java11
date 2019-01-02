package ch.christianmenz.java11.defaultmethods;

public class Test {

    public static void main(String[] args) {
        var anInterface = new Interface() {
        };

        anInterface.justDoIt();

        var anInterface2 = new Interface() {
            @Override
            public void extracted() {
                System.out.println("Overwritten");
            }
        };
        anInterface2.justDoIt();
    }
}
