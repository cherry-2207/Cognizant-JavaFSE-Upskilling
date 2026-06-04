class Car {
    private String mark;
    private String model;
    private int year;
    Car(String mark, String model, int year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }
    // Implement a Method to print car information
    public void displayDetails() {
        System.out.println("Manufacturer: " + this.mark);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
    }
}
public class ClassDemo {
    public static void main(String[] args) {
        Car car = new Car("Kia", "Sonet", 2026);
        car.displayDetails();
    }
}
