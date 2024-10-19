package com.uniminuto.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
public class Producto implements Serializable {
    private Integer id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String nombre;
    private Integer precio;
    private Oferta oferta;
    private Integer cantidad;


    public Producto(Integer id, String producto, Integer precio, Oferta oferta) {
        this.id = id;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
        this.nombre = producto;
        this.precio = precio;
        this.oferta = oferta;
    }
    public Producto() { }
}
