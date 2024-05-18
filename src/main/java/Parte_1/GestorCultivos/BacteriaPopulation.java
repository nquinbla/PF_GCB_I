package Parte_1.GestorCultivos;

import Parte_2.GestorCeldas.Cell;

import java.util.Date;

public class BacteriaPopulation {
    private String name;
    private Date startDate;
    private Date endDate;
    private Cell[][] plate;
    private double temperature;
    private String lightConditions;
    private FoodDose foodDose;

    public BacteriaPopulation() {
        this.plate = new Cell[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.plate[i][j] = new Cell(0, 0);
            }
        }
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Cell[][] getPlate() {
        return plate;
    }

    public void setPlate(Cell[][] plate) {
        this.plate = plate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getLightConditions() {
        return lightConditions;
    }

    public void setLightConditions(String lightConditions) {
        this.lightConditions = lightConditions;
    }

    public FoodDose getFoodDose() {
        return foodDose;
    }

    public void setFoodDose(FoodDose foodDose) {
        this.foodDose = foodDose;
    }

    public void setEndDate(String text) {}

    public void setStartDate(String text) {}

    public int calculatePopulationForDay(int day) {
        if (day < 0 || day > 30) {
            throw new IllegalArgumentException("El día debe estar en el rango de 0 a 30");
        }
        int totalBacteriaCount = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                totalBacteriaCount += this.plate[i][j].getBacteriaCount();
            }
        }
        return totalBacteriaCount;
    }
}