package ch.christianmenz.java11.nestmate;

import java.lang.reflect.InvocationTargetException;

public class NestMateOuch {


    public static void main(String[] args) {
        new NestMateOuch().new Inner().test();
    }

    private void outer() {
        System.out.println("Hello World");
    }

    private class Inner {
        public void test() {
            //outer();
            //NestMateOuch.this.outer();
            try {
                this.getClass().getNestHost().getDeclaredMethod("outer").invoke(NestMateOuch.this);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            // The class itself is always part of the nest.. that's why the second should
            // be what we are looking for..
            if(NestMateOuch.this.getClass().getNestMembers()[1] == Inner.class) {
                System.out.println("same, what a surprise!");
            }
        }
    }
}
