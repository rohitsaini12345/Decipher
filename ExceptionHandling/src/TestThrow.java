public class TestThrow {
    public static void checkNum(int num) {
        if (num < 1) {
            throw new ArithmeticException("\nNumber is negative");
        }
        else {
            System.out.println("Number is Positive");
        }
    }
    //main method
    public static void main(String[] args) {
        TestThrow obj = new TestThrow();
        obj.checkNum(0);
        System.out.println("code chl gya");
    }
}
