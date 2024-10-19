package com.uniminuto.Mocks;

import com.uniminuto.models.Cliente;
import com.uniminuto.models.Compra;
import com.uniminuto.models.Oferta;
import com.uniminuto.models.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * clase pública que simula una base de datos.
 */
public class Mocks {
    public List<Oferta> ofertas = new ArrayList<>();
    public List<Producto> productos = new ArrayList<>();
    public List<Compra> compras = new ArrayList<>();
    public List<Cliente> clientes = new ArrayList<>();

    public Mocks() {
        ofertas.add( new Oferta(1, "50% descuento", 50));
        ofertas.add( new Oferta(2, "10% descuento carnes", 10));
        productos.add( new Producto(1, "Arroz 200g", 10000, null));
        productos.add( new Producto(2, "Aceite x600ml", 10000, ofertas.get(1)));
        productos.add( new Producto(3, "Carne x1k", 10000, null));
        productos.add( new Producto(4, "Leche deslactosada 1L", 10000, null));
        productos.add( new Producto(5, "Lentejas 600g", 10000, null));
        productos.add( new Producto(6, "Galletas Noel", 10000, ofertas.get(0)));
    }
}
