package GestorCultivos;

import java.util.HashMap;
import java.util.Map;

public class PopulationManager {
    private static PopulationManager instance;
    private Map<String, BacteriaPopulation> populations;

    private PopulationManager() {
        populations = new HashMap<>();
    }

    public static PopulationManager getInstance() {
        if (instance == null) {
            instance = new PopulationManager();
        }
        return instance;
    }

    public Map<String, BacteriaPopulation> getPopulations() {
        return populations;
    }
}