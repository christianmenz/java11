package ch.christianmenz.java11.trywithresources;

import java.io.IOException;
import java.io.StringReader;

/**
 * Example of ARM (automatic resource management)
 */
public class Main {

    public static void main(String[] args) {
        StringReader stringReader = new StringReader("test") {
            @Override
            public void close() {
                System.out.println("Closing...");
                super.close();
            }
        };
        try (stringReader) { // 1rst
            stringReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // 2nd
            System.out.println("My finally block");
            stringReader.close();
            System.out.println(".. interesting");
        }
    }
}
