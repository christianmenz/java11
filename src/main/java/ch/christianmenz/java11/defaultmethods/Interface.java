package ch.christianmenz.java11.defaultmethods;

public interface Interface {


    default void justDoIt() {
        extracted(); // will run default extracted() unless implemented
    }

    default void extracted() {
        extradedPrivate();
    }

    // new in Java 9, to better organize your code you can split it into private methods
    private void extradedPrivate() {
        System.out.println("Default Implementation");
    }
}
