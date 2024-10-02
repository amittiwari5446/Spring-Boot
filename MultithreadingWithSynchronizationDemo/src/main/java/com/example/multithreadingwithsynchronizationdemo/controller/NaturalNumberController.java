package com.example.multithreadingwithsynchronizationdemo.controller;

import com.example.multithreadingwithsynchronizationdemo.service.MultithreadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaturalNumberController {

    @Autowired
    private MultithreadingService multithreadingService;

    @GetMapping("/print-numbers/{count}")
    public String printNumbers(@PathVariable int count) {
        // Use 5 threads to print the numbers
        multithreadingService.printNumbersWithThreads(count);
        return "Printing numbers with multithreading...";
    }
}
