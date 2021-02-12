package week06_inheritance.P2;
import week06_inheritance.P1.A;

public class D extends A {
    public D() {
        super();
        // A a = new A();
        this.field = "value";
        this.method();
    }

    @Override
    protected void method() {
        System.out.println("A의 자식 클래스는 다른 패키지에 있더라도 super() 를 통해 생성자를 호출할 수 있음");
        System.out.println("단, new 연산자로 생성자를 직접 호출할 수는 없음");
    }
}
