package week15_lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ArrayListStreamTest {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        sList.add("C");
        sList.add("B");
        sList.add("A");

        Stream<String> stream = sList.stream(); // 스트림 객체 만들기 (Collection 객체일 경우)
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println("");

        // stream.sorted().forEach(s->System.out.print(s + " ")); // 이미 사용한 스트림 객체는 재사용 불가능
        sList.stream().sorted().forEach(s->System.out.print(s + " "));
        System.out.println("");

        sList.stream().map(s -> s.length()).forEach(s->System.out.print(s + " "));
        System.out.println("");

        String[] greet = {"안녕하세요~", "hello", "Good Morning", "반갑습니다"};
        String result = Arrays.stream(greet).reduce("", (s1, s2) -> {
            if (s1.getBytes().length >= s2.getBytes().length) {
                return s1;
            }
            return s2;
        });
        System.out.println(result);

        String resultByClass = Arrays.stream(greet).reduce(new CompareString()).get();
        System.out.println(resultByClass);
    }
}

class CompareString implements BinaryOperator<String> {

    @Override
    public String apply(String s1, String s2) {
        if (s1.getBytes().length >= s2.getBytes().length) {
            return s1;
        }
        return s2;
    }
    
}
