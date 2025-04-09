interface Bank {
    void interestRate();
}

class SBI implements Bank {
    public void interestRate() {
        System.out.println("SBI Interest Rate: 4.0%");
    }
}

class HDFC implements Bank {
    public void interestRate() {
        System.out.println("HDFC Interest Rate: 4.5%");
    }
}

public class Program4 {
    public static void main(String[] args) {
        Bank sbi = new SBI();
        Bank hdfc = new HDFC();
        
        sbi.interestRate();
        hdfc.interestRate();
    }
}
