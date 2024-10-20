package com.uniminuto.view;

import com.uniminuto.Mocks.Mocks;
import com.uniminuto.models.Cliente;
import com.uniminuto.models.Compra;
import com.uniminuto.models.Producto;
import com.uniminuto.service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class MainView extends JFrame implements ActionListener {

    final JTextArea textoNombre = new JTextArea("Nombre cliente");
    final JTextField nombreCliente;

    final JTextArea textoTelefono = new JTextArea("Teléfono");
    final JTextField telefonoCliente;

    final JTextArea textoEmail = new JTextArea("Email");
    final JTextField emailCliente;

    final JTextArea textoDocumento = new JTextArea("Documento");
    final JTextField documentoCliente;

    final JTextArea textoProductos = new JTextArea("Productos disponibles");
    final JList<Producto> products;

    final JTextArea textoProductosUsuario = new JTextArea("Tus productos");
    final JList<Producto> productosUsuario;

    JButton registrarCliente;
    JButton agregarProductos;
    JButton agregarOfertas;

    Service service;
    Mocks dbMock = new Mocks();

    public MainView() {
        service = new Service();

        this.setTitle("Caja de ventas");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        nombreCliente = new JTextField();
        telefonoCliente = new JTextField();
        emailCliente = new JTextField();
        documentoCliente = new JTextField();
        registrarCliente = new JButton("Registrar cliente");
        agregarProductos = new JButton("Agregar productos");
        agregarOfertas = new JButton("Agregar ofertas");
        products = new JList<>( );
        productosUsuario = new JList<>();

        // Info de cliente //
        textoNombre.setBounds(10, 10, 300, 15); // 25
        nombreCliente.setBounds(10, 30, 300, 30); // 60

        textoTelefono.setBounds(10, 65, 300, 15); // 80
        telefonoCliente.setBounds(10, 85, 300, 30); // 115

        textoEmail.setBounds(10, 120, 300, 15); // 135
        emailCliente.setBounds(10, 140, 300, 30); // 170

        textoDocumento.setBounds(10, 175, 300, 15); // 190
        documentoCliente.setBounds(10, 195, 300, 30); // 225

        // Botones de usuario //
        registrarCliente.setBounds(400, 10, 150, 30);
        registrarCliente.addActionListener(this);
        agregarProductos.setBounds(400, 50, 150, 30);
        agregarProductos.addActionListener(this);
        agregarOfertas.setBounds(400, 90, 150, 30);
        agregarOfertas.addActionListener(this);

        // lista productos disponibles //
        products.setVisible(false);
        products.setBounds(10, 10, 300, 500);


        this.textoNombre.setEditable(false);
        this.textoNombre.setBackground(null);
        this.add(textoNombre);
        this.add(nombreCliente);

        this.textoTelefono.setEditable(false);
        this.textoTelefono.setBackground(null);
        this.add(textoTelefono);
        this.add(telefonoCliente);

        this.textoEmail.setEditable(false);
        this.textoEmail.setBackground(null);
        this.add(textoEmail);
        this.add(emailCliente);

        this.textoDocumento.setEditable(false);
        this.textoDocumento.setBackground(null);
        this.add(textoDocumento);
        this.add(documentoCliente);

        this.add(registrarCliente);
        this.add(agregarProductos);
        this.add(agregarOfertas);
        this.add(products);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.registrarCliente) {
            try {
                Cliente cliente = createClient();
                this.nombreCliente.setVisible(false);
                this.textoNombre.setVisible(false);
                this.telefonoCliente.setVisible(false);
                this.textoTelefono.setVisible(false);
                this.emailCliente.setVisible(false);
                this.textoEmail.setVisible(false);
                this.documentoCliente.setVisible(false);
                this.textoDocumento.setVisible(false);
                this.registrarCliente.setVisible(false);
                this.agregarProductos.setVisible(false);
                this.agregarOfertas.setVisible(false);

                Compra carrito = service.nuevaCompra(cliente);
                Producto[] prods = dbMock.productos.toArray(new Producto[0] );
                products.setListData(prods);
                products.setVisible(true);

            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Datos incompletos: "+ioException.getMessage());
            }
        }
        if(e.getSource() == this.agregarProductos)
            JOptionPane.showMessageDialog(null, "registrar");
        if(e.getSource() == this.agregarOfertas)
            JOptionPane.showMessageDialog(null, "pagar");
    }

    private Cliente createClient() throws IOException {
        Cliente cliente = new Cliente();

        if(this.documentoCliente.getText().isEmpty())
            throw new IOException("Documento de cliente necesario");
        cliente.setDocumento( this.documentoCliente.getText() );

        if(this.nombreCliente.getText().isEmpty())
            throw new IOException("Nombre de cliente vacio");
        cliente.setNombre( this.nombreCliente.getText() );

        if(this.telefonoCliente.getText().isEmpty())
            throw new IOException("Teléfono de cliente vacio");
        cliente.setTelefono( this.telefonoCliente.getText() );

        if(this.emailCliente.getText().isEmpty())
            throw new IOException("Email de cliente vacio");
        cliente.setEmail( this.emailCliente.getText() );

        return cliente;
    }
}
