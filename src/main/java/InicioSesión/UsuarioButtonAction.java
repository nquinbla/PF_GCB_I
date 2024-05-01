package InicioSesión;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioButtonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame infoFrame = new JFrame("Información de inicio de sesión");
        infoFrame.setSize(550, 350);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String infoText = "<html><body>" +
                "<h2>Instrucciones del inicio de sesión para la aplicación de gestión de cultivos de bacterias</h2>" +
                "<p>A continuación, se presentan las normas para las contraseñas y nombres de usuario:</p>" +
                "<ul>" +
                "<li>El nombre de usuario permite introducir tanto letras, en minúsculas y mayúsculas, como números</li>" +
                "<li>El nombre de usuario no debe ser menor de 8 carácteres</li>" +
                "<li>La contraseña debe tener una longitud de entre 6 y 8 cifras</li>" +
                "</ul>" +
                "</body></html>";

        JLabel infoLabel = new JLabel(infoText);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega un margen de 10 píxeles en todas las direcciones
        mainPanel.add(infoLabel, BorderLayout.CENTER);

        infoFrame.add(mainPanel);
        infoFrame.setVisible(true);
    }
}