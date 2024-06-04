package Parte_2;

import Parte_1.GestorCultivos.BacteriaPopulation;

import java.util.ArrayList;
import java.util.List;

public class SharedData {
    private static List<BacteriaPopulation> populations = new ArrayList<>();

    public static void addPopulation(BacteriaPopulation population) {
        populations.add(population);
    }

    public static List<BacteriaPopulation> getPopulations() {
        return populations;
    }
}
