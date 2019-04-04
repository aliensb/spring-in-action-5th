package win.ccav.tacmal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    private static int MAX_t=3;
    private static final ExecutorService pool= Executors.newFixedThreadPool(MAX_t);

    public static void main(String[] args) {
        pool.execute(new Task("task 1"));
        pool.execute(new Task("task 2"));
        pool.execute(new Task("task 3"));
        pool.execute(new Task("task 4"));
        pool.execute(new Task("task 5"));
        pool.execute(new Task("task 6"));
        pool.execute(new Task("task 7"));
        pool.execute(new Task("task 8"));
        pool.execute(new Task("task 9"));
        pool.execute(new Task("task 0"));
        pool.shutdown();
    }
}
