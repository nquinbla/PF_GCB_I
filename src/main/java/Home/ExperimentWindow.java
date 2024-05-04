package Home;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

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
        // Crear un JLabel para el fondo
        JLabel background = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(new ImageIcon("src/main/resources/fondo-laboratorio1.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        background.setLayout(new GridBagLayout());

        // Botones
        JButton openExperimentButton = new JButton("Abrir Experimento");
        openExperimentButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.addChoosableFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    Desktop.getDesktop().open(selectedFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JButton createExperimentButton = new JButton("Crear Experimento");
        createExperimentButton.addActionListener(e -> new SelectPopulationWindow().setVisible(true));

        // Botón de icono
        JButton homeButton = new JButton();
        // homeButton.setIcon(...); // Configura el icono aquí
        homeButton.addActionListener(e -> new Window_Home().setVisible(true));

        // Añadir componentes al JLabel de fondo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        background.add(openExperimentButton, gbc);

        gbc.gridy = 1;
        background.add(createExperimentButton, gbc);

        gbc.gridy = 2;
        background.add(homeButton, gbc);

        add(background);
    }

    // Método main para probar la ventana
    public static void main(String[] args) {
        new ExperimentWindow().setVisible(true);
    }
}