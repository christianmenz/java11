package ch.christianmenz.java11.flightrecorder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JFRMain {

    public static void main(String[] args) {
        System.out.println("Just make something");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                System.out.println("Ich mach ja.. " + Thread.currentThread().getName());

                // Yeah!
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            });
        }
    }
}
