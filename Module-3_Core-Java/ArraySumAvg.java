import java.util.Scanner;

public class ArraySumAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] ar = new int[n];
        System.out.println("Enter " + n + " elements");
        for(int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        long sum = 0;
        for(int e: ar) {
            sum += e;
        }
        double avg = sum / n;
        System.out.println("Sum of array elements is " + sum);
        System.out.println("Average of array element is " + avg);
        sc.close();
    }
}
