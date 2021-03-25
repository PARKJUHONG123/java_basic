package week13_IO.Decorator.Coffee;

public class Latte extends Decorator {
    public Latte(Coffee coffee) {
        super(coffee);
    }

    public void brewing() { // overriding
        super.brewing();
        System.out.print("Add milk ");
    }
}
