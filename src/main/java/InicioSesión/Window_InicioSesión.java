package InicioSesión;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Decoración.Window_Home;

public class Window_InicioSesión extends JFrame {

    private JTextField userField;
    private JPasswordField passwordField;
    private JLabel userIcon;
    private JLabel passwordIcon;

    public Window_InicioSesión() {
        setTitle("Gestor de Experimentos: Cultivos de Bacillus subtilis");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 0, 10, 0);

        // Título y subtítulo
        JLabel titleLabel = new JLabel("Gestión de Cultivo de Bacillus subtillis", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel subtitleLabel = new JLabel("Experiments del laboratorio biologico de la uax", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userField = new JTextField(10);
        userIcon = new JLabel();

        // Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField(10);
        passwordIcon = new JLabel();

        // botón icono usuario
        JButton usuario = new JButton();
        usuario.addActionListener(new UsuarioButtonAction());
        ImageIcon icon1 = new ImageIcon("src/main/resources/icono-usuario.png");
        Image img1 = icon1.getImage();
        Image resizedImg1 = img1.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        usuario.setIcon(new ImageIcon(resizedImg1));
        usuario.setBorderPainted(false);
        usuario.setContentAreaFilled(false);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(usuario, BorderLayout.LINE_END);

        mainPanel.add(titleLabel, BorderLayout.PAGE_START);
        mainPanel.add(subtitleLabel, BorderLayout.LINE_START);
        mainPanel.add(buttonPanel, BorderLayout.LINE_END);
        mainPanel.add(panel, BorderLayout.CENTER);

        add(mainPanel);

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
                    ImageIcon icon = new ImageIcon("src/main/resources/icono-check.png");
                    Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                    userIcon.setIcon(new ImageIcon(image));
                } catch (Exception ex) {
                    ImageIcon icon = new ImageIcon("src/main/resources/icono-cross.png");
                    Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                    userIcon.setIcon(new ImageIcon(image));
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
                    Contraseña contraseña = new Contraseña(new String(passwordField.getPassword()));
                    ImageIcon icon = new ImageIcon("src/main/resources/icono-check.png");
                    Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                    passwordIcon.setIcon(new ImageIcon(image));
                } catch (Exception ex) {
                    ImageIcon icon = new ImageIcon("src/main/resources/icono-cross.png");
                    Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                    passwordIcon.setIcon(new ImageIcon(image));
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
                    Contraseña contraseña = new Contraseña(new String(passwordField.getPassword()));
                    Window_InicioSesión.this.dispose();
                    new Window_Home().setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 2;
        panel.add(userIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 2;
        panel.add(passwordIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        panel.add(submitButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;


    }

    public static void main(String[] args) {
        new Window_InicioSesión();
    }
}