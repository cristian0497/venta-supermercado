package com.uniminuto;

import com.uniminuto.view.MainView;
import javax.swing.JFrame;

/**
 * Clase principal encargada de direccionar al usuario por entre las diferentes
 * opciones disponibles
 */
public class Main extends JFrame {

    public static void main(String[] args) {
        MainView view = new MainView();
        view.setVisible(true);
    }
}