package edu.sias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "edu.sias")
public class CampusLostApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusLostApplication.class, args);
    }

}