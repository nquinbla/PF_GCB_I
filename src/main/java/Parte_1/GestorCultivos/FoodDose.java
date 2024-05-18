package Parte_1.GestorCultivos;

import Parte_2.GestorCeldas.Cell;

public class FoodDose {
    private int initialFoodAmount;
    private int increaseUntilDay;
    private int foodAmountOnIncreaseDay;
    private int finalFoodAmount;
    private int currentDay = 0;

    // getters and setters
    public int getInitialFoodAmount() {
        return initialFoodAmount;
    }

    public void setInitialFoodAmount(int initialFoodAmount) {
        this.initialFoodAmount = initialFoodAmount;
    }

    public int getIncreaseUntilDay() {
        return increaseUntilDay;
    }

    public void setIncreaseUntilDay(int increaseUntilDay) {
        this.increaseUntilDay = increaseUntilDay;
    }

    public int getFoodAmountOnIncreaseDay() {
        return foodAmountOnIncreaseDay;
    }

    public void setFoodAmountOnIncreaseDay(int foodAmountOnIncreaseDay) {
        this.foodAmountOnIncreaseDay = foodAmountOnIncreaseDay;
    }

    public int getFinalFoodAmount() {
        return finalFoodAmount;
    }

    public void setFinalFoodAmount(int finalFoodAmount) {
        this.finalFoodAmount = finalFoodAmount;
    }

    public void distributeFood(BacteriaPopulation population) {
        Cell[][] plate = population.getPlate();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                plate[i][j].setFoodAmount(this.initialFoodAmount);
            }
        }
    }

    public int getNextDose() {
        currentDay++;
        if (currentDay <= increaseUntilDay) {
            return initialFoodAmount + (foodAmountOnIncreaseDay - initialFoodAmount) * currentDay / increaseUntilDay;
        } else {
            return foodAmountOnIncreaseDay + (finalFoodAmount - foodAmountOnIncreaseDay) * (currentDay - increaseUntilDay) / (100 - increaseUntilDay);
        }
    }

    public void setConstantDose(int dose) {
        this.initialFoodAmount = dose;
        this.increaseUntilDay = 0;
        this.foodAmountOnIncreaseDay = dose;
        this.finalFoodAmount = dose;
    }

    public void setLinearIncreasingDose(int initialDose, int finalDose) {
        this.initialFoodAmount = initialDose;
        this.increaseUntilDay = 100;
        this.foodAmountOnIncreaseDay = finalDose;
        this.finalFoodAmount = finalDose;
    }

    public void setAlternatingDose(int dose) {
        this.initialFoodAmount = (currentDay % 2 == 0) ? dose : 0;
        this.increaseUntilDay = 0;
        this.foodAmountOnIncreaseDay = this.initialFoodAmount;
        this.finalFoodAmount = this.initialFoodAmount;
    }
}