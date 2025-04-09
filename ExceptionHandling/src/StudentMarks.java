import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class StudentMarks {
    public static void checkmarks(int marks) throws InvalidMarksException{
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks should be between 0 and 100.");
        }
        System.out.println("Valid marks: " + marks);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program starting...");
        try {
            System.out.println("Enter marks");
            int marks=sc.nextInt();
            checkmarks(marks);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally{
            System.out.println("hello I am finally");
        }
    }
}
