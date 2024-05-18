package Parte_2.GestorCeldas;

import java.util.Random;

public class Cell {
    private int bacteriaCount;
    private int foodAmount;
    private int foodConsumed;
    private int[][][] bacteriaAndFoodData; // 3D para almacenar el número de bacterias y comida restante por día y celda


    public Cell(int bacteriaCount, int foodAmount, int days) {
        this.bacteriaCount = bacteriaCount;
        this.foodAmount = foodAmount;
        this.bacteriaAndFoodData = new int[days][2][2];
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
            foodConsumed = 0;
            for (int j = 0; j < 10; j++) {
                if (foodAmount >= 100) {
                    foodAmount -= 20;
                    foodConsumed += 20;
                    int randomNumber = random.nextInt(100);
                    if (randomNumber < 3) {
                        bacteriaCount--;
                    } else if (randomNumber >= 60) {
                        moveBacteria(plate, currentX, currentY);
                    }
                } else if (foodAmount >= 10) {
                    foodAmount -= 10;
                    foodConsumed += 10;
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
            bacteriaAndFoodData[day][0][0] = bacteriaCount;
            bacteriaAndFoodData[day][0][1] = foodAmount;

            reproduceBacteria(); // reproduce at the end of the day
        }
    }

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
        int direction = random.nextInt(4);

        int newX = currentX;
        int newY = currentY;

        switch (direction) {
            case 0:
                newX = currentX - 1;
                break;
            case 1:
                newY = currentY + 1;
                break;
            case 2:
                newX = currentX + 1;
                break;
            case 3:
                newY = currentY - 1;
                break;
        }


        if (newX >= 0 && newX < plate.length && newY >= 0 && newY < plate[0].length) {

            this.bacteriaCount--;
            plate[newX][newY].setBacteriaCount(plate[newX][newY].getBacteriaCount() + 1);
        }
    }
}