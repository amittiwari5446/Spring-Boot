package com.example.multithreadingwithsynchronizationdemo.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaturalNumberRepository {

    private List<Integer> numbers;

    // Constructor to initialize the list with the first 1000 natural numbers
    public NaturalNumberRepository() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
