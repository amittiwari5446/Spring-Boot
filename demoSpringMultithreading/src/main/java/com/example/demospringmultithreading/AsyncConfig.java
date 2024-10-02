package com.example.demospringmultithreading;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncConfig {

    @Bean(name="taskExecuter")
    public Executor taskExecuter(){
        ThreadPoolTaskExecutor executer=new ThreadPoolTaskExecutor();
        executer.setCorePoolSize(10);
        executer.setMaxPoolSize(20);
        executer.setQueueCapacity(500);
        executer.setThreadNamePrefix("AsyncThread- ");
        executer.initialize();
        return executer;
    }
}
