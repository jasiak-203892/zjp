package com.app.zjp.restservice;

import com.app.zjp.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        Logger.getInstance().log("Starting application");
        SpringApplication.run(Application.class, args);
        Logger.getInstance().log("Applicaiton should now be running");
    }
}
