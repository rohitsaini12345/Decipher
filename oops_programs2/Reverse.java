class Pattern {

    public void display() {
        for (int i = 0; i < 10; i++) {
            for (int j = 10; j > i; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    // method with single parameter
    public void display(char symbol) {
        for (int i = 0; i < 10; i++) {
            for (int j = 10; j > i; j--)
                System.out.print(symbol);
            System.out.println();
        }
    }
}

class Reverse {
    public static void main(String[] args) {
        Pattern d1 = new Pattern();

        d1.display();
        System.out.println("\n");

        d1.display('#');
    }
}
