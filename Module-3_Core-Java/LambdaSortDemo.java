import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Ravi", "Ananya", "Vikram", "Meera"));

        Collections.sort(names, (first, second) -> first.compareToIgnoreCase(second));

        System.out.println("Sorted names: " + names);
    }
}
