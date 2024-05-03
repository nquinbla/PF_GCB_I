package Home;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;


public class Window_Home extends JFrame {
    private String usuario;
    private String contraseña;

    public void setCredentials(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;}

    public Window_Home() {
        setTitle("Gestor de Experimentos: Home");
        setSize(1000, 500); // Cambia la altura a 500
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridBagLayout());
        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.PAGE_AXIS));
        GridBagConstraints gbc = new GridBagConstraints();

        // Título y subtítulo
        JLabel titleLabel = new JLabel("Gestor de Experimentos", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        JLabel subtitleLabel = new JLabel("<html><body>Laboratorios biologicos <font color='blue'>UAX</font></body></html>", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Botones
        JButton experimentButton = new JButton("Experimento");
        // experimentButton.setIcon(...); // Configura el icono aquí
        experimentButton.addActionListener(e -> new ExperimentWindow().setVisible(true));

        JButton bacteriaButton = new JButton("Poblaciones Bacterianas");
        // bacteriaButton.setIcon(...); // Configura el icono aquí
        bacteriaButton.addActionListener(e -> new PopulationWindow().setVisible(true));

        // Botones de icono
        JButton iconButton1 = new JButton();
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/icono-home.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconButton1.setIcon(new ImageIcon(image1));
        iconButton1.addActionListener(e -> new Window_Home().setVisible(true));

        JButton iconButton2 = new JButton();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/icono-usuario.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        iconButton2.setIcon(new ImageIcon(image2));
        iconButton2.addActionListener(e -> JOptionPane.showMessageDialog(this, "Usuario: " + usuario + "\nContraseña: " + contraseña));


        // Añadir componentes al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(110, 0, 10, 0);
        topPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        topPanel.add(subtitleLabel, gbc);

        gbc.gridy = 2;
        topPanel.add(experimentButton, gbc);

        gbc.gridy = 3;
        topPanel.add(bacteriaButton, gbc);

        iconPanel.add(iconButton1);
        iconPanel.add(iconButton2);
        iconPanel.setBorder(new EmptyBorder(20, 0, 100, 0));

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(iconPanel, BorderLayout.LINE_END);

        add(mainPanel);
    }

    public static void main(String[] args) {
        new Window_Home();
    }
}