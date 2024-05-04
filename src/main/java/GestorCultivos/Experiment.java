package GestorCultivos;

import java.util.ArrayList;
import java.util.List;

public class Experiment {
    private List<BacteriaPopulation> populations;
    private BacteriaPopulation population;

    public Experiment(BacteriaPopulation population) {
        this.population = population;
    }

    public Experiment() {
        this.populations = new ArrayList<>();
    }

    public void addPopulation(BacteriaPopulation population) {
        this.populations.add(population);
    }

    public void removePopulation(BacteriaPopulation population) {
        this.populations.remove(population);
    }

    public List<BacteriaPopulation> getPopulations() {
        return this.populations;
    }
}