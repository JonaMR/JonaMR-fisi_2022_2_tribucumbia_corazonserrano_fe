package com.example.myapplication;


import java.time.LocalDate;

public class Matricula {


    private Integer id;

    private LocalDate fecha;

    private Integer anioEscolar;

    private String estado;

    public Matricula(Integer id, LocalDate fecha, Integer anioEscolar, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.anioEscolar = anioEscolar;
        this.estado = estado;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



    public Integer getAnioEscolar() {
        return anioEscolar;
    }

    public void setAnioEscolar(Integer anioEscolar) {
        this.anioEscolar = anioEscolar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}