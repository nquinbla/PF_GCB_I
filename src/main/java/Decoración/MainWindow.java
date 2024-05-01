package Decoración;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import InicioSesión.Usuario;
import InicioSesión.Contraseña;

public class MainWindow extends JFrame {

    private JTextField userField;
    private JTextField passwordField;
    private JLabel userIcon;
    private JLabel passwordIcon;

    public MainWindow() {
        setTitle("Gestor de Experimentos: Cultivos de Bacillus subtilis");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userField = new JTextField(10);
        userIcon = new JLabel();

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JTextField(10);
        passwordIcon = new JLabel();

        userField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                validate();
            }
            public void removeUpdate(DocumentEvent e) {
                validate();
            }
            public void insertUpdate(DocumentEvent e) {
                validate();
            }

            public void validate() {
                try {
                    Usuario usuario = new Usuario(userField.getText());
                    userIcon.setIcon(new ImageIcon("src/main/resources/icono-check.png"));
                } catch (Exception ex) {
                    userIcon.setIcon(new ImageIcon("src/main/resources/icono-cross.png"));
                }
            }
        });

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                validate();
            }
            public void removeUpdate(DocumentEvent e) {
                validate();
            }
            public void insertUpdate(DocumentEvent e) {
                validate();
            }

            public void validate() {
                try {
                    Contraseña contraseña = new Contraseña(passwordField.getText());
                    passwordIcon.setIcon(new ImageIcon("src/main/resources/icono-check.png"));
                } catch (Exception ex) {
                    passwordIcon.setIcon(new ImageIcon("src/main/resources/icono-cross.png"));
                }
            }
        });

        JButton submitButton = new JButton("Iniciar sesión");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario usuario = new Usuario(userField.getText());
                    Contraseña contraseña = new Contraseña(passwordField.getText());
                    // Aquí puedes hacer algo con los objetos usuario y contraseña
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 2;
        panel.add(userIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 2;
        panel.add(passwordIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(submitButton, gbc);

        add(panel);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}