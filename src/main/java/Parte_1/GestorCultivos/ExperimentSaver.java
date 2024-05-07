package Parte_1.GestorCultivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExperimentSaver {
    public static void save(Experiment experiment, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        List<BacteriaPopulation> populations = experiment.getPopulations();

        for (BacteriaPopulation population : populations) {
            String name = population.getName();
            String startDate = population.getStartDate().toString(); // Necesitarás convertir la fecha a una cadena
            String endDate = population.getEndDate().toString(); // Necesitarás convertir la fecha a una cadena
            String initialBacteriaCount = String.valueOf(population.getInitialBacteriaCount());
            String temperature = String.valueOf(population.getTemperature());
            String lightConditions = population.getLightConditions();
            FoodDose foodDose = population.getFoodDose(); // Necesitarás convertir el objeto FoodDose a una cadena

            printWriter.println(name + "," + startDate + "," + endDate + "," + initialBacteriaCount + "," + temperature + "," + lightConditions + "," + foodDose);
        }

        printWriter.close();
    }
}