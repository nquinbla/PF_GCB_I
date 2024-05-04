package Home;

import GestorCultivos.BacteriaPopulation;
import GestorCultivos.Experiment;
import GestorCultivos.PopulationManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExperimentWindow extends JFrame {

    public ExperimentWindow() {
        setTitle("Gestor de Experimentos: Experimento");
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
                    ExperimentWindow.this.dispose();
                }
            }
        });
        createComponents();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        // Crear un JLabel para el fondo
        JLabel background = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(new ImageIcon("src/main/resources/fondo-laboratorio1.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        background.setLayout(new GridBagLayout());

        // Título
        JLabel titleLabel = new JLabel("Experimentos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(Color.WHITE);

        // Subtítulo
        JLabel subtitleLabel = new JLabel("Con bacterias");
        subtitleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        subtitleLabel.setForeground(Color.LIGHT_GRAY);

        // Botones
        JButton openExperimentButton = new JButton("Abrir Experimento"); // Botón para abrir un experimento
        openExperimentButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.addChoosableFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName();
                String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

                if (!fileExtension.equalsIgnoreCase("txt")) {
                    JOptionPane.showMessageDialog(this, "Solo se permiten archivos .txt", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        Desktop.getDesktop().open(selectedFile);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        JButton createExperimentButton = new JButton("Crear Experimento"); // Botón para crear un experimento
        createExperimentButton.addActionListener(e -> {
            // Obtener las poblaciones creadas
            Map<String, BacteriaPopulation> bacteriaPopulations = PopulationManager.getInstance().getPopulations();

            if (bacteriaPopulations.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay poblaciones creadas.");
            } else {
                // Convertir las claves del mapa a una lista y ordenarla
                List<String> populationNames = new ArrayList<>(bacteriaPopulations.keySet());
                Collections.sort(populationNames);

                // Crear un JComboBox con los nombres de las poblaciones
                JComboBox<String> populationBox = new JComboBox<>(populationNames.toArray(new String[0]));

                int result = JOptionPane.showConfirmDialog(null, populationBox, "Selecciona la población para el experimento",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String selectedPopulation = (String) populationBox.getSelectedItem();
                    BacteriaPopulation population = bacteriaPopulations.get(selectedPopulation);

                    Experiment experiment = new Experiment(population);
                    experiment.addPopulation(population);
                    JOptionPane.showMessageDialog(this, "Experimento creado con éxito.");
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

        // Añadir los títulos al JLabel de fondo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        background.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 10, 0);
        background.add(subtitleLabel, gbc);

        // Añadir los botones
        gbc.gridy = 2;
        background.add(openExperimentButton, gbc);

        gbc.gridy = 3;
        background.add(createExperimentButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 0, 10, 0);
        background.add(homeButton, gbc);

        // Añadir el JLabel de fondo al JFrame
        add(background);
    }

    // Método main para probar la ventana
    public static void main(String[] args) {
        new ExperimentWindow().setVisible(true);
    }
}