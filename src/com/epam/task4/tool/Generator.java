package com.epam.task4.tool;

import java.util.Random;

/**
 * Created by ASUS on 06.10.2016.
 */
public class Generator {

    public static int[][] generateSquareMatrix(int orderOfMatrix){
        int[][] matrix = new int[orderOfMatrix][orderOfMatrix];
        Random random = new Random();
        for (int i=0; i<orderOfMatrix; i++){
            for (int j=0; j<orderOfMatrix; j++){
                matrix[i][j] = random.nextInt(100);
            }
        }
        return matrix;
    }
}
