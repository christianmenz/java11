package ch.christianmenz.java11.thisptr;

public class TestThisPtr {

    void test() {
        this.test2();
    }

    // Okay, great. Now I can't read Java code anymore (in since Java 8!)
    // Only thing I can think of is annotations on the parameter..
    void test2(TestThisPtr this) {
        System.out.println("yeah " + this);
        System.out.println(this == this);
    }

    void test3(TestThisPtr this, int x) {

    }

    // The receiver parameter must be the first
    //void test4(int x, TestThisPtr this) { }

    public static void main(String[] args) {
        new TestThisPtr().test();
        new TestThisPtr().test2(); // also works
    }
}
