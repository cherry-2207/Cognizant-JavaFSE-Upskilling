import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String st = sc.next();
        StringBuilder sb = new StringBuilder(st);
        sb.reverse();
        System.out.println("Reverse of String is " + sb);
        sc.close();
    }
}
