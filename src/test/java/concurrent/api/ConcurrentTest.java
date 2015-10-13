package concurrent.api;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

/**
 * Created by mamidi on 30/08/2015.
 */
public class ConcurrentTest {

@Test
public void executorExample_runs_for_ever() throws ExecutionException, InterruptedException {
    final ExecutorService executorService = Executors.newCachedThreadPool();
    final Callable threadNamePrinter = new InfiniteThreadNamePrinter();
    System.out.println("Main thread: " + Thread.currentThread().getName());
    Future submit = executorService.submit(threadNamePrinter);
    submit.get();
}

@Test
public void  executorExample_runs_only_till_main_completes() {
    final ExecutorService executorService = Executors.newCachedThreadPool();
    final Callable threadNamePrinter = new InfiniteThreadNamePrinter();
    System.out.println("Main thread: " + Thread.currentThread().getName());
    executorService.submit(threadNamePrinter);
}

    @Test
    public void executorExample_wait_for_supporting_thread_to_complete() throws InterruptedException {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Callable threadNamePrinter = new FiniteThreadNamePrinterLatch(countDownLatch);
        System.out.println("Main thread: " + Thread.currentThread().getName());
        executorService.submit(threadNamePrinter);
        countDownLatch.await(5, TimeUnit.SECONDS);
    }

}

class InfiniteThreadNamePrinter implements Callable {
    @Override
    public Object call() throws Exception {
        while (true) {
            System.out.println("Run from thread: " + Thread.currentThread().getName());
        }
    }
}
class FiniteThreadNamePrinterLatch implements Callable {

    final CountDownLatch latch;

    FiniteThreadNamePrinterLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public Object call() throws Exception {

        for(int i=0; i<1000; i++)
            System.out.println(i + ": Run from thread: " + Thread.currentThread().getName());
        latch.countDown();
        return null;

    }
}