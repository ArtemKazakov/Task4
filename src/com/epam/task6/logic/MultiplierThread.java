package com.epam.task6.logic;

/**
 * Created by ASUS on 09.10.2016.
 */
public class MultiplierThread extends Thread{

    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] resultMatrix;
    private ElementIndexes elementIndexes;

    public MultiplierThread(int[][] firstMatrix, int[][] secondMatrix, int[][] resultMatrix, ElementIndexes elementIndexes)
    {
        this.firstMatrix  = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.elementIndexes = elementIndexes;
    }


    private void multiplyRowOnColumn(int row, int col)
    {

        for (int k = 0; k < resultMatrix.length; k++) {
            resultMatrix[row][col] += firstMatrix[row][k] * secondMatrix[k][col];
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " started.");
        int[] indexes;
        while(true) {
            synchronized (elementIndexes) {
                if(elementIndexes.isDone()){
                    break;
                }
                indexes = elementIndexes.getIndexes();
            }
            multiplyRowOnColumn(indexes[0], indexes[1]);
            System.out.println("Thread " + getName() + " calculate [" + indexes[0] +"]["+ indexes[1]+"]");
        }

        System.out.println("Thread " + getName() + " finished.");
    }
}
