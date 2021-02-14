package week09_exception;

// 사용자 정의 예외처리
// = 애플리케이션 예외 (Application Exception)
// 자바 표준 API 에서 제공하는 예외 클래스만으로는 모든 종류의 예외를 표현할 수 없기 때문에 사용자가 정의해서 만들 수 있어야 함

public class customException extends Exception { // 일반 예외로 선언할 경우, Exception 상속
    public customException() { }
    public customException(String message) {
        super("[customException] : " + message);
    }
}

class customRuntimeException extends RuntimeException { // 실행 예외로 선언할 경우, RuntimeException 상속
    customRuntimeException() { }
    customRuntimeException(String message) {
        super("[customRuntimeException] : " + message);
    }
}