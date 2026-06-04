import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter student name: ");
            students.put(id, scanner.nextLine());
        }

        System.out.print("Enter an ID to search: ");
        int searchId = Integer.parseInt(scanner.nextLine());
        String name = students.get(searchId);

        if (name != null) {
            System.out.println("Student name: " + name);
        } else {
            System.out.println("No student found for ID " + searchId);
        }

        scanner.close();
    }
}
