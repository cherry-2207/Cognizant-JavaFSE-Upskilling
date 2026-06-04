import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int N = sc.nextInt();
        long res = 1;
        for(int i = 1; i <= N; i++) {
            res *= i;
        }
        System.out.println("Factorial of " + N + " is " + res);
        sc.close();
    }
}
