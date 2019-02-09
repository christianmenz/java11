package ch.christianmenz.java11.generic;

import java.util.List;

public class GenericsExtend {

    static class A<T> {
        void apply(List<T> list) {

        }

        void set(T t) {

        }
    }

    static class B<E extends Number> extends A<E> {
    }

    public static void main(String[] args) {
        B b = new B(); // works as expected when B<Number> b....
        List<Object> l = null;
        b.apply(l); // not what I expected..
    }

}
