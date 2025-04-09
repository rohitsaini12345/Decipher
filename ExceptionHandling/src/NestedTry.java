public class NestedTry {
    public static void main(String[] args){
        try {
            try {
                int a=60;
                int b = 0;
                int c=a/b;
                System.out.println("result"+c);

            }

            catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
        catch(Exception e)
        {
            System.out.println("handled the exception (outer catch)");
        }
        finally {
            System.out.println("normal flow");
        }

    }
}
