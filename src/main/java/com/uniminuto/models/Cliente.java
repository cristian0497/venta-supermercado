package com.uniminuto.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Cliente {
    private Integer id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String nombre;
    private String telefono;
    private String email;
    private String documento;

}
