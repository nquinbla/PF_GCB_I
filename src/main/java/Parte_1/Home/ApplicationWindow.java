package Parte_1.Home;

import Parte_2.GestorCeldas.Cell;

import javax.swing.*;
import java.awt.*;

public class ApplicationWindow extends JFrame {
    private Cell[][] cells;
    private int day;

    public ApplicationWindow() {
        // Initialize the cells array
        this.cells = new Cell[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.cells[i][j] = new Cell(0, 0, 30); // Initialize each cell
            }
        }

        // Initialize the day
        this.day = 0;

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
                int bacteriaCount = cells[i][j].getBacteriaCountForDay(day);
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

    // Method to simulate the passage of one day
    public void simulateDay() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].simulateDay(cells, i, j, 10, day); // Simulate one day for each cell
            }
        }
        day++; // Increase the day
        createComponents(); // Update the GUI
    }
}