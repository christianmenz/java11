package ch.christianmenz.java11.phaser;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {
    public static void main(String[] args) {
        // should support similar stuff as count down latch and cyclic barrier
        Phaser phaser = new Phaser(1);

        // try cyclic barrier stuff (self not participating)
        phaser.bulkRegister(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List.of(1, 2, 3, 4, 5).forEach(integer -> {
            executorService.submit(() -> {
                System.out.println(integer);
                phaser.arriveAndDeregister();
            });
        });

        phaser.arriveAndAwaitAdvance();
        System.out.println("Baby");

        // countdown latch example

        System.out.println("Phase " + phaser.getPhase());
        System.out.println("--- ");

        List.of(1, 2, 3, 4, 5, 6).forEach(i -> {
            executorService.submit(() -> {
                phaser.awaitAdvance(1);
                System.out.println(i);

            });
        });

        System.out.println("Reaaaaaaaaady, go!");
        phaser.arrive();
        executorService.shutdown();
    }
}
