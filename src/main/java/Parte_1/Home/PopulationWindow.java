package Parte_1.Home;

import Parte_1.GestorCultivos.BacteriaPopulation;
import Parte_1.GestorCultivos.FoodDose;
import Parte_1.GestorCultivos.PopulationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PopulationWindow extends JFrame {

    // Mapa para almacenar las poblaciones de bacterias
    private Map<String, BacteriaPopulation> bacteriaPopulations = new HashMap<>();

    public PopulationWindow() {
        setTitle("Gestor de Experimentos: Población Bacteriana");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "¿Estás seguro que quieres cerrar esta ventana?",
                        "Confirmación", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    PopulationWindow.this.dispose();
                }
            }
        });
        createComponents();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        // Crear un JLayeredPane para permitir la superposición de componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 400));

        // Crear un JLabel para la imagen de fondo
        ImageIcon backgroundImageIcon;
        try {
            backgroundImageIcon = new ImageIcon("src/main/resources/fondo-laboratorio4.jpg");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Image backgroundImage = backgroundImageIcon.getImage();
        Image newBackgroundImage = backgroundImage.getScaledInstance(800, 400, Image.SCALE_SMOOTH);
        backgroundImageIcon = new ImageIcon(newBackgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 800, 400);

        // Añadir la imagen de fondo al JLayeredPane
        layeredPane.add(backgroundLabel, Integer.valueOf(1));

        // Crear el panel principal y añadirlo al JLayeredPane
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBounds(0, 0, 800, 400);
        layeredPane.add(mainPanel, Integer.valueOf(2));

        GridBagConstraints gbc = new GridBagConstraints();

        // Título
        JLabel titleLabel = new JLabel("Población Bacteriana", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titleLabel, gbc);

        // Botones

        JButton createPopulationButton = new JButton("Crear Población");
        createPopulationButton.addActionListener(e -> {
            // Crear panel con campos de texto
            JPanel panel = new JPanel(new GridLayout(0, 1));
            JTextField nameField = new JTextField();
            JTextField startDateField = new JTextField();
            JTextField endDateField = new JTextField();
            JTextField initialCountField = new JTextField();
            JTextField temperatureField = new JTextField();
            JComboBox<String> lightConditionsBox = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});
            JButton foodDoseButton = new JButton("Configurar Dosis de Alimento");
            FoodDose[] foodDose = new FoodDose[1];

            foodDoseButton.addActionListener(e1 -> {
                JTextField initialFoodAmountField = new JTextField();
                JTextField increaseUntilDayField = new JTextField();
                JTextField foodAmountOnIncreaseDayField = new JTextField();
                JTextField finalFoodAmountField = new JTextField();

                JPanel foodDosePanel = new JPanel(new GridLayout(0, 1));
                foodDosePanel.add(new JLabel("Cantidad inicial de alimento:"));
                foodDosePanel.add(initialFoodAmountField);
                foodDosePanel.add(new JLabel("Aumentar hasta el día:"));
                foodDosePanel.add(increaseUntilDayField);
                foodDosePanel.add(new JLabel("Cantidad de alimento en el día de aumento:"));
                foodDosePanel.add(foodAmountOnIncreaseDayField);
                foodDosePanel.add(new JLabel("Cantidad final de alimento:"));
                foodDosePanel.add(finalFoodAmountField);

                int result = JOptionPane.showConfirmDialog(null, foodDosePanel, "Configurar Dosis de Alimento",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    int initialFoodAmount = Integer.parseInt(initialFoodAmountField.getText());
                    int increaseUntilDay = Integer.parseInt(increaseUntilDayField.getText());
                    int foodAmountOnIncreaseDay = Integer.parseInt(foodAmountOnIncreaseDayField.getText());
                    int finalFoodAmount = Integer.parseInt(finalFoodAmountField.getText());

                    foodDose[0] = new FoodDose(initialFoodAmount, increaseUntilDay, foodAmountOnIncreaseDay, finalFoodAmount);
                }
            });

            panel.add(new JLabel("Nombre de la especie:"));
            panel.add(nameField);
            panel.add(new JLabel("Fecha de inicio (dd/MM/yyyy):"));
            panel.add(startDateField);
            panel.add(new JLabel("Fecha de fin (dd/MM/yyyy):"));
            panel.add(endDateField);
            panel.add(new JLabel("Conteo inicial de bacterias:"));
            panel.add(initialCountField);
            panel.add(new JLabel("Temperatura (Cº):"));
            panel.add(temperatureField);
            panel.add(new JLabel("Condiciones de luz:"));
            panel.add(lightConditionsBox);
            panel.add(foodDoseButton);

            int result = JOptionPane.showConfirmDialog(null, panel, "Introduce los datos de la población",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                String startDate = startDateField.getText();
                String endDate = endDateField.getText();
                int initialCount = Integer.parseInt(initialCountField.getText());
                double temperature = Double.parseDouble(temperatureField.getText());
                String lightConditions = (String) lightConditionsBox.getSelectedItem();

                if (foodDose[0] == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, configura la dosis de alimento.");
                    return;
                }

                BacteriaPopulation newPopulation = new BacteriaPopulation();
                SharedData.getBacteriaPopulations().put("Nueva Población", newPopulation);
                newPopulation.setName(name);
                newPopulation.setStartDate(startDate);
                newPopulation.setEndDate(endDate);
                newPopulation.setInitialBacteriaCount(initialCount);
                newPopulation.setTemperature(temperature);
                newPopulation.setLightConditions(lightConditions);
                newPopulation.setFoodDose(foodDose[0]);

                PopulationManager.getInstance().getPopulations().put(newPopulation.getName(), newPopulation);
                bacteriaPopulations.put(name, newPopulation);
                JOptionPane.showMessageDialog(this, "Población '" + name + "' creada con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "Creación de población cancelada.");
            }
        });

        JButton viewPopulationButton = new JButton("Visualizar Población");
        viewPopulationButton.addActionListener(e -> {
            if (bacteriaPopulations.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay poblaciones creadas.");
            } else {
                // Convertir las claves del mapa a una lista y ordenarla
                List<String> populationNames = new ArrayList<>(bacteriaPopulations.keySet());
                Collections.sort(populationNames);

                // Crear la lista de nombres de poblaciones
                StringBuilder populationsList = new StringBuilder();
                for (String name : populationNames) {
                    populationsList.append(name).append("\n");
                }

                JOptionPane.showMessageDialog(this, "Poblaciones creadas:\n" + populationsList.toString());
            }
        });

        JButton deletePopulationButton = new JButton("Borrar Población");
        deletePopulationButton.addActionListener(e -> {
            if (bacteriaPopulations.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay poblaciones creadas.");
            } else {
                // Convertir las claves del mapa a una lista y ordenarla
                List<String> populationNames = new ArrayList<>(bacteriaPopulations.keySet());
                Collections.sort(populationNames);

                // Crear un JComboBox con los nombres de las poblaciones
                JComboBox<String> populationBox = new JComboBox<>(populationNames.toArray(new String[0]));

                int result = JOptionPane.showConfirmDialog(null, populationBox, "Selecciona la población a eliminar",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String selectedPopulation = (String) populationBox.getSelectedItem();
                    bacteriaPopulations.remove(selectedPopulation);
                    JOptionPane.showMessageDialog(this, "Población '" + selectedPopulation + "' eliminada con éxito.");
                }
            }
        });

        JButton infoPopulationButton = new JButton("Ver Info Población"); // Botón para ver la información de una población
        infoPopulationButton.addActionListener(e -> {
            String populationName = JOptionPane.showInputDialog(this, "Introduce el nombre de la población:");
            if (populationName != null) {
                BacteriaPopulation population = bacteriaPopulations.get(populationName);
                if (population != null) {
                    FoodDose foodDose = population.getFoodDose();
                    String message = String.format(
                            "Nombre de la especie: %s\n" +
                                    "Fecha de inicio: %s\n" +
                                    "Fecha de fin: %s\n" +
                                    "Conteo inicial de bacterias: %d\n" +
                                    "Temperatura: %.2f\n" +
                                    "Condiciones de luz: %s\n" +
                                    "Dosis de alimento:\n" +
                                    "  - Cantidad inicial de alimento: %d\n" +
                                    "  - Aumentar hasta el día: %d\n" +
                                    "  - Cantidad de alimento en el día de aumento: %d\n" +
                                    "  - Cantidad final de alimento: %d",
                            population.getName(),
                            population.getStartDate(),
                            population.getEndDate(),
                            population.getInitialBacteriaCount(),
                            population.getTemperature(),
                            population.getLightConditions(),
                            foodDose.getInitialFoodAmount(),
                            foodDose.getIncreaseUntilDay(),
                            foodDose.getFoodAmountOnIncreaseDay(),
                            foodDose.getFinalFoodAmount()
                    );
                    JOptionPane.showMessageDialog(this, message);
                } else {
                    JOptionPane.showMessageDialog(this, "Población '" + populationName + "' no encontrada.");
                }
            }
        });

        // Botón de icono
        JButton homeButton = new JButton();
        try {
            ImageIcon homeIcon = new ImageIcon(getClass().getResource("/icono-home.png"));
            Image homeImage = homeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            homeButton.setIcon(new ImageIcon(homeImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
        homeButton.addActionListener(e -> new Window_Home().setVisible(true));

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        mainPanel.add(createPopulationButton, gbc);

        gbc.gridy = 2;
        mainPanel.add(viewPopulationButton, gbc);

        gbc.gridy = 3;
        mainPanel.add(deletePopulationButton, gbc);

        gbc.gridy = 4;
        mainPanel.add(infoPopulationButton, gbc);

        gbc.gridy = 5;
        mainPanel.add(homeButton, gbc);

        setContentPane(layeredPane);
    }

    public static void main(String[] args) {
        new PopulationWindow().setVisible(true);
    }
}