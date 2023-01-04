package com.example.myapplication;

import java.time.LocalDate;

public class stripe {

    private Long number;

    private Integer cvc;

    private Integer mes_expiracion;

    private Integer anio_expiracion;

    public stripe(Long number, Integer cvc, Integer mes_expiracion, Integer anio_expiracion) {
        this.number = number;
        this.cvc = cvc;
        this.mes_expiracion = mes_expiracion;
        this.anio_expiracion = anio_expiracion;
    }
}
