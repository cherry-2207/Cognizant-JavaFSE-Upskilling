import java.util.Scanner;

public class PalindromeCheck {
    public static String reverseString(String st) {
        StringBuilder sb = new StringBuilder(st);
        sb.reverse();
        String ans = new String(sb);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.next();
        String rev = reverseString(s);
        if(s.equals(rev)) {
            System.out.println("String is a Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }
        sc.close();
    }
}
