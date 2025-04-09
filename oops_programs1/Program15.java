class Animal {
    void run() {
        System.out.println("I'm running");
    }
}

class Birds {
    void fly() {
        System.out.println("I'm flying");
    }
}

public class Program15 {
    public static void main(String[] args) {
        Animal buzo = new Animal();
        buzo.run();

        Birds sparrow = new Birds();
        sparrow.fly();
    }
}