import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double random_num = (Math.random()*100);
        int n = (int)random_num;
        int given_num = -1;
        while(true) {
            System.out.println("Enter a number");
            given_num = sc.nextInt();
            if(given_num == n) {
                System.out.println("Congratulations!!! You're correct");
                break;
            } else if(given_num > n) {
                System.out.println("Too High!!!");
            } else {
                System.out.println("Too Low!!!");
            }
        }
        sc.close();
    }
}
