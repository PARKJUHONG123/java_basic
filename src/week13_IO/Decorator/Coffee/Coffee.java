package week13_IO.Decorator.Coffee;

public abstract class Coffee {
    public abstract void brewing();
}


/*
                                                Coffee (Component)
        Americano (ConcreteComponent)                                               Decorator (Decorator)
                                                            Latte (ConcreteComponent)                   Mocha (ConcreteComponent)

- Coffee
    - Decorator
        - Latte
        - Mocha
    - Americano
*/