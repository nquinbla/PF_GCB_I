package Parte_1.InicioSesión;

public class Usuario {
    private String nombre;

    public Usuario(String nombre) throws Exception {
        if (!nombre.matches("[a-zA-Z0-9]*") || nombre.length() > 8) {
            throw new Exception("Nombre de usuario incorrecto.");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
