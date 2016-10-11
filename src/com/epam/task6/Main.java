package com.epam.task6;

import com.epam.task6.logic.MatrixMultiplier;
import com.epam.task6.tool.Generator;
import com.epam.task6.tool.Printer;

public class Main {

    public static void main(String[] args) {
        int[][] matrix1 = Generator.generateSquareMatrix(10);
        System.out.println("Matrix 1:");
        Printer.printMatrix(matrix1);
        int[][] matrix2 = Generator.generateSquareMatrix(10);
        System.out.println("Matrix 2:");
        Printer.printMatrix(matrix2);

        int[][] multiplyMatrix1 = MatrixMultiplier.multiplySquareMatricesWithNoLimitThreads(matrix1, matrix2);
        System.out.println("Multiply matrix:");
        Printer.printMatrix(multiplyMatrix1);

        int[][] multiplyMatrix2 = MatrixMultiplier.multiplySquareMatricesWithTwoThreads(matrix1, matrix2);
        System.out.println("Multiply matrix:");
        Printer.printMatrix(multiplyMatrix2);

    }
}
