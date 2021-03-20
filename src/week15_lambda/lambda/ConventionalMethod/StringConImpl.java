package week15_lambda.lambda.ConventionalMethod;

// 기존 구현 방식
public class StringConImpl implements StringConcat{
    @Override
    public void makeString(String s1, String s2) {
        System.out.println(s1 + s2);
    }
}
