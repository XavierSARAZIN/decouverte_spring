package fr.xa.cda_demo_spring.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;


@RestController
public class HelloController {
    @GetMapping({"/", "/hello"})
    public String sayConfirm() {
        return "<h1>Le serveur fonctionne mais il n'y a rien à afficher ici !</h1>";
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
