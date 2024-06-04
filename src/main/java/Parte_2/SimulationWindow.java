package Parte_2;

import javax.swing.*;
import java.awt.*;

public class SimulationWindow extends JFrame {
    private MontecarloSimulación simulation;

    public SimulationWindow(MontecarloSimulación simulation) {
        this.simulation = simulation;
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int[][] bacteriaPopulation = simulation.getBacteriaPopulation();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int bacteriaCount = bacteriaPopulation[i][j];
                g.setColor(getColor(bacteriaCount));
                g.fillRect(i * 30, j * 30, 30, 30);
            }
        }
    }

    private Color getColor(int bacteriaCount) {
        if (bacteriaCount >= 20) return Color.RED;
        if (bacteriaCount >= 15) return Color.MAGENTA;
        if (bacteriaCount >= 10) return Color.ORANGE;
        if (bacteriaCount >= 5) return Color.YELLOW;
        if (bacteriaCount >= 1) return Color.GREEN;
        return Color.WHITE;
    }
}

