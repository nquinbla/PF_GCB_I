package Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PopulationWindow extends JFrame {

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
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Botones
        JButton createPopulationButton = new JButton("Crear Población");
        // createPopulationButton.addActionListener(...); // Configura la acción aquí

        JButton viewPopulationButton = new JButton("Visualizar Población");
        // viewPopulationButton.addActionListener(...); // Configura la acción aquí

        JButton deletePopulationButton = new JButton("Borrar Población");
        // deletePopulationButton.addActionListener(...); // Configura la acción aquí

        JButton infoPopulationButton = new JButton("Ver Info Población");
        // infoPopulationButton.addActionListener(...); // Configura la acción aquí

        // Botón de icono
        JButton homeButton = new JButton();
        // homeButton.setIcon(...); // Configura el icono aquí
        homeButton.addActionListener(e -> new Window_Home().setVisible(true));

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(createPopulationButton, gbc);

        gbc.gridy = 1;
        mainPanel.add(viewPopulationButton, gbc);

        gbc.gridy = 2;
        mainPanel.add(deletePopulationButton, gbc);

        gbc.gridy = 3;
        mainPanel.add(infoPopulationButton, gbc);

        gbc.gridy = 4;
        mainPanel.add(homeButton, gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        new PopulationWindow().setVisible(true);
    }
}
