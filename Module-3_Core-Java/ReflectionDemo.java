import java.lang.reflect.Method;

class ReflectionTarget {
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("ReflectionTarget");
            Object instance = clazz.getDeclaredConstructor().newInstance();

            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("Method: " + method.getName());
                System.out.println("Parameter count: " + method.getParameterCount());
            }

            Method greet = clazz.getDeclaredMethod("greet", String.class);
            greet.invoke(instance, "Student");
        } catch (Exception e) {
            System.out.println("Reflection error: " + e.getMessage());
        }
    }
}
