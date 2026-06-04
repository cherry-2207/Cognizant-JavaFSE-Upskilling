import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = List.of(
                () -> "Task 1 result",
                () -> "Task 2 result",
                () -> "Task 3 result"
        );

        try {
            List<Future<String>> futures = new ArrayList<>();

            for (Callable<String> task : tasks) {
                futures.add(executorService.submit(task));
            }

            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (Exception e) {
            System.out.println("Executor error: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
