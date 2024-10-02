package com.example.demospringmultithreading;

import java.util.ArrayList;
import java.util.List;

public class DataFile {
    public List<Integer> getData(){
        List<Integer> data=new ArrayList<>();
        for(int i=1;i<10001;i++)  data.add(i);
        return  data;
    }
}
