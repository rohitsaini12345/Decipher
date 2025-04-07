abstract class Calculation {
    int z;

    abstract void Add(int a, int b);
}

class My_Calculation extends Calculation {
    public void Add(int a, int b) {
        z = a + b;
        System.out.println("Sum:" + z);
    }
}

public class Program5 {
    public static void main(String[] args) {
        Calculation c1 = new My_Calculation();
        c1.Add(2, 4);
    }
}
