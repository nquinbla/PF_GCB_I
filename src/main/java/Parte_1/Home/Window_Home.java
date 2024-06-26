package Parte_1.Home;

import Parte_1.GestorCultivos.BacteriaPopulation;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.EmptyBorder;

public class Window_Home extends JFrame {

    private String usuario;
    private String contraseña;

    public void setCredentials(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Window_Home() {
        setTitle("Gestor de Experimentos: Home");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {

        // Crear un JLayeredPane para permitir la superposición de componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1000, 500));

        // Crear un JLabel para la imagen de fondo
        ImageIcon backgroundImageIcon;
        try {
            backgroundImageIcon = new ImageIcon("src/main/resources/fondo-laboratorio2.jpg");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Image backgroundImage = backgroundImageIcon.getImage();
        Image newBackgroundImage = backgroundImage.getScaledInstance(1000, 500, Image.SCALE_SMOOTH);
        backgroundImageIcon = new ImageIcon(newBackgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 500);

        // Añadir la imagen de fondo al JLayeredPane
        layeredPane.add(backgroundLabel, Integer.valueOf(1));

        // Crear el panel principal y añadirlo al JLayeredPane
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBounds(0, 0, 1000, 500);
        layeredPane.add(mainPanel, Integer.valueOf(2));

        GridBagConstraints gbc = new GridBagConstraints();

        // Título y subtítulo
        JLabel titleLabel = new JLabel("Gestor de Experimentos", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel("<html><body>Laboratorios biologicos <font color='blue'>UAX</font></body></html>", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        subtitleLabel.setForeground(Color.BLACK);

        // Botones
        JButton experimentButton = new JButton("Experimento");
        experimentButton.addActionListener(e -> {
            Map<String, BacteriaPopulation> bacteriaPopulations = new HashMap<>();
            new ExperimentWindow(bacteriaPopulations).setVisible(true);
        });

        JButton bacteriaButton = new JButton("Poblaciones Bacterianas");
        bacteriaButton.addActionListener(e -> new PopulationWindow().setVisible(true));

        // Botones de icono
        JButton iconButton1 = new JButton();
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/icono-home.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconButton1.setIcon(new ImageIcon(image1));
        iconButton1.addActionListener(e -> new Window_Home().setVisible(true));

        JButton iconButton2 = new JButton();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/icono-usuario.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconButton2.setIcon(new ImageIcon(image2));
        iconButton2.addActionListener(e -> JOptionPane.showMessageDialog(this, "Usuario: " + usuario + "\nContraseña: " + contraseña));

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(110, 0, 10, 0);
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        mainPanel.add(subtitleLabel, gbc);

        gbc.gridy = 2;
        mainPanel.add(experimentButton, gbc);

        gbc.gridy = 3;
        mainPanel.add(bacteriaButton, gbc);

        gbc.gridy = 4;
        mainPanel.add(iconButton1, gbc);

        gbc.gridy = 5;
        mainPanel.add(iconButton2, gbc);

        mainPanel.setBorder(new EmptyBorder(20, 0, 100, 0));

        setContentPane(layeredPane);
    }

    public static void main(String[] args) {
        new Window_Home();
    }
}