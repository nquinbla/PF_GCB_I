package Parte_2;

import java.util.Random;

public class MontecarloSimulación {
    private static final int PLATE_SIZE = 20;
    private static final int INITIAL_POPULATION = 1600;
    private static final int INITIAL_FOOD = 40000;
    private int[][] bacteriaPopulation;
    private int[][] foodAmount;

    public MontecarloSimulación() {
        bacteriaPopulation = new int[PLATE_SIZE][PLATE_SIZE];
        foodAmount = new int[PLATE_SIZE][PLATE_SIZE];
        initializeExperiment();
    }

    private void initializeExperiment() {
        int initialBacteriaPerCell = INITIAL_POPULATION / 16;
        for (int i = 8; i < 12; i++) {
            for (int j = 8; j < 12; j++) {
                bacteriaPopulation[i][j] = initialBacteriaPerCell;
            }
        }

        int initialFoodPerCell = INITIAL_FOOD / (PLATE_SIZE * PLATE_SIZE);
        for (int i = 0; i < PLATE_SIZE; i++) {
            for (int j = 0; j < PLATE_SIZE; j++) {
                foodAmount[i][j] = initialFoodPerCell;
            }
        }
    }

    public void simulateDay() {
        Random random = new Random();
        for (int i = 0; i < PLATE_SIZE; i++) {
            for (int j = 0; j < PLATE_SIZE; j++) {
                int bacteriaInCell = bacteriaPopulation[i][j];
                for (int b = 0; b < bacteriaInCell; b++) {
                    for (int k = 0; k < 10; k++) {
                        simulateBacteria(i, j, random);
                    }
                }
            }
        }
    }

    private void simulateBacteria(int x, int y, Random random) {
        if (foodAmount[x][y] >= 100) {
            foodAmount[x][y] -= 20;
            int rand = random.nextInt(100);
            if (rand < 3) {
                bacteriaPopulation[x][y]--;
            } else if (rand >= 60 && rand < 100) {
                moveBacteria(x, y, rand);
            }
        } else if (foodAmount[x][y] > 9) {
            foodAmount[x][y] -= 10;
            int rand = random.nextInt(100);
            if (rand < 6) {
                bacteriaPopulation[x][y]--;
            } else if (rand >= 20 && rand < 100) {
                moveBacteria(x, y, rand);
            }
        } else {
            int rand = random.nextInt(100);
            if (rand < 20) {
                bacteriaPopulation[x][y]--;
            } else if (rand >= 60 && rand < 100) {
                moveBacteria(x, y, rand);
            }
        }
    }

    private void moveBacteria(int x, int y, int rand) {
        // Movimiento basado en el número aleatorio
        int newX = x, newY = y;
        if (rand >= 60 && rand < 65) newY--;
        else if (rand >= 65 && rand < 70) newY++;
        else if (rand >= 70 && rand < 75) newX--;
        else if (rand >= 75 && rand < 80) newX++;
        else if (rand >= 80 && rand < 85) { newX--; newY--; }
        else if (rand >= 85 && rand < 90) { newX++; newY--; }
        else if (rand >= 90 && rand < 95) { newX--; newY++; }
        else if (rand >= 95 && rand < 100) { newX++; newY++; }

        // Verificar límites del plato
        if (newX >= 0 && newX < PLATE_SIZE && newY >= 0 && newY < PLATE_SIZE) {
            bacteriaPopulation[x][y]--;
            bacteriaPopulation[newX][newY]++;
        }
    }

    public int[][] getBacteriaPopulation() {
        return bacteriaPopulation;
    }

    public int[][] getFoodAmount() {
        return foodAmount;
    }
}
