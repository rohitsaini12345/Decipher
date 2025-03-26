package com.Tata.app;

import java.util.Scanner;

/**
 * Hello world!
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println("Type Something");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("You Entered:" + str);
        sc.close();
    }
}
