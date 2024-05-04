package Home;

import GestorCultivos.BacteriaPopulation;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class PopulationEvolutionWindow extends JFrame {
    private BacteriaPopulation bacteriaPopulation;

    public PopulationEvolutionWindow(BacteriaPopulation bacteriaPopulation) {
        this.bacteriaPopulation = bacteriaPopulation;

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

        mainPanel.add(daySelector);
        mainPanel.add(populationLabel);

        add(mainPanel);
    }
}