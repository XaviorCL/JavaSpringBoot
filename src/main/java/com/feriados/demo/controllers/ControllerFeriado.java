package com.feriados.demo.controllers;

import com.feriados.demo.dtos.FeriadoDto;
import com.feriados.demo.services.FeriadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/api/") sirve para anteponer algun palabra de convencion
public class ControllerFeriado {

    @Autowired
    FeriadosService feriadosService;

    @GetMapping(value = "/feriados/{year}/{month}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FeriadoDto>> getFeriados(@PathVariable(name = "year") long year,
                                                        @PathVariable(name = "month") long month){
        return ResponseEntity.status(HttpStatus.OK).body(feriadosService.getFeriados(year,month));
    }

    @GetMapping(value = "/feriados/{year}/{month}/{day}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FeriadoDto>> getFeriado(@PathVariable(name = "year") long year,
                                                       @PathVariable(name = "month") long month,
                                                       @PathVariable(name = "day") long day) {

        return ResponseEntity.status(HttpStatus.OK).body(feriadosService.getFeriado(year,month,day));
    }

}
