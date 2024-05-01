package Decoración;

import InicioSesión.Contraseña;
import InicioSesión.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Introduce tu nombre de usuario:");
                try {
                    Usuario usuario = new Usuario(nombre);
                    // Aquí puedes hacer algo con el objeto usuario
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        passwordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contraseña = JOptionPane.showInputDialog("Introduce tu contraseña:");
                try {
                    Contraseña password = new Contraseña(contraseña);
                    // Aquí puedes hacer algo con el objeto password
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        add(passwordButton);
        add(userButton);
    }

    //main para ejecutar mientras :)
    public static void main(String[] args) {
        new MainWindow();
    }
}
