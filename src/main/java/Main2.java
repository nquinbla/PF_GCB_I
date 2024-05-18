import Parte_1.Home.ApplicationWindow;

import javax.swing.*;

public class Main2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new ApplicationWindow();
            frame.setVisible(true);
        });
    }
}