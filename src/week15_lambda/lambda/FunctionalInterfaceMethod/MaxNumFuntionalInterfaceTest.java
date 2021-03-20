package week15_lambda.lambda.FunctionalInterfaceMethod;

public class MaxNumFuntionalInterfaceTest {
    public static void main(String[] args) {
        MaxNumFuntionalInterface maxNumFuntionalInterface = (x, y) -> (x >= y) ? x : y;
        System.out.println(maxNumFuntionalInterface.getMaxNumber(10, 20));
    }
}
