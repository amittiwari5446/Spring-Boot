package com.example.demospringmultithreading;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class NumberService {

    @Async("taskExecutor")
    public void printNumbers(List<Integer> numbers) {
        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Define chunk size (how many numbers each thread will process)
        int chunkSize = 1000;

        // Loop over the list of numbers in chunks of 1000 and submit tasks to the executor
        for (int i = 0; i < numbers.size(); i += chunkSize) {
            final int start = i;
            final int end = Math.min(i + chunkSize, numbers.size());

            // Submit each chunk of numbers to be processed by the executor
            executorService.submit(() -> {
                for (int j = start; j < end; j++) {
                    System.out.println(Thread.currentThread().getName() + " - " + numbers.get(j));
                }
            });
        }

        // Shutdown the executor after the tasks are done
        executorService.shutdown();
    }
}
