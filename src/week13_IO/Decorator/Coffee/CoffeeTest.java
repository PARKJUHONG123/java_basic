package week13_IO.Decorator.Coffee;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee americano = new Americano();
        americano.brewing();
        System.out.println();

        Coffee latte = new Latte(new Americano());
        latte.brewing();
        System.out.println();

        Coffee mocha = new Mocha(new Latte(new Americano()));
        mocha.brewing();
        System.out.println();
    }
}
