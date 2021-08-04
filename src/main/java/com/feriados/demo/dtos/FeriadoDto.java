package com.feriados.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeriadoDto {

    private String nombre;
    private String comentarios;
    private String fecha;
    private String irrenunciable;
    private String tipo;

}
