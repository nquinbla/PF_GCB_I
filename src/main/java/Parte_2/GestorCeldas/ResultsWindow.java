package Parte_2.GestorCeldas;

import javax.swing.*;
import java.awt.*;

public class ResultsWindow extends JFrame {
    private Cell[][] cells;
    private int day;

    public ResultsWindow(Cell[][] cells, int day) {
        this.cells = cells;
        this.day = day;

        setTitle("Results for Day " + day);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createComponents();
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(cells.length, cells[0].length));

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                JPanel cellPanel = new JPanel();
                int bacteriaCount = cells[i][j].getBacteriaCount();
                if (bacteriaCount >= 20) {
                    cellPanel.setBackground(Color.RED);
                } else if (bacteriaCount >= 15) {
                    cellPanel.setBackground(Color.MAGENTA);
                } else if (bacteriaCount >= 10) {
                    cellPanel.setBackground(Color.ORANGE);
                } else if (bacteriaCount >= 5) {
                    cellPanel.setBackground(Color.YELLOW);
                } else if (bacteriaCount >= 1) {
                    cellPanel.setBackground(Color.GREEN);
                } else {
                    cellPanel.setBackground(Color.WHITE);
                }
                mainPanel.add(cellPanel);
            }
        }

        add(mainPanel);
    }
}