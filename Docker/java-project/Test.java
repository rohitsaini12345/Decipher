import java.util.Properties;

class Test {

    public static void printSystemProperties() {
        System.out.println("system properties");
        Properties pros = System.getProperties();
        System.out.println(pros);
    }

    public static void main(String[] args) {
        System.out.println("java program started..");
        printSystemProperties();
    }
}