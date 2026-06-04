import java.util.Scanner;

public class SimpleCalculator {
    private static int add(int num1, int num2) {
        return num1 + num2;
    }
    private static int sub(int num1, int num2) {
        return num1 - num2;
    }
    private static int mul(int num1, int num2) {
        return num1 * num2;
    }
    private static int div(int num1, int num2) {
        if(num2 == 0) {
            return Integer.MIN_VALUE;
        }
        return num1/num2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<--- Welcome to Simple Calculator --->");
        int a, b, res, option;
        do {
            System.out.println("Choose one option");
            System.out.println("0.Exit\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
            option = sc.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Exiting....");
                    break;
                case 1:
                    System.out.println("Enter two numbers");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    res = add(a, b);
                    System.out.println("Sum of " + a + " and " + b + " is " + res);
                    break;
                case 2:
                    System.out.println("Enter two numbers");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    res = sub(a, b);
                    System.out.println("Subtraction of " + a + " and " + b + " is " + res);
                    break;
                case 3:
                    System.out.println("Enter two numbers");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    res = mul(a, b);
                    System.out.println("Product of " + a + " and " + b + " is " + res);
                    break;
                case 4:
                    System.out.println("Enter two numbers");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    res = div(a, b);
                    if(res == Integer.MIN_VALUE) {
                        System.out.println("Division with zero is not possible");
                    } else {
                        System.out.println("Division of " + a + " and " + b + " is " + res);
                    }
                    break;
                default:
                    System.out.println("Invalid option selected, please choose a valid option");
                    break;
            }
        } while (option != 0);
        sc.close();
    }
}
