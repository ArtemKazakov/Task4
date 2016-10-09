package com.epam.task4.logic;

/**
 * Created by ASUS on 09.10.2016.
 */
public class Calculator {

    private static int rowCount;
    private static int colCount;
    private static int[] coords = {0 ,0};

    public static int[][] multiplySquareMatrices(int[][] firstMatrix, int[][] secondMatrix, int threadCount){
        rowCount = firstMatrix.length;
        colCount = secondMatrix[0].length;
        int[][] resultMatrix = new int[rowCount][colCount];

        if((threadCount < 1)||(threadCount > Math.pow(resultMatrix.length, 2)/2)){
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
