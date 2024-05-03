package Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExperimentWindow extends JFrame {

    public ExperimentWindow() {
        setTitle("Experiment Window");
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
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Botones
        JButton openExperimentButton = new JButton("Abrir Experimento");
        // openExperimentButton.addActionListener(...); // Configura la acción aquí

        JButton createExperimentButton = new JButton("Crear Experimento");
        // createExperimentButton.addActionListener(...); // Configura la acción aquí

        // Botón de icono
        JButton homeButton = new JButton();
        // homeButton.setIcon(...); // Configura el icono aquí
        homeButton.addActionListener(e -> new Window_Home().setVisible(true));

        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(openExperimentButton, gbc);

        gbc.gridy = 1;
        mainPanel.add(createExperimentButton, gbc);

        gbc.gridy = 2;
        mainPanel.add(homeButton, gbc);

        add(mainPanel);
    }
}