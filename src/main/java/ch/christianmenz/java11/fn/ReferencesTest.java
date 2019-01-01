package ch.christianmenz.java11.fn;

import java.util.function.IntSupplier;

public class ReferencesTest {

    @FunctionalInterface
    interface TestFn {
        boolean exec(Object o);
    }

    @FunctionalInterface
    interface ReferenceTestFn {
        ReferencesTest create();
    }

    public static void main(String[] args) {
        // Simple method reference, can be any compatible functional interface
        IntSupplier activeCount = Thread::activeCount;
        System.out.println(activeCount.getAsInt());

        // With a custom fn interface
        TestFn holdsLock = Thread::holdsLock;
        boolean b = holdsLock.exec(ReferencesTest.class);
        System.out.println(b);
        
        // With constructors, yay
        ReferenceTestFn referenceTestFn = ReferencesTest::new;

        ReferencesTest test = referenceTestFn.create();
        System.out.println(test);

    }
}
