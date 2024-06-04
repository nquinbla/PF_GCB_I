package Parte_2;

import Parte_1.GestorCultivos.BacteriaPopulation;

import java.util.HashMap;
import java.util.Map;

public class BacteriaPopulationManager {
    private static BacteriaPopulationManager instance;
    private Map<String, BacteriaPopulation> bacteriaPopulations;

    private BacteriaPopulationManager() {
        bacteriaPopulations = new HashMap<>();
    }

    public static BacteriaPopulationManager getInstance() {
        if (instance == null) {
            instance = new BacteriaPopulationManager();
        }
        return instance;
    }

    public Map<String, BacteriaPopulation> getBacteriaPopulations() {
        return bacteriaPopulations;
    }
}