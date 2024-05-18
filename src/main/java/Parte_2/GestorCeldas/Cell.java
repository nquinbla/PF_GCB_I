package Parte_2.GestorCeldas;

import java.util.Random;

public class Cell {
    private int bacteriaCount;
    private int foodAmount;
    private int foodConsumed;
    private int[][][] bacteriaAndFoodData; // 3D array to store the number of bacteria and remaining food per day and cell

    public Cell(int bacteriaCount, int foodAmount, int days) {
        this.bacteriaCount = bacteriaCount;
        this.foodAmount = foodAmount;
        this.bacteriaAndFoodData = new int[days][2][2]; // Initialize the 3D array
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

    public void simulateDay(Cell[][] plate, int currentX, int currentY, int foodPerCell, int day) {
        distributeFood(foodPerCell);
        Random random = new Random();
        for (int i = 0; i < bacteriaCount; i++) {
            foodConsumed = 0; // reset the food consumed for the day
            // existing code...

            // Save the number of bacteria and remaining food at the end of the day
            bacteriaAndFoodData[day][0][0] = bacteriaCount;
            bacteriaAndFoodData[day][0][1] = foodAmount;
        }
    }

    // existing methods...

    public int getBacteriaCountForDay(int day) {
        return bacteriaAndFoodData[day][0][0];
    }

    private void distributeFood(int foodPerCell) {
        this.foodAmount = foodPerCell;
    }

    private void reproduceBacteria() {
        if (foodConsumed >= 150) {
            bacteriaCount += 3;
        } else if (foodConsumed >= 100) {
            bacteriaCount += 2;
        } else if (foodConsumed >= 50) {
            bacteriaCount += 1;
        }
    }

    private void moveBacteria(Cell[][] plate, int currentX, int currentY) {
        Random random = new Random();
        int direction = random.nextInt(4); // Generate a random number between 0 and 3

        int newX = currentX;
        int newY = currentY;

        switch (direction) {
            case 0: // Move up
                newX = currentX - 1;
                break;
            case 1: // Move right
                newY = currentY + 1;
                break;
            case 2: // Move down
                newX = currentX + 1;
                break;
            case 3: // Move left
                newY = currentY - 1;
                break;
        }

        // Check if the new position is within the plate
        if (newX >= 0 && newX < plate.length && newY >= 0 && newY < plate[0].length) {
            // Move the bacteria to the new cell
            this.bacteriaCount--;
            plate[newX][newY].setBacteriaCount(plate[newX][newY].getBacteriaCount() + 1);
        }
    }
}