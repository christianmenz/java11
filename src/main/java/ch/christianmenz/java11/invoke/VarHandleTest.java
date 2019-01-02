package ch.christianmenz.java11.invoke;

import java.lang.invoke.MethodHandles;

public class VarHandleTest {

    public static String test = "Hello World";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        var varHandle = MethodHandles.lookup().findStaticVarHandle(VarHandleTest.class, "test", String.class);
        varHandle.getAndSet("There you go!");
        System.out.println(test);
        Object o = varHandle.get();
        System.out.println(o);
    }
}
