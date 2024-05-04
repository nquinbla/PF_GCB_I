package GestorCultivos;

public class FoodDose {
    private int initialFoodAmount;
    private int increaseUntilDay;
    private int foodAmountOnIncreaseDay;
    private int finalFoodAmount;

    public FoodDose(String foodDose) {
        String[] foodDoseParts = foodDose.split(",");
        this.initialFoodAmount = Integer.parseInt(foodDoseParts[0]);
        this.increaseUntilDay = Integer.parseInt(foodDoseParts[1]);
        this.foodAmountOnIncreaseDay = Integer.parseInt(foodDoseParts[2]);
        this.finalFoodAmount = Integer.parseInt(foodDoseParts[3]);
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

}