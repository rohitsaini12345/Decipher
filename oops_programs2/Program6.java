abstract class EvenOdd {

    abstract void calculate(int n);
}

class Perform extends EvenOdd {
    public void calculate(int n) {
        if (n % 2 == 0)
            System.out.println("n is Even");
        else
            System.out.println("n is Odd");
    }
}

public class Program6 {
    public static void main(String[] args) {
        EvenOdd c1 = new Perform();
        c1.calculate(24);
    }
}
