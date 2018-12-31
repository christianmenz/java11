package ch.christianmenz.java11.lambda;

import java.beans.BeanProperty;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.DoubleBinaryOperator;
import java.util.function.LongConsumer;

public class Test {



    public static void main(String[] args) {
        var i = new Test(); // var since Java 10

        //var divide = (int x, int y) -> x / y; // doesn't work and probably never will..
        DoubleBinaryOperator divide = (var x, var y) -> x / y; // new style
        DoubleBinaryOperator divideOld = (x, y) -> x / y; // old style
        double r = divide.applyAsDouble(1, 3);
        System.out.println("Result " + r);

        // Can I access parameter annotation inside a lambda? Nope :(
        LongConsumer printLong = (@Demo var x) -> {
            Method method = new Object() {}.getClass().getEnclosingMethod();
            System.out.println(method);
            Annotation[][] annotations = method.getParameterAnnotations();
            System.out.println(annotations[0][0]);
            System.out.println(x);
        };

        printLong.accept(50);
    }
}
