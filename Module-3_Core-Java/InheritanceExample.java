class Animal {
    void eat() {
        System.out.println("Eating");
    }
    void makeSound() {
        System.out.println("Makes sound");
    }
}
class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}
public class InheritanceExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        System.out.println("Calling methods");
        animal.makeSound();
        dog.makeSound();
        System.out.println("Call superclass method with subclass method");
        animal.eat();
    }
}