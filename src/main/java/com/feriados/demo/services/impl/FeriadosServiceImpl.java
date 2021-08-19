package com.feriados.demo.services.impl;

import com.feriados.demo.clients.RestClientFeriadosImpl;
import com.feriados.demo.dtos.FeriadoDto;
import com.feriados.demo.services.FeriadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FeriadosServiceImpl implements FeriadosService {

    @Autowired
    RestClientFeriadosImpl restClientFeriados;

    @Override
    public List<FeriadoDto> getFeriados(long year, long month) {
        Mono<FeriadoDto[]> feriadoDtoMono = restClientFeriados.getFeriadosFilterYearAndMonth(year,month);
        FeriadoDto[] feriadoDtoList = feriadoDtoMono.block();
        List<FeriadoDto> feriadoDtoList1 = mapFeriadoDto(feriadoDtoList);
        return feriadoDtoList1;
    }



    @Override
    public List<FeriadoDto> getFeriado(long year, long month, long day) {
        Mono<FeriadoDto[]> feriadoDtoMono = restClientFeriados.getFeriadoFilterYearMonthAndDay(year, month, day);
        FeriadoDto[] feriadoDtoDayList = feriadoDtoMono.block();
        List<FeriadoDto> feriadoDtoDayList1 = mapFeriadoDto(feriadoDtoDayList);
        return feriadoDtoDayList1;
    }

    private List<FeriadoDto> mapFeriadoDto(FeriadoDto[] feriadoDto) {
        List<FeriadoDto> feriadoDtoList = Arrays.asList(feriadoDto);
        return feriadoDtoList;
    }

}
