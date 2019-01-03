package ch.christianmenz.java11.stracktraverse;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        StackWalker instance = StackWalker.getInstance(Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE));

        instance.walk(stackFrameStream -> {
            List<StackWalker.StackFrame> collect = stackFrameStream.collect(Collectors.toList());
            System.out.println(collect);
            return null;
        });

        // Who is calling?
        Class<?> callerClass = instance.getCallerClass();
        System.out.println(callerClass);
    }
}
