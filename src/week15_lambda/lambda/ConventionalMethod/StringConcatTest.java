package week15_lambda.lambda.ConventionalMethod;

public class StringConcatTest {
    public static void main(String[] args) {
        // 기존 방식 : 인터페이스를 구현한 클래스를 불러옴
        StringConImpl stringConImpl = new StringConImpl();
        stringConImpl.makeString("hello", " world!");

        // 람다식 : 익명 내부 클래스가 생략된다고 생각하면 됨
        StringConcat stringConcat_lambda = (s1, s2) -> System.out.println(s1 + s2);
        stringConcat_lambda.makeString("hello", " world!");

        // 익명 내부 클래스
        StringConcat stringConcat_conventionalImpl = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + s2);
            }
        };
        stringConcat_conventionalImpl.makeString("hello", " world!");
    }
}
