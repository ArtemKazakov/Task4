package com.epam.task4;

import com.epam.task4.logic.Calculator;
import com.epam.task4.tool.Generator;
import com.epam.task4.tool.Printer;

public class Main {

    public static void main(String[] args) {
        int[][] matrix1 = Generator.generateSquareMatrix(10);
        System.out.println("Matrix 1:");
        Printer.printMatrix(matrix1);
        int[][] matrix2 = Generator.generateSquareMatrix(10);
        System.out.println("Matrix 2:");
        Printer.printMatrix(matrix2);

        int[][] multiplyMatrix1 = Calculator.multiplySquareMatrices(matrix1, matrix2, 50);
        System.out.println("Multiply matrix:");
        Printer.printMatrix(multiplyMatrix1);
    }
}
