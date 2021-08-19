package com.feriados.demo.services;

import com.feriados.demo.dtos.FeriadoDto;

import java.util.List;

public interface FeriadosService {
    //Metodos sin implementación

// creacion de firma

    List<FeriadoDto> getFeriados(long year, long month);
    List<FeriadoDto> getFeriado(long year, long month,long day);
}
