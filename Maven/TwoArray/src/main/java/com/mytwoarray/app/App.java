package com.mytwoarray.app;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int arr[][] = new int[2][2];
        System.out.println("Enter array elements:");
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println("Matrix elements:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        s.close();
    }
}
