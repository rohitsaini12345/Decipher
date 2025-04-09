// constructor overloading progra
class College {
    int id;
    String name;
    int age;

    // creating two arg constructor
    College(int i, String n) {
        id = i;
        name = n;
    }

    // creating three arg constructor
    College(int i, String n, int a) {
        id = i;
        name = n;
        age = a;
    }

    void display() {
        System.out.println(id + " " + name + " " + age);
    }
}

public class Program12 {
    public static void main(String args[]) {

        College s1 = new College(111, "Karan");
        College s2 = new College(222, "Aryan", 25);
        s1.display();
        s2.display();
    }
}