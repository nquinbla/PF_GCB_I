package Parte_1.GestorCultivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ExperimentLoader {
    public static Experiment load(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        Experiment experiment = new Experiment();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            String name = parts[0];
            Date startDate = new Date(parts[1]);
            Date endDate = new Date(parts[2]);
            int initialBacteriaCount = Integer.parseInt(parts[3]);
            double temperature = Double.parseDouble(parts[4]);
            String lightConditions = parts[5];

            BacteriaPopulation population = new BacteriaPopulation();
            population.setName(name);
            population.setStartDate(startDate);
            population.setEndDate(endDate);
            population.setInitialBacteriaCount(initialBacteriaCount);
            population.setTemperature(temperature);
            population.setLightConditions(lightConditions);

            experiment.addPopulation(population);
        }

        scanner.close();

        return experiment;
    }
}