package Parte_1.Home;

import Parte_1.GestorCultivos.BacteriaPopulation;
import java.util.HashMap;
import java.util.Map;

public class SharedData {
    private static Map<String, BacteriaPopulation> bacteriaPopulations = new HashMap<>();

    public static Map<String, BacteriaPopulation> getBacteriaPopulations() {
        return bacteriaPopulations;
    }
}