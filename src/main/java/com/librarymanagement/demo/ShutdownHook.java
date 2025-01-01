package com.librarymanagement.demo;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHook {

    @PreDestroy
    public void onShutdown(){
        System.out.println("Cleaning up before shutdown...");
    }
}
