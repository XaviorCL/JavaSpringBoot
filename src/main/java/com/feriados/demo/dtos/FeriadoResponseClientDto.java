package com.feriados.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FeriadoResponseClientDto {
    List<FeriadoDto> feriadoDtoList;
}
