interface playable {
    void play();
}
class Guitar implements playable {
    public void play() {
        System.out.println("Played Guitar");
    }
}
class Piano implements playable{
    public void play() {
        System.out.println("Played Piano");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        Piano piano = new Piano();
        Guitar guitar = new Guitar();
        piano.play();
        guitar.play();
    }   
}
