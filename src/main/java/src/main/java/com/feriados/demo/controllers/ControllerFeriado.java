package src.main.java.com.feriados.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class ControllerFeriado {

    @GetMapping(value = "/feriado", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getFeriados(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello Miguel");

    }

}
