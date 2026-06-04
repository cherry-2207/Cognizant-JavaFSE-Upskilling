import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many names do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter student name " + i + ": ");
            studentNames.add(scanner.nextLine());
        }

        System.out.println("Student names:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
