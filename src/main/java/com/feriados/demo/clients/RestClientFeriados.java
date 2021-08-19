package com.feriados.demo.clients;


import com.feriados.demo.dtos.FeriadoDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RestClientFeriados {

    Mono<FeriadoDto[]> getFeriadosFilterYearAndMonth(long year, long month);
    Mono<FeriadoDto[]> getFeriadoFilterYearMonthAndDay(long year, long month, long day);

}
