class School {
    int id;
    String name;

    // creating a parameterized constructor
    School(int i, String n) {
        id = i;
        name = n;
    }

    void display() {
        System.out.println(id + " " + name);
    }
}

public class Program11 {
    public static void main(String args[]) {
        School s1 = new School(111, "Joseph");
        School s2 = new School(222, "Sonoo");
        s1.display();
        s2.display();
    }
}