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

    public void simulateDay(Cell[][] plate, int currentX, int currentY) {
        Random random = new Random();
        for (int i = 0; i < bacteriaCount; i++) {
            for (int j = 0; j < 10; j++) { // repeat 10 times a day
                if (foodAmount >= 100) {
                    foodAmount -= 20;
                    int randomNumber = random.nextInt(100);
                    if (randomNumber < 3) {
                        bacteriaCount--;
                    } else if (randomNumber >= 60) {
                        moveBacteria(plate, currentX, currentY);
                    }
                } else if (foodAmount >= 10) {
                    foodAmount -= 10;
                    int randomNumber = random.nextInt(100);
                    if (randomNumber < 6) {
                        bacteriaCount--;
                    } else if (randomNumber >= 20) {
                        moveBacteria(plate, currentX, currentY);
                    }
                } else {
                    int randomNumber = random.nextInt(100);
                    if (randomNumber < 20) {
                        bacteriaCount--;
                    } else if (randomNumber >= 60) {
                        moveBacteria(plate, currentX, currentY);
                    }
                }
            }
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
        if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
            // Move the bacteria to the new cell
            this.bacteriaCount--;
            plate[newX][newY].setBacteriaCount(plate[newX][newY].getBacteriaCount() + 1);
        }
    }
}