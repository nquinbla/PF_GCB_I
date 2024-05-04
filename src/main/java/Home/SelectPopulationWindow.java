package Home;

import GestorCultivos.BacteriaPopulation;
import GestorCultivos.Experiment;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Vector;

public class SelectPopulationWindow extends JFrame {
    private JComboBox<String> populationBox;
    private Map<String, BacteriaPopulation> bacteriaPopulations;

    public SelectPopulationWindow(Map<String, BacteriaPopulation> bacteriaPopulations) {
        this.bacteriaPopulations = bacteriaPopulations;
        this.populationBox = new JComboBox<>(new Vector<>(bacteriaPopulations.keySet()));

        setTitle("Seleccionar Población");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un botón para confirmar la selección
        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(e -> {
            String selectedPopulationName = (String) populationBox.getSelectedItem();
            if (selectedPopulationName != null) {
                BacteriaPopulation selectedPopulation = bacteriaPopulations.get(selectedPopulationName);
                if (selectedPopulation != null) {
                    Experiment experiment = new Experiment();
                    experiment.addPopulation(selectedPopulation);
                    JOptionPane.showMessageDialog(this, "Experimento creado con éxito.");
                    new PopulationEvolutionWindow(selectedPopulation).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "La población bacteriana seleccionada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna población bacteriana.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Añadir el JComboBox y el botón al panel de la ventana
        JPanel panel = new JPanel();
        panel.add(populationBox);
        panel.add(confirmButton);
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            updatePopulationBox();
        }
    }

    private void updatePopulationBox() {
        // Limpiar el JComboBox
        populationBox.removeAllItems();

        // Añadir las poblaciones bacterianas al JComboBox
        for (String populationName : SharedData.getBacteriaPopulations().keySet()) {
            populationBox.addItem(populationName);
        }
    }
}