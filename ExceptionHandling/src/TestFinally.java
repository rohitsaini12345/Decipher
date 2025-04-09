import java.util.InputMismatchException;
import java.util.Scanner;

public class TestFinally {
    public static void main(String[] args) {
        System.out.println("code starting");
        System.out.println("Enter a value of n1 and n2:");
        Scanner sc=new Scanner(System.in);

        try{
            int n1=sc.nextInt();
            int n2=sc.nextInt();
            System.out.println("we got two no:");
            int result=n1/n2;
            System.out.println("result: "+result);
        }
        catch(ArithmeticException e){
            System.out.println("n2 cannot be 0");
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Number");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("hello I am finally");
            System.out.println("I am run Everytime whenever try or catch block executed or not");
        }
        sc.close();

        System.out.println("code terminating");
    }
}
