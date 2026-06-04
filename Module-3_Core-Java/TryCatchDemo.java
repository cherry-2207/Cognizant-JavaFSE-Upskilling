public class TryCatchDemo {
    public static void main(String[] args) {
        int a = 50, b = 0;
        double div;
        try {
            div = a / b;  
            System.out.println("Result is " + div);
        } catch(ArithmeticException ae) {
            System.out.println("Caught error " + ae);
        } finally {
            System.out.println("Done");
        }
    }
}
