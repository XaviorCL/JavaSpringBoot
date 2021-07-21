package com.feriados.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/api/") sirve para anteponer algun palabra de convencion
public class ControllerFeriado {
    @GetMapping(value = "/feriado/{nombre}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getFeriados(@PathVariable String nombre){
        String value = nombre;
        return ResponseEntity.status(HttpStatus.OK).body("Hello "+ value);

    }

}
