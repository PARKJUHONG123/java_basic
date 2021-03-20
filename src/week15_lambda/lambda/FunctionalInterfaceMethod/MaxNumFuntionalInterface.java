package week15_lambda.lambda.FunctionalInterfaceMethod;

@FunctionalInterface
// @FunctionalInterface 는 함수형 인터페이스임을 나타냄
// 하나의 메소드만 작성해야 함
public interface MaxNumFuntionalInterface {
    int getMaxNumber(int x, int y);
    // void add(int x, int y);
}
