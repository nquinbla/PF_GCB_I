package Parte_1.InicioSesión;

public class Contraseña {
    private String contraseña;

    public Contraseña(String contraseña) throws Exception {
        if (contraseña.length() <= 6 || contraseña.length() > 12) {
            throw new Exception("Contraseña incorrecta. Debe tener entre 7 y 12 caracteres.");
        }
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }
}