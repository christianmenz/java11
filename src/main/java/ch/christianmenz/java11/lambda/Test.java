package ch.christianmenz.java11.lambda;

import java.util.function.DoubleBinaryOperator;

public class Test {

    public static void main(String[] args) {
        var i = new Test(); // var since Java 10

        //var divide = (int x, int y) -> x / y; // doesn't work and probably never will..
        DoubleBinaryOperator divide = (var x, var y) -> x / y; // new style
        DoubleBinaryOperator divideOld = (x, y) -> x / y; // old style
        double r = divide.applyAsDouble(1, 3);
        System.out.println("Result " + r);
    }
}
