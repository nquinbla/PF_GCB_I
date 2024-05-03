package InicioSesión;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import Home.Window_Home;

public class Window_InicioSesión extends JFrame {

    private JTextField userField;
    private JPasswordField passwordField;
    private JLabel userIcon;
    private JLabel passwordIcon;

    public Window_InicioSesión() {
        setTitle("Gestor de Experimentos: Inicio Sesión");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        // Crear un JLayeredPane para permitir la superposición de componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 400));

        // Crear un JLabel para la imagen de fondo
        ImageIcon backgroundImageIcon = new ImageIcon("src/main/resources/fondo-iniciosesion.jpg");
        Image backgroundImage = backgroundImageIcon.getImage();

        // Escalar la imagen con alta calidad
        Image newBackgroundImage = backgroundImage.getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH);
        BufferedImage resizedImg = new BufferedImage(800, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(newBackgroundImage, 0, 0, 800, 400, null);
        g2.dispose();

        backgroundImageIcon = new ImageIcon(resizedImg);
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);
        backgroundLabel.setSize(800, 400);

        // Añadir la imagen de fondo al JLayeredPane
        layeredPane.add(backgroundLabel, Integer.valueOf(1));

        // Crear el panel principal y añadirlo al JLayeredPane
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBounds(0, 0, 800, 400);
        layeredPane.add(mainPanel, Integer.valueOf(2));

        GridBagConstraints gbc = new GridBagConstraints();

        // Imagen
        ImageIcon imageIcon = new ImageIcon("src/main/resources/iconco-iniciosesion.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120,  Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);

        // Usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setForeground(Color.WHITE);
        userField = new JTextField(10);
        userField.setText("");
        userIcon = new JLabel();

        // Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordField = new JPasswordField(10);
        passwordField.setText("");
        passwordIcon = new JLabel();

        // iconos para que cuando se escriba en los campos de texto se valide si el usuario y la contraseña son correctos
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

        // Botón de inicio de sesión
        JButton submitButton = new JButton("Iniciar sesión");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String usuario = userField.getText();
                    String contraseña = new String(passwordField.getPassword());
                    Window_InicioSesión.this.dispose();
                    Window_Home home = new Window_Home();
                    home.setCredentials(usuario, contraseña);
                    home.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        // Añadir componentes al panel principal

        // Imagen
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 0, 15, 0);
        mainPanel.add(imageLabel, gbc);

        // Etiqueta "Usuario:"
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(userLabel, gbc);

        // Campo de texto del usuario
        gbc.gridx = 1;
        mainPanel.add(userField, gbc);

        // Etiqueta "Contraseña:"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(passwordLabel, gbc);

        // Campo de texto de la contraseña
        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        //Botón de inicio de sesión
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(submitButton, gbc);

        // Añadir el JLayeredPane al JFrame
        setContentPane(layeredPane);

    }

    public static void main(String[] args) {
        new Window_InicioSesión();
    }
}