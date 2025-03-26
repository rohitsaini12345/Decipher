
public class ArrayProgram {
    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5 };
        int targetValue = 3;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetValue) {
                System.out.println("Value found at index " + i);
                break;
            }
        }
    }
}