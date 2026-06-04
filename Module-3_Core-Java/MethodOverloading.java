public class MethodOverloading {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static void main(String[] args) {
        System.out.println("Sum of 5 and 3 is " + add(5, 3) );
        System.out.println("Sum of 3.14 and 0.93 is " + add(3.14, 0.93));
        System.out.println("Sum of 10, 20 and 33 is " + add(10, 20, 33));
    }
}
