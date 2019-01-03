package ch.christianmenz.java11.flowable;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowableMain {

    public static void main(String[] args) {

        SubmissionPublisher publisher = new SubmissionPublisher();
        publisher.subscribe(new Flow.Subscriber() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(Object item) {
                System.out.println(Thread.currentThread());
                System.out.println("Got an item " + item);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error! :(");
            }

            @Override
            public void onComplete() {
                System.out.println("Okay thanks");
            }
        });

        // async
        List.of(1, 2, 3, 4, 5).forEach(publisher::submit);
        publisher.close();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        System.out.println("Baby!");
    }
}
