package Parte_1.GestorCultivos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<BacteriaPopulation> getPopulationsSortedByStartDate() {
        return populations.values().stream()
                .sorted(Comparator.comparing(BacteriaPopulation::getStartDate))
                .collect(Collectors.toList());
    }

    public List<BacteriaPopulation> getPopulationsSortedByName() {
        return populations.values().stream()
                .sorted(Comparator.comparing(BacteriaPopulation::getName))
                .collect(Collectors.toList());
    }

    public List<BacteriaPopulation> getPopulationsSortedByBacteriaCount() {
        return populations.values().stream()
                .sorted(Comparator.comparing(BacteriaPopulation::getInitialBacteriaCount))
                .collect(Collectors.toList());
    }
}