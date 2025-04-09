//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// this program run without a catch block because we got a result.
class Example{
    public static void main(String [] args){
        System.out.println("code starting");
        try{
            int n1=50;
            int n2=5;
            System.out.println("we got two no:");
            int result=n1/n2;
            System.out.println("result: "+result);
        }
        catch(ArithmeticException e){
            System.out.println("n2 cannot be 0");
            System.out.println(e.getMessage());
        }

        System.out.println("code terminating");
    }
}