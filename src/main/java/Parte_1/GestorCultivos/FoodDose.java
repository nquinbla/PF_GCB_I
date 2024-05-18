package Parte_1.GestorCultivos;

public class FoodDose {
    private static final int MAX_FOOD_AMOUNT = 300000;
    private int initialFoodAmount;
    private int increaseUntilDay;
    private int foodAmountOnIncreaseDay;
    private int finalFoodAmount;
    private int currentDay = 0;

    public FoodDose() {
        this.initialFoodAmount = 0;
        this.increaseUntilDay = 0;
        this.foodAmountOnIncreaseDay = 0;
        this.finalFoodAmount = 0;
    }

    public FoodDose(String foodDose) {
        String[] foodDoseParts = foodDose.split(",");
        this.initialFoodAmount = Integer.parseInt(foodDoseParts[0]);
        this.increaseUntilDay = Integer.parseInt(foodDoseParts[1]);
        this.foodAmountOnIncreaseDay = Integer.parseInt(foodDoseParts[2]);
        this.finalFoodAmount = Integer.parseInt(foodDoseParts[3]);
    }

    public FoodDose(int initialFoodAmount, int increaseUntilDay, int foodAmountOnIncreaseDay, int finalFoodAmount) {
        this.initialFoodAmount = initialFoodAmount;
        this.increaseUntilDay = increaseUntilDay;
        this.foodAmountOnIncreaseDay = foodAmountOnIncreaseDay;
        this.finalFoodAmount = finalFoodAmount;
    }

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