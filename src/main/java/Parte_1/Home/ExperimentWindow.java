package Parte_1.Home;

import Parte_1.GestorCultivos.BacteriaPopulation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ExperimentWindow extends JFrame {
    private JComboBox<String> populationBox;
    private Map<String, BacteriaPopulation> bacteriaPopulations;

    private JPanel gridPanel;
    private JButton[][] gridButtons;

    public ExperimentWindow(Map<String, BacteriaPopulation> bacteriaPopulations) {
        this.bacteriaPopulations = bacteriaPopulations;
        this.populationBox = new JComboBox<>(new Vector<>(bacteriaPopulations.keySet()));

        setTitle("Gestor de Experimentos: Experimento");
        setSize(800, 400);

        // Crear la cuadrícula de celdas
        gridPanel = new JPanel(new GridLayout(10, 10)); // Ajusta el tamaño de la cuadrícula según sea necesario
        gridPanel.setPreferredSize(new Dimension(400, 400)); // Ajusta el tamaño según sea necesario
        gridButtons = new JButton[10][10]; // Ajusta el tamaño según sea necesario
        for (int i = 0; i < 10; i++) { // Ajusta el tamaño según sea necesario
            for (int j = 0; j < 10; j++) { // Ajusta el tamaño según sea necesario
                JButton button = new JButton();
                button.setBackground(Color.WHITE); // El color inicial de las celdas
                gridPanel.add(button);
                gridButtons[i][j] = button;
            }
        }
        add(gridPanel, BorderLayout.CENTER);

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

        JButton createExperimentButton = new JButton("Crear Experimento");
        createExperimentButton.addActionListener(e -> {
            String selectedPopulationName = (String) populationBox.getSelectedItem();
            BacteriaPopulation selectedPopulation = bacteriaPopulations.get(selectedPopulationName);
            if (selectedPopulation != null) {
                // Mostrar la cuadrícula de celdas
                gridPanel.setVisible(true);
                // Iniciar el desarrollo de la población

                selectedPopulation.startDevelopment();

                // Actualizar la cuadrícula de celdas
                updateGrid(selectedPopulation);
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

        public void updateGrid(BacteriaPopulation population){
            for (int i = 0; i < 10; i++) { // Ajusta el tamaño según sea necesario
                for (int j = 0; j < 10; j++) { // Ajusta el tamaño según sea necesario
                    // Aquí necesitarías alguna forma de obtener el estado de la celda en la posición (i, j)
                    // de la población bacteriana. Esto dependerá de cómo estés representando las celdas
                    // en la población bacteriana.
                    boolean cellHasBacteria = population.getCell(i, j).hasBacteria();
                    if (cellHasBacteria) {
                        gridButtons[i][j].setBackground(Color.GREEN); // El color de las celdas con bacterias
                    } else {
                        gridButtons[i][j].setBackground(Color.WHITE); // El color de las celdas sin bacterias
                    }
                }
            }
        }
    }

    // Método main para probar la ventana
    public static void main(String[] args) {
        Map<String, BacteriaPopulation> bacteriaPopulations = new HashMap<>();
        new ExperimentWindow(bacteriaPopulations).setVisible(true);
    }
}