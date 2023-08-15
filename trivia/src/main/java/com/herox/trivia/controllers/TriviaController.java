package com.herox.trivia.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class TriviaController {
    @GetMapping("/holamundo")
    public String prueba1() {
        String nuez = "HOla de nuez";
        return nuez;
    }

    @GetMapping("/time")
    public String index() {

        return "hora: " + LocalTime.now();
    }

    @GetMapping("/saluditos-{nuez}")
    public String prueba3(String nuez) {
        nuez = "HOla de nuez";
        return nuez;
    }

}
