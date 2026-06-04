public class PatternMatchingSwitchDemo {
    private static String describeObject(Object value) {
        return switch (value) {
            case Integer number -> "Integer value: " + number;
            case String text -> "String value with length " + text.length();
            case Double decimal -> "Double value: " + decimal;
            case null -> "Null value";
            default -> "Unknown type: " + value.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        Object[] values = {42, "Java", 19.5, true, null};

        for (Object value : values) {
            System.out.println(describeObject(value));
        }
    }
}
