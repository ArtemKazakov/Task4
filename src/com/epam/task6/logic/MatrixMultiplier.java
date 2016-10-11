package com.epam.task6.logic;

/**
 * Created by ASUS on 09.10.2016.
 */
public class MatrixMultiplier {

    public static int[][] multiplySquareMatricesWithNoLimitThreads(int[][] firstMatrix, int[][] secondMatrix){
        int threadCount =  (int)Math.ceil(firstMatrix.length/2);
        return multiplySquareMatrices(firstMatrix, secondMatrix, threadCount);
    }

    public static int[][] multiplySquareMatricesWithTwoThreads(int[][] firstMatrix, int[][] secondMatrix){
        int threadCount = 2;
        return multiplySquareMatrices(firstMatrix, secondMatrix, threadCount);
    }

    public static int[][] multiplySquareMatrices(int[][] firstMatrix, int[][] secondMatrix, int threadCount){
        int rowCount = firstMatrix.length;
        int colCount = secondMatrix[0].length;
        int[][] resultMatrix = new int[rowCount][colCount];

        if((threadCount < 1)||(threadCount > Math.ceil(resultMatrix.length/2))){
            throw new IllegalArgumentException("Incorrect thread number.");
        }

        MultiplierThread[] multiplierThreads = new MultiplierThread[threadCount];
        ElementIndexes elementIndexes = new ElementIndexes(colCount, rowCount);

        for (int threadIndex = threadCount - 1; threadIndex >= 0; --threadIndex) {
                multiplierThreads[threadIndex] = new MultiplierThread(firstMatrix, secondMatrix, resultMatrix, elementIndexes);
                multiplierThreads[threadIndex].start();
        }

        try {
            for (MultiplierThread multiplierThread : multiplierThreads)
                multiplierThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultMatrix;
    }

}
