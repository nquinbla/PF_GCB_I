package GestiónCultivos;

public class PoblaciónBacteria {
    private String nombre;
    private int fechaInicio;
    private int fechaFin;
    private int poblaciónInicial;
    private int temperatura;
    private String luminosidad;
    private DosisComida foodDose;

    public PoblaciónBacteria(String nombre, int fechaInicio, int fechaFin, int poblaciónInicial, int temperatura, String luminosidad, DosisComida foodDose) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.poblaciónInicial = poblaciónInicial;
        this.temperatura = temperatura;
        this.luminosidad = luminosidad;
        this.foodDose = foodDose;
    }

    @ Override
    public String toString() {
        return nombre;
    }
}
