package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static int MAX_RANDOMIZE_VALUE = 20;
    final static int MIN_RANDOMIZE_VALUE = -20;
    final static int INPUT_MATRIX_MODE = 1;
    final static int FINDING_MIN_MODE = 2;
    final static int FINDING_MAX_MODE = 3;
    final static int FINDING_ARITHMETIC_MODE = 4;
    final static int FINDING_GEOMITRIC_MODE = 5;
    final static int EXIT_MODE = 6;

    public static void main(String[] args) {
        int mode;
        List<List<Integer>> matrix = null;

        do {
            mode = printMenuAndGetMode();
            if (mode == INPUT_MATRIX_MODE) {
                matrix = fillMatrix();
            }
            if (matrix == null) {
                System.out.println("Unfortunatley you matrix is empty. Please fill the matrix.");
                continue;
            }
            switch (mode) {
                case FINDING_MIN_MODE: {
                    System.out.printf("MIN value of matrix: %d \n", findExtreme(matrix, false));
                    break;
                }
                case FINDING_MAX_MODE: {
                    System.out.printf("MAX value of matrix: %d \n", findExtreme(matrix, true));
                    break;
                }
                case FINDING_ARITHMETIC_MODE: {
                    System.out.printf("Arithmetic mean of matrix: %f \n", findArithmeticAverage(matrix));
                    break;
                }
                case FINDING_GEOMITRIC_MODE: {
                    System.out.printf("Geometric mean of matrix: %f \n", findGeometricAverage(matrix));
                    break;
                }
            }
            System.out.println("\n");
        } while (mode != EXIT_MODE);
    }

    private static int printMenuAndGetMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Mode:");
        System.out.println(INPUT_MATRIX_MODE + ". Re-enter matrix");
        System.out.println(FINDING_MIN_MODE + ". MIN element");
        System.out.println(FINDING_MAX_MODE + ". MAX element");
        System.out.println(FINDING_ARITHMETIC_MODE + ". Average arithmetic value");
        System.out.println(FINDING_GEOMITRIC_MODE + ". Average geometric value");
        System.out.println(EXIT_MODE + ". Exit");
        System.out.println("\nYour choice[1-6]:");
        int mode = scanner.nextInt();
        return mode;
    }

    private static double findArithmeticAverage(List<List<Integer>> matrix) {
        double sum = 0;
        int counter = 0;
        for (int i = 0; i < matrix.size(); ++i) {
            List<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); ++j) {
                sum += row.get(j);
                counter++;
            }
        }
        return sum / counter;
    }

    private static double findGeometricAverage(List<List<Integer>> matrix) {
        double multi = 1;
        double counter = 0;
        for (int i = 0; i < matrix.size(); ++i) {
            List<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); ++j) {
                multi *= (double) row.get(j);
                counter++;
            }
        }
        return Math.exp(Math.log(multi) / counter);
    }

    private static int findExtreme(List<List<Integer>> matrix, Boolean isMaximum) {

        List<Integer> extremes = new ArrayList<Integer>();
        for (int i = 0; i < matrix.size(); ++i) {
            if (isMaximum) {
                extremes.add(Collections.max(matrix.get(i)));
            } else {
                extremes.add(Collections.min(matrix.get(i)));
            }
        }
        return isMaximum ? Collections.max(extremes) : Collections.min(extremes);
    }

    private static int inputValueFromKeyboard(String nameOfInputValue) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.printf("Input %s of matrix: ", nameOfInputValue);
            value = scanner.nextInt();
            if (value > 0 && value <= 20) {
                return value;

            } else {
                System.out.print("Value must be greater than 0 and less than 20, please try again!\n\n");
            }
        } while (true);
    }

    private static List<List<Integer>> fillMatrix() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Scanner scanner = new Scanner(System.in);


        int width = inputValueFromKeyboard("width");
        int height = inputValueFromKeyboard("height");

        System.out.print("Keyboard or Random filling of Matrix?[k|r] ");

        Boolean isKeyboard = scanner.next() == "k";

        for (int i = 0; i < height; ++i) {
            List<Integer> col = new ArrayList<Integer>();
            for (int j = 0; j < width; ++j) {
                if (isKeyboard) {
                    System.out.printf("Matrix [%d][%d] = ", i, j);
                    col.add(scanner.nextInt());
                } else {
                    int random = (int) (Math.random() * (MAX_RANDOMIZE_VALUE - MIN_RANDOMIZE_VALUE) + MIN_RANDOMIZE_VALUE);
                    System.out.printf("Matrix [%d][%d] = %d \n", i, j, random);
                    col.add(random);
                }
            }
            result.add(col);
        }

        return result;
    }
}