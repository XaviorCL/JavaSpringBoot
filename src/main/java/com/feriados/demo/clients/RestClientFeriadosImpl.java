package com.feriados.demo.clients;

import com.feriados.demo.dtos.FeriadoDto;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.List;

@Component
public class RestClientFeriadosImpl implements RestClientFeriados{

    @Override
    public Mono<FeriadoDto[]> getFeriadosFilterYearAndMonth(long year, long month) {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.digital.gob.cl/fl")
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create().followRedirect(true)))
                .build();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                .path("/feriados/{year}/{month}")
                .build(year,month))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FeriadoDto[].class);
    }

    @Override
    public Mono<FeriadoDto[]> getFeriadoFilterYearMonthAndDay(long year, long month, long day) {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.digital.gob.cl/fl")
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create().followRedirect(true)))
                .build();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                .path("/feriados/{year}/{month}/{day}")
                .build(year,month,day))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FeriadoDto[].class);
    }
}


