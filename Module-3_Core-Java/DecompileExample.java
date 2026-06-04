public class DecompileExample {
    public String greet(String name) {
        return "Hello, " + name;
    }

    public static void main(String[] args) {
        DecompileExample example = new DecompileExample();
        System.out.println(example.greet("Java"));
    }
}
