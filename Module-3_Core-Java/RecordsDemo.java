import java.util.List;

record Person(String name, int age) {
}

public class RecordsDemo {
    public static void main(String[] args) {
        Person first = new Person("Asha", 24);
        Person second = new Person("Rahul", 17);

        System.out.println(first);
        System.out.println(second);

        List<Person> people = List.of(first, second, new Person("Meera", 31));

        List<Person> adults = people.stream()
                .filter(person -> person.age() >= 18)
                .toList();

        System.out.println("Adults: " + adults);
    }
}
