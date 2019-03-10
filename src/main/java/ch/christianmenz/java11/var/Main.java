package ch.christianmenz.java11.var;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var strings = new ArrayList<>();
        strings.add("Hello World");
        for (var string : strings) { // List<Object> not List<String> ....
            //System.out.println(string.replace("World", "Java 11")); // cannot find symbol 'replace'
        }

        var strings2 = new ArrayList<String>();
        strings2.add("Hello World");
        for (var string : strings2) {
            System.out.println(string.replace("World", "Java 11"));
        }
    }
}
