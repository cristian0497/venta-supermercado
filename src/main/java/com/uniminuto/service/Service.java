package com.uniminuto.service;

import com.uniminuto.Mocks.Mocks;
import com.uniminuto.models.Cliente;
import com.uniminuto.models.Compra;
import com.uniminuto.models.Oferta;
import com.uniminuto.models.Producto;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Service {
    Mocks dbMock = new Mocks();
    Scanner input = new Scanner(System.in);

    /**
     * método encargado de crear una nueva orden de compra
     * por un cliente
     * @return boolean menu principal
     */
    public Compra nuevaCompra( Cliente cliente) {
        Compra nuevaCompra = new Compra();
        nuevaCompra.setCliente( cliente );
        return nuevaCompra;
    }

    /**
     * método encargado de agregar un nuevo producto para poder ser
     * adquirido por un cliente
     * @return boolean menú principal
     */
    public boolean agregarProducto() {
        Producto producto = new Producto();
        producto.setId( dbMock.productos.size() + 1 );

        producto.setNombre( input.nextLine() );
        producto.setPrecio( Integer.parseInt(input.nextLine()) );

        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaModificacion( LocalDateTime.now() );

        dbMock.productos.add( producto );
        return true;
    }

    /**
     * método encargado de agregar una nueva oferta que se aplicará a uno o
     * varios productos disponibles en el supermercado
     * @return boolean meno principal
     */
    public boolean agregarOferta() {
        Oferta oferta = new Oferta();

        oferta.setId( dbMock.ofertas.size() + 1 );
        oferta.setOferta( input.nextLine() );
        oferta.setPorcentaje( Integer.parseInt(input.nextLine()) );
        oferta.setFechaCreacion( LocalDateTime.now() );
        oferta.setFechaModificacion( LocalDateTime.now() );

        dbMock.ofertas.add( oferta );
        return true;
    }

}
