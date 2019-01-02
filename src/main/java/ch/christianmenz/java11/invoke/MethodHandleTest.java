package ch.christianmenz.java11.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

    public static String test(String s) {
        System.out.println(s);
        return "ok";
    }

    public static void main(String[] args) throws Throwable {
        // Similar to reflection, seems to be worth taking a further look according to what I read on the internet...
        MethodHandle methodHandle = MethodHandles.lookup().findStatic(MethodHandleTest.class, "test", MethodType.methodType(String.class, String.class));
        methodHandle.invoke("Hello World");
    }
}
