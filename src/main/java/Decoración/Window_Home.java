package Decoración;

import javax.swing.JFrame;

public class Window_Home extends JFrame {

    public Window_Home() {
        setTitle("Home");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Window_Home().setVisible(true);
    }
}