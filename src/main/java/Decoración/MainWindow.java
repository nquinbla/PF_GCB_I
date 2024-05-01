package Decoración;

import javax.swing.*;

public class MainWindow extends JFrame {


    public MainWindow() {


        setTitle("Gestor de Experimentos: Cultivos de Bacillus subtilis");


        setSize(1000, 600);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        createComponents();

        setLocationRelativeTo(null);

        // Hace visible la ventana
        setVisible(true);
    }


    private void createComponents() {
        JButton userButton = new JButton("Usuario");
        JButton passwordButton = new JButton("Contraseña");




        add(passwordButton);
        add(userButton);
    }

    //main para ejecutar mientras :)
    public static void main(String[] args) {
        new MainWindow();
    }
}
