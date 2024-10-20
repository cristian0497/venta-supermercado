package com.uniminuto.service;

import com.uniminuto.Mocks.Mocks;
import com.uniminuto.models.Cliente;
import com.uniminuto.models.Compra;
import com.uniminuto.models.Oferta;
import com.uniminuto.models.Producto;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import static java.lang.System.out;

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

        dbMock.productos.forEach( product ->
            out.println("id: {id} producto: {producto} precio: ${precio} oferta: {oferta}"
                    .replace("{id}", product.getId().toString())
                    .replace("{producto}", product.getNombre())
                    .replace("{precio}", product.getPrecio().toString())
                    .replace("{oferta}", Objects.isNull(product.getOferta())? "no": product.getOferta().getOferta()))
        );

        nuevaCompra.setCliente( cliente );
        out.println("\ncliente creado correctamente " +
                "\nagregar id de producto" +
                "\npress: \"q\" para salir"
        );

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

        out.println("Ingrese el nombre del producto");
        producto.setNombre( input.nextLine() );

        out.println("Ingrese el precio del producto");
        producto.setPrecio( Integer.parseInt(input.nextLine()) );

        out.println("Ingrese el id de oferta si aplica, si no presione n");
        String id = input.nextLine();
        if( !Objects.equals("n", id)) {
            Optional<Oferta> offer = dbMock.ofertas.stream()
                    .filter(o -> Objects.equals(o.getId().toString(), id))
                    .findAny();
            if(offer.isEmpty())
                out.println("Oferta: "+id+" no encontrada!");
            else
                producto.setOferta(offer.get());
        }

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

        out.println("Ingrese el nombre de la oferta");
        oferta.setOferta( input.nextLine() );

        out.println("Ingrese el valor del descuento");
        oferta.setPorcentaje( Integer.parseInt(input.nextLine()) );


        oferta.setFechaCreacion( LocalDateTime.now() );
        oferta.setFechaModificacion( LocalDateTime.now() );

        dbMock.ofertas.add( oferta );
        return true;
    }

}
