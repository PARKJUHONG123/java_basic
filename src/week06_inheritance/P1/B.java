package week06_inheritance.P1;
// 같은 패키지 내에 있는 클래스는 protected 로 선언된 필드, 생성자, 메소드 접근 가능
public class B {
    public void method() {
        A a = new A();
        a.field = "value";
        a.method();
    }
}
