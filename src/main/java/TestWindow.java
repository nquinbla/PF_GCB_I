import javax.swing.*;
import java.awt.*;

public class TestWindow extends JFrame {

    public TestWindow() {
        setTitle("Test Window");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Create a JComboBox
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);

        // Customize the JComboBox
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBorder(null);

        // Position the JComboBox
        gbc.gridx = 0;
        gbc.gridy = 0; // Adjust this to position the JComboBox correctly
        panel.add(comboBox, gbc);

        add(panel);
    }

    public static void main(String[] args) {
        new TestWindow();
    }
}