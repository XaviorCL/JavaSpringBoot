package com.feriados.demo.services.impl;

import com.feriados.demo.clients.RestClientFeriadosImpl;
import com.feriados.demo.dtos.FeriadoDto;
import com.feriados.demo.services.FeriadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeriadosServiceImpl implements FeriadosService {

    @Autowired
    RestClientFeriadosImpl restClientFeriados;

    @Override
    public FeriadoDto getFeriados() {

        Mono<FeriadoDto> feriadoDtoMono = restClientFeriados.getFeriadosFilterYearAndMonth();
        FeriadoDto feriadoDto = feriadoDtoMono.block();

        return feriadoDtoMono;
    }
    private List<FeriadoDto> mapFeriadoDto(FeriadoDto feriadoDto){
        List<FeriadoDto> feriadoDtoList = new ArrayList<>();
        feriadoDtoList.add(feriadoDto);
        return feriadoDtoList;
    }
}
