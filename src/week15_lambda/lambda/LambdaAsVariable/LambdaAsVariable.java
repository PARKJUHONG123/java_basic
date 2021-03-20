package week15_lambda.lambda.LambdaAsVariable;

public class LambdaAsVariable {
    public static void main(String[] args) {
        // 일반 변수처럼 사용되는 람다식
        LambdaAsVariableInterface lambdaAsVariableInterface = str -> System.out.println(str);
        lambdaAsVariableInterface.showString("Local Variable Test");

        // 파라미터처럼 사용되는 람다식
        showStringParameter(lambdaAsVariableInterface);

        // Return 값으로 사용되는 람다식
        LambdaAsVariableInterface lambdaAsReturnInterface = returnString();
        lambdaAsReturnInterface.showString("Return Test");
    }

    public static void showStringParameter(LambdaAsVariableInterface lambdaAsParameterInterface) {
        lambdaAsParameterInterface.showString("Parameter Test");
    }

    public static LambdaAsVariableInterface returnString() {
        return str -> System.out.println(str);
    }
}
