package Parte_2.GestorCeldas;

import java.util.Random;

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

    public void simulateDay() {
        Random random = new Random();
        for (int i = 0; i < bacteriaCount; i++) {
            for (int j = 0; j < 10; j++) { // repeat 10 times a day
                if (foodAmount >= 100) {
                    foodAmount -= 20;
                    int randomNumber = random.nextInt(100);
                    if (randomNumber < 3) {
                        bacteriaCount--;
                    } else if (randomNumber >= 60) {
                        moveBacteria();
                    }
                } else if (foodAmount >= 10) {
                    foodAmount -= 10;
                    int randomNumber = random.nextInt(100);
                    if (randomNumber < 6) {
                        bacteriaCount--;
                    } else if (randomNumber >= 20) {
                        moveBacteria();
                    }
                } else {
                    int randomNumber = random.nextInt(100);
                    if (randomNumber < 20) {
                        bacteriaCount--;
                    } else if (randomNumber >= 60) {
                        moveBacteria();
                    }
                }
            }
        }
    }

    private void moveBacteria() {
        // Implement logic to move bacteria to an adjacent cell
        // This will depend on how you have structured your cells and may require access to the parent plate
    }
}