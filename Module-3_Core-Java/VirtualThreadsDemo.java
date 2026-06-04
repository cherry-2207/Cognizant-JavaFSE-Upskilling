import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        int taskCount = 100_000;
        List<Thread> threads = new ArrayList<>();
        Instant start = Instant.now();

        for (int i = 1; i <= taskCount; i++) {
            final int taskNumber = i;
            Thread thread = Thread.startVirtualThread(() ->
                    System.out.println("Virtual thread message from task " + taskNumber)
            );
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long virtualTime = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Virtual threads completed in " + virtualTime + " ms.");
        System.out.println("Traditional platform threads are heavier and should be tested with a smaller count.");
    }
}
