package GestiónCultivos;

import java.time.LocalDate;

public interface DosisComida {
    int getCantidadInicial();
    int getCantidadMayor();
    int getCantidadMenor();
    LocalDate getIncrementoHastaFecha();
    LocalDate getDecrecimientoHastaFecha();
    int getCantidad(int day);

}
