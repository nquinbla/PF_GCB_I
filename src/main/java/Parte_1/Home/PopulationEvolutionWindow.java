package Parte_1.Home;

import Parte_1.GestorCultivos.BacteriaPopulation;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PopulationEvolutionWindow extends JFrame {
    private BacteriaPopulation bacteriaPopulation;
    private JTextArea populationAttributesArea;

    public PopulationEvolutionWindow(BacteriaPopulation bacteriaPopulation) {
        this.bacteriaPopulation = bacteriaPopulation;
        this.populationAttributesArea = new JTextArea();

        setTitle("Evolución de la Población");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createComponents();
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Crear un JComboBox con los números del 1 al 30
        Integer[] days = IntStream.rangeClosed(1, 30).boxed().toArray(Integer[]::new);
        JComboBox<Integer> daySelector = new JComboBox<>(days);

        JLabel populationLabel = new JLabel();

        daySelector.addActionListener(e -> {
            // Obtener el día seleccionado
            int selectedDay = (int) daySelector.getSelectedItem();

            // Calcular la población de bacterias para el día seleccionado
            int population = bacteriaPopulation.calculatePopulationForDay(selectedDay);

            // Mostrar la población de bacterias
            populationLabel.setText("La población de bacterias para el día " + selectedDay + " es " + population);
        });

        JButton endExperimentButton = new JButton("Finalizar Experimento");
        endExperimentButton.addActionListener(e -> {
            this.dispose();
            Map<String, BacteriaPopulation> bacteriaPopulations = new HashMap<>();
            // Aquí puedes añadir poblaciones de bacterias a bacteriaPopulations
            // Por ejemplo:
            // bacteriaPopulations.put("Population1", new BacteriaPopulation());
            // bacteriaPopulations.put("Population2", new BacteriaPopulation());
            new ExperimentWindow(bacteriaPopulations).setVisible(true);
        });

        mainPanel.add(daySelector);
        mainPanel.add(populationLabel);
        mainPanel.add(endExperimentButton);

        add(mainPanel);
    }
}