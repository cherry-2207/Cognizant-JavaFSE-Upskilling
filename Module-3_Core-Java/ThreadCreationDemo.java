class MessagePrinter implements Runnable {
    private final String message;

    MessagePrinter(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " " + i);
        }
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new MessagePrinter("Hello from first thread"), "Thread-1");
        Thread secondThread = new Thread(new MessagePrinter("Hello from second thread"), "Thread-2");

        firstThread.start();
        secondThread.start();
    }
}
