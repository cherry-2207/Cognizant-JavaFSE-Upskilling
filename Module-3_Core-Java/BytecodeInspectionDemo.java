public class BytecodeInspectionDemo {
    public int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        BytecodeInspectionDemo demo = new BytecodeInspectionDemo();
        System.out.println("Square: " + demo.square(6));
    }
}
