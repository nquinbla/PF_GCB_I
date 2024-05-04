package Home;

import GestorCultivos.BacteriaPopulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
            backgroundImageIcon = new ImageIcon("src/main/resources/fondo-laboratorio2.jpg");
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

        JButton createPopulationButton = new JButton("Crear Población"); // botón para crear una nueva población
        createPopulationButton.addActionListener(e -> {
            String populationName = JOptionPane.showInputDialog(this, "Introduce el nombre de la nueva población:");
            if (populationName != null && !populationName.trim().isEmpty()) {
                if (bacteriaPopulations.containsKey(populationName)) {
                    JOptionPane.showMessageDialog(this, "Ya existe una población con ese nombre. Por favor, elige otro nombre.");
                } else {
                    BacteriaPopulation newPopulation = new BacteriaPopulation();
                    bacteriaPopulations.put(populationName, newPopulation);
                    JOptionPane.showMessageDialog(this, "Población '" + populationName + "' creada con éxito.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nombre de la población no puede estar vacío.");
            }
        });

        JButton viewPopulationButton = new JButton("Visualizar Población");
        // viewPopulationButton.addActionListener(...); // Configura la acción aquí

        JButton deletePopulationButton = new JButton("Borrar Población");
        // deletePopulationButton.addActionListener(...); // Configura la acción aquí

        JButton infoPopulationButton = new JButton("Ver Info Población");
        // infoPopulationButton.addActionListener(...); // Configura la acción aquí

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