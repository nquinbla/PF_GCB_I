package GestorCultivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ExperimentWindow extends JFrame {
    private Experiment currentExperiment;

    public ExperimentWindow() {
        setTitle("Gestor de Cultivos de Bacterias");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear menú
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar");
        JMenuItem saveAsItem = new JMenuItem("Guardar como");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Crear panel de control
        JPanel controlPanel = new JPanel();
        JButton addButton = new JButton("Añadir población");
        JButton removeButton = new JButton("Eliminar población");
        controlPanel.add(addButton);
        controlPanel.add(removeButton);
        add(controlPanel, BorderLayout.SOUTH);

        // Crear lista de poblaciones
        JList<BacteriaPopulation> populationList = new JList<>();
        add(new JScrollPane(populationList), BorderLayout.CENTER);

        // Acciones de los botones
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    currentExperiment = ExperimentLoader.load("experiment.txt");
                    populationList.setListData(currentExperiment.getPopulations().toArray(new BacteriaPopulation[0]));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ExperimentSaver.save(currentExperiment, "experiment.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(ExperimentWindow.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        ExperimentSaver.save(currentExperiment, fileChooser.getSelectedFile().getAbsolutePath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Crear un formulario para recoger la información de la nueva población
                JTextField nameField = new JTextField();
                JTextField startDateField = new JTextField();
                JTextField endDateField = new JTextField();
                JTextField initialBacteriaCountField = new JTextField();
                JTextField temperatureField = new JTextField();
                JTextField lightConditionsField = new JTextField();

                Object[] fields = {
                        "Nombre:", nameField,
                        "Fecha de inicio:", startDateField,
                        "Fecha de fin:", endDateField,
                        "Conteo inicial de bacterias:", initialBacteriaCountField,
                        "Temperatura:", temperatureField,
                        "Condiciones de luz:", lightConditionsField,
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Añadir población", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    // Crear un nuevo objeto BacteriaPopulation con la información del formulario
                    BacteriaPopulation population = new BacteriaPopulation();
                    population.setName(nameField.getText());
                    population.setStartDate(startDateField.getText());
                    population.setEndDate(endDateField.getText());
                    population.setInitialBacteriaCount(Integer.parseInt(initialBacteriaCountField.getText()));
                    population.setTemperature(Double.parseDouble(temperatureField.getText()));
                    population.setLightConditions(lightConditionsField.getText());

                    // Añadir la nueva población al experimento actual
                    currentExperiment.addPopulation(population);

                    // Actualizar la lista de poblaciones en la interfaz de usuario
                    populationList.setListData(currentExperiment.getPopulations().toArray(new BacteriaPopulation[0]));
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la población seleccionada
                BacteriaPopulation selectedPopulation = populationList.getSelectedValue();

                if (selectedPopulation != null) {
                    // Eliminar la población seleccionada del experimento actual
                    currentExperiment.removePopulation(selectedPopulation);

                    // Actualizar la lista de poblaciones en la interfaz de usuario
                    populationList.setListData(currentExperiment.getPopulations().toArray(new BacteriaPopulation[0]));
                } else {
                    // Mostrar un mensaje si no se seleccionó ninguna población
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una población para eliminar.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExperimentWindow().setVisible(true);
            }
        });
    }
}