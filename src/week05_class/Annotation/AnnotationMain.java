package week05_class.Annotation;

import java.lang.reflect.Method;

public class AnnotationMain {
    public static void main(String[] args) {
        Method[] declaredMethods = Service.class.getDeclaredMethods(); // Service 클래스에 선언된 메소드 얻기 (리플렉션)

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(PrintAnnotation.class)) { // PrintAnnotation 이 적용되었는지 확인
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class); // PrintAnnotation 객체 얻기

                System.out.println("[" + method.getName() + "]"); // 메소드 이름 출력
                for (int i = 0; i < printAnnotation.number(); i++) { // 구분선 출력
                    System.out.print(printAnnotation.value());
                }
                System.out.println();

                try {
                    method.invoke(new Service()); // 메소드 호출
                } catch (Exception e) {
                    System.out.println("Service() Error");
                }

            }
        }
    }
}
