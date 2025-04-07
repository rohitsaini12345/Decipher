class Add {
    private int a;
    private int b;

    Add(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void getAdd() {
        int add = a + b;
        System.out.println("Sum: " + add);
    }
}

public class Sum {
    public static void main(String[] args) {
        Add a1 = new Add(3, 6);
        a1.getAdd();
    }
}
