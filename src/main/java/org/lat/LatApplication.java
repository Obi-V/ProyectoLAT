package org.lat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LatApplication {

    public static void main(String[] args) {

        System.out.println("asdasd");

        System.out.println(args[1]);

        SpringApplication.run(LatApplication.class, args);
    }

}
