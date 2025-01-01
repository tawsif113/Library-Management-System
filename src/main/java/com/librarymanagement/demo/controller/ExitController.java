package com.librarymanagement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExitController {
    private final ApplicationContext applicationContext;

    @Autowired
    public ExitController(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    @PostMapping("/exit")
    public String exitApplicationRequest(){
        Thread thread = new Thread(()->{
            try{
                Thread.sleep(1000);
                System.out.println("Shutting Down Application");
                System.exit(0);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });
        thread.start();
        return "Application is shutting down...";
    }
}
