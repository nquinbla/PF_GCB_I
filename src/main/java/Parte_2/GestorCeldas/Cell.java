package Parte_2.GestorCeldas;

public class Cell {
    private int bacteriaCount;
    private int foodAmount;

    public Cell(int bacteriaCount, int foodAmount) {
        this.bacteriaCount = bacteriaCount;
        this.foodAmount = foodAmount;
    }

    public int getBacteriaCount() {
        return bacteriaCount;
    }

    public void setBacteriaCount(int bacteriaCount) {
        this.bacteriaCount = bacteriaCount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }
}