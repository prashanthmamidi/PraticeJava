package com.concurrent.api;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

//https://dzone.com/articles/executorcompletionservice
public class ExecutorCompletionServiceDemo {
    public static void main(String[] args) {
        final List<String> topSites = Arrays.asList(
            "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com",
            "www.wikipedia.org", "www.baidu.com", "www.microsoft.com", "www.qq.com",
            "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com",
            "www.youku.com", "www.soso.com", "www.wordpress.com", "www.sohu.com",
            "www.windows.com", "www.163.com", "www.tudou.com", "www.amazon.com"
        );

        final ExecutorService pool = Executors.newFixedThreadPool(5);
        final ExecutorCompletionService<String> completionService = new ExecutorCompletionService(pool); // Executor + BlockingQueue

        topSites.stream()
            .forEach(site -> {
                    completionService.submit(() -> new URL("http://" + site).toString().toUpperCase());
                }
            );

        IntStream.rangeClosed(1, topSites.size())
            .forEach(element -> {
                    try {
                        Future<String> future = completionService.take();
                        final String content = future.get();
                        System.out.println("content = " + content);
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            );

       pool.shutdown();

    }
}
