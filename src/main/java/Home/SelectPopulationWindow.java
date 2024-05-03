package Home;

import javax.swing.*;
import java.awt.*;

public class SelectPopulationWindow extends JFrame {

    public SelectPopulationWindow() {
        setTitle("Select Population");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Etiqueta
        JLabel selectLabel = new JLabel("Selecciona la población bacteriana:");
        selectLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // JComboBox
        // Aquí debes llenar el JComboBox con las poblaciones bacterianas existentes
        String[] populations = {"Población 1", "Población 2", "Población 3"};
        JComboBox<String> populationComboBox = new JComboBox<>(populations);

        // Botón
        JButton selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(e -> {
            // Aquí puedes implementar la lógica para usar la población bacteriana seleccionada en el experimento
            String selectedPopulation = (String) populationComboBox.getSelectedItem();
            System.out.println("Población seleccionada: " + selectedPopulation);
            this.dispose();
        });

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(selectLabel, gbc);

        gbc.gridy = 1;
        mainPanel.add(populationComboBox, gbc);

        gbc.gridy = 2;
        mainPanel.add(selectButton, gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        new SelectPopulationWindow();
    }
}