// if program

import java.util.Scanner;

class Age {
    public static void main(String[] args) {
        int age;
        System.out.println("Enter age:");
        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();

        if (age > 18) {
            System.out.print("Age is greater than 18");
        }
        sc.close();

    }
}