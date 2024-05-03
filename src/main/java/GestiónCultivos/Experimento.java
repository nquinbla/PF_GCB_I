package GestiónCultivos;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Experimento {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<PoblaciónBacteria> población;

    public Experimento(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.población = new ArrayList<>();
    }

    public void añadirPoblación(PoblaciónBacteria población) {
        this.población.add(población);
    }

    public void eliminarPoblación(PoblaciónBacteria población) {
        this.población.remove(población);
    }

}
