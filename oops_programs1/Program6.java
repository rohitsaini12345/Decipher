import java.util.Scanner;

class Employee {
    int id;
    String name;
    float salary;

    void insert() {
        System.out.println("Enter values:");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        sc.nextLine();
        name = sc.nextLine();
        salary = sc.nextFloat();
        sc.close();
    }

    void display() {
        System.out.println(id + " " + name + " " + salary);
    }
}

public class Program6 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();
        e1.insert();
        e2.insert();
        e3.insert();
        e1.display();
        e2.display();
        e3.display();
    }
}