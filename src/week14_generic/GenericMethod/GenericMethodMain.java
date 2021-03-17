package week14_generic.GenericMethod;

public class GenericMethodMain {
    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        System.out.println(genericMethod.makeRectangle(genericMethod.setPoint(1, 2), genericMethod.setPoint(3, 4)));

        Shape<String> shape = new Shape<>(); // Java 7부터는 간략화시킬 수 있음 (컴파일러가 자동으로 채워줌)
        Point<Double, Double> p1 = new Point<>(1.5, 3.0);
        Point<Double, Double> p2 = new Point<>(2.0, 11.2);
        System.out.println(shape.makeRectangle(p1, p2));

        shape.setName("shape 의 제네릭 타입과 shape 내부의 메소드에서 선언된 제네릭 타입은 서로 연관 없음");
        System.out.println(shape.getName());

        Square<String, Integer> square = new Square<>();
        square.setName("제네릭 타입 간에도 상속이 가능함");
        square.setLength(5);
        System.out.println(square.getName() + " / 길이 : " + square.getLength());
    }
}
