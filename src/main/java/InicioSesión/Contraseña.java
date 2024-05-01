package InicioSesión;

public class Contraseña {
    private String contraseña;

    public Contraseña(String contraseña) throws Exception {
        if (contraseña.length() <= 6) {
            throw new Exception("La contraseña debe ser más larga de 6 caracteres.");
        }
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }
}
