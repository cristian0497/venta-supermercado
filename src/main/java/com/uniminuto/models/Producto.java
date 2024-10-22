package com.uniminuto.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Locale;

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
        this.cantidad = 1;
    }
    public Producto() { }

    @Override
    public String toString() {
        Locale locale = new Locale("es", "CO");
        Currency cop = Currency.getInstance("COP");
        NumberFormat copFormat = NumberFormat.getNumberInstance(locale);
        copFormat.setCurrency(cop);
        return this.nombre+": $"+
                copFormat.format(this.precio)+
                ": Off: ".concat(this.oferta != null ? this.oferta.getPorcentaje().toString() : "0")+"%";

    }
}
