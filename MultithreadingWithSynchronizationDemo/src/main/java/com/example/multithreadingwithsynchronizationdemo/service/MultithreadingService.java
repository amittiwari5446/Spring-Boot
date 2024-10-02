package com.example.multithreadingwithsynchronizationdemo.service;

import com.example.multithreadingwithsynchronizationdemo.repository.NaturalNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultithreadingService {

    @Autowired
    private NaturalNumberRepository naturalNumberRepository;

    private final Object lock = new Object();  // Lock for synchronization

    public void printNumbersWithThreads(int threadCount) {
        List<Integer> numbers = naturalNumberRepository.getNumbers();
        int chunkSize = numbers.size() / threadCount;

        for (int i = 0; i < threadCount; i++) {
            final int start = i * chunkSize;
            final int end = (i == threadCount - 1) ? numbers.size() : start + chunkSize;

            Thread thread = new Thread(() -> printChunk(numbers, start, end));
            thread.start();
        }
    }

    private void printChunk(List<Integer> numbers, int start, int end) {
        synchronized (lock) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + numbers.get(i));
            }
        }
    }
}
