package Home;

import javax.swing.*;
import java.awt.*;

public class Window_Home extends JFrame {

    public Window_Home() {
        setTitle("Gestor de Experimentos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Título y subtítulo
        JLabel titleLabel = new JLabel("Gestor de Experimentos", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        JLabel subtitleLabel = new JLabel("Laboratorios biologicos UAX", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Botones
        JButton experimentButton = new JButton("Experimento");
        experimentButton.addActionListener(e -> new ExperimentWindow().setVisible(true));

        JButton bacteriaButton = new JButton("Poblaciones Bacterianas");
        bacteriaButton.addActionListener(e -> new PopulationWindow().setVisible(true));

        // Botones de icono
        JButton iconButton1 = new JButton();
        // iconButton1.setIcon(...); // Configura el icono aquí
        JButton iconButton2 = new JButton();
        // iconButton2.setIcon(...); // Configura el icono aquí

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        mainPanel.add(subtitleLabel, gbc);

        gbc.gridy = 2;
        mainPanel.add(experimentButton, gbc);

        gbc.gridy = 3;
        mainPanel.add(bacteriaButton, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        mainPanel.add(iconButton1, gbc);

        gbc.gridy = 1;
        mainPanel.add(iconButton2, gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        new Window_Home();
    }
}