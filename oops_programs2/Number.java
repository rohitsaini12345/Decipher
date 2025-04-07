class Pattern {

    public void display() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("R");
            System.out.println();
        }
    }

    // method with single parameter
    public void display(String symbol) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(symbol);
            System.out.println();
        }
    }
}

class Number {
    public static void main(String[] args) {
        Pattern d1 = new Pattern();

        d1.display();
        System.out.println("\n");

        d1.display("S");
    }
}
