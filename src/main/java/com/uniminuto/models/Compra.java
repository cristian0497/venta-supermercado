package com.uniminuto.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

@Getter @Setter
public class Compra {
    private Integer id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private Integer iva = 0;
    private Cliente cliente;
    private List<Producto> productos = new ArrayList<>();
    private Integer valorDescuento = 0;
    private Integer valorAPagar = 0;
    private Integer valorTotal = 0;

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        calcularTotales();
    }
    public void eliminarProducto(Producto producto) {

    }
    public void calcularTotales() {
        this.valorTotal = this.valorDescuento = this.valorAPagar = 0;
        out.println("\t\tcarrito:");
        productos.forEach( p -> {
            int discount = Objects.isNull(p.getOferta()) ? 0 : p.getOferta().getPorcentaje();
            int valueDiscount =  p.getPrecio() * discount / 100;
            out.println("\t\t{producto} x {cantidad}: ${precio} - ${descuento}"
                    .replace("{producto}", p.getNombre())
                    .replace("{cantidad}", p.getCantidad().toString())
                    .replace("{precio}", p.getPrecio().toString())
                    .replace("{descuento}", String.valueOf(  valueDiscount ))
            );
            this.valorTotal += p.getPrecio() * p.getCantidad();
            this.valorDescuento += valueDiscount * p.getCantidad();
        });
        this.valorAPagar += this.valorTotal - this.valorDescuento;
        out.println("\n\t\t*total: $"+this.valorTotal+" *total desc: $"+this.valorDescuento+" *total a pagar: $"+this.valorAPagar+"\n");
    }

    public String procesarPago() {
        return "pago OK";
    }
    public String enviarFacturaEmail() {
        return "envío OK";
    }

}
