package com.redfish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    private static ApplicationContext applicationContext = null;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class,args);
    }

    @GetMapping("/")
    public String serverTest(){
        return "Dev hello";
    }


}