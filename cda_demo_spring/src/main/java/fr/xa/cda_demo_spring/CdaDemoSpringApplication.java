package fr.xa.cda_demo_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CdaDemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdaDemoSpringApplication.class, args);
        System.out.println("L'app à bien démarrée !");
    }
}

