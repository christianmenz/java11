package ch.christianmenz.java11.lambda;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.LongConsumer;

public class ParameterAnnotationTest {

    public static void main(@Demo String[] args) {
        // Access parameter annotation
        Method method = new Object() {
        }.getClass().getEnclosingMethod();
        System.out.println(method);
        Annotation[][] annotations = method.getParameterAnnotations();
        System.out.println(annotations[0][0]);


        // Can I access parameter annotation inside a lambda? Nope :(
        // But with Java 11 I can use var in combination with annotations.
        // Not sure if there is a way to access the annotation though
        LongConsumer printLong = (@Demo var x) -> {
            Method method2 = new Object() {}.getClass().getEnclosingMethod();
            System.out.println(method2);
            Annotation[][] annotations2 = method2.getParameterAnnotations();
            System.out.println(annotations2[0][0]);
            System.out.println(x);
        };

        printLong.accept(1l);
    }
}
