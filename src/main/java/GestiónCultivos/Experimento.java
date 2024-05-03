package GestiónCultivos;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Experimento {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<poblaciónBacteria> población;

    public Experimento(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.población = new ArrayList<>();
    }

    public void añadirPoblación(poblaciónBacteria población) {
        this.población.add(población);
    }

    public void eliminarPoblación(poblaciónBacteria población) {
        this.población.remove(población);
    }

}
