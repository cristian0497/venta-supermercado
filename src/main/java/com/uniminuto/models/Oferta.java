package com.uniminuto.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
public class Oferta implements Serializable {
    private Integer id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String oferta;
    private Integer porcentaje;

    public Oferta(Integer id, String oferta, Integer porcentaje) {
        this.id = id;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
        this.oferta = oferta;
        this.porcentaje = porcentaje;
    }

    public Oferta( ) { }
}
