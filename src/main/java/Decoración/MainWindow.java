package Decoración;

import javax.swing.*;

public class MainWindow extends JFrame {


    public MainWindow() {


        setTitle("Gestor de Experimentos");


        setSize(1000, 600);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        createComponents();

        // Hace visible la ventana
        setVisible(true);
    }

    private void createComponents() {

    }
    //main para ejecutar mientras :)
    public static void main(String[] args) {
        new MainWindow();
    }
}
