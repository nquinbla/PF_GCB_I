package InicioSesión;

public class Usuario {
    private String nombre;

    public Usuario(String nombre) throws Exception {
        if (!nombre.matches("[a-zA-Z0-9]*") || nombre.length() > 8) {
            throw new Exception("El nombre de usuario solo puede contener letras y números y no puede ser más largo de 8 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
