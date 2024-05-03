package GestorCultivos;

import java.util.Date;

public class BacteriaPopulation {
    private String name;
    private Date startDate;
    private Date endDate;
    private int initialBacteriaCount;
    private double temperature;
    private String lightConditions;
    private FoodDose foodDose;

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

    public int getInitialBacteriaCount() {
        return initialBacteriaCount;
    }

    public void setInitialBacteriaCount(int initialBacteriaCount) {
        this.initialBacteriaCount = initialBacteriaCount;
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

    public void setEndDate(String text) {

    }

    public void setStartDate(String text) {

    }
}