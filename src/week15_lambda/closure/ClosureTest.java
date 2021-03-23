package week15_lambda.closure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosureTest {
    private Integer b = 2;
    private Integer c = 5;

    private Integer getC() {
        return c;
    }

    // calculate 메소드에서 map 메소드를 호출함
    // 인자로 넘어가는 람다가 있는데 내부에서 외부 변수인 a와 b를 참조하고 있음
    // 이 때 a 와 b 는 컴파일러가 final 로 간주함 (effiectively final)
    // 내부에서 필요로 하는 정보를 넘길 때 값이 변경되면 의도하지 않은 결과가 나올 수 있기 때문에 상수 취급
    private Stream<Integer> calculate(Stream<Integer> stream, Integer a) { //     private Stream<Integer> calculate(Stream<Integer> stream, final Integer a) {
        // a = 10; 
        
        // 람다로 인해서 effiectively final 로 설정되어 있기 때문에 컴파일 에러 발생 (final Integer a 와 마찬가지로 인식함)
        // 만약에 아래 람다식이 없게 되면 a = 10 구문이 동작할 수 있음 (effectively final 로 컴파일러가 인식하지 않음)
        return stream.map(t -> t * a + b);
    }

    // 우회 방법
    // 객체를 이용해서 사용할 수 있지만, side effect 가 발생할 수 있음
    private Stream<Integer> byPassCalculate(Stream<Integer> stream, Int a) {
        a.setValue(10); 
        return stream.map(t -> t * a.value + getC());
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = new ClosureTest()
        .calculate(list.stream(), 3)
        .collect(Collectors.toList());
        System.out.println(result);

        List<Integer> byPassResult = new ClosureTest()
        .byPassCalculate(list.stream(), new Int(3))
        .collect(Collectors.toList());
        System.out.println(byPassResult);
    }
}

class Int {
    public int value;
    public Int(int value) {
      this.value = value;
    }
    public void setValue(int value) {
      this.value = value;
    }
}