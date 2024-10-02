package com.example.demospringmultithreading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/print-numbers")
    public String printNumbers() {

        DataFile dataFile=new DataFile();

        // Call the service method to print numbers asynchronously
        numberService.printNumbers(dataFile.getData());
        return "Started printing numbers asynchronously with ExecutorService!";
    }
}