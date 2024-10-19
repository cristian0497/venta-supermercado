package com.uniminuto;

import com.uniminuto.service.Service;

import javax.swing.JFrame;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * Clase principal encargada de direccionar al usuario por entre las diferentes
 * opciones disponibles
 */
public class Main extends JFrame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Service service = new Service();
        boolean run = true;
        do {
            out.println("\n\nBienvenido, ingrese la opción:\n");
            out.println("1: Nueva compra");
            out.println("2: Agregar producto");
            out.println("3: Agregar oferta");
            out.println("q: Salir");

            String option = input.nextLine();

            switch (option) {
                case "1":
                    run = service.nuevaCompra();
                    break;
                case "2":
                    run = service.agregarProducto();
                    break;
                case "3":
                    run = service.agregarOferta();
                    break;
                default:
                    run = false;
                    break;
            }
        } while (run);
        out.println("Hasta Pronto");
    }
}