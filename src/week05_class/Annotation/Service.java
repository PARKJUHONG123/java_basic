package week05_class.Annotation;

public class Service {
    @PrintAnnotation
    public void method1() {
        System.out.println("실행1");
    }

    @PrintAnnotation("*")
    public void method2() {
        System.out.println("실행2");
    }

    @PrintAnnotation(value = "#", number = 10)
    public void method3() {
        System.out.println("실행3");
    }

}
