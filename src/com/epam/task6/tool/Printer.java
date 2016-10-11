package com.epam.task6.tool;

/**
 * Created by ASUS on 06.10.2016.
 */
public class Printer {

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
