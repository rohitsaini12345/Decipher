package com.myfactorial.app;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int number;
        int factorial = 1;
        int i = 1;
        System.out.println("Enter a number:");
        Scanner s = new Scanner(System.in);
        number = s.nextInt();

        do {
            factorial *= i;
            i++;
        } while (i <= number);

        System.out.println("Factorial of " + number + " is: " + factorial);
        s.close();
    }
}
