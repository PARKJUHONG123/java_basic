## 목표
- 자바의 예외 처리에 대해 학습하세요.

## 학습할 것 (필수)
- Exception과 Error의 차이는?
    - Error
        - 컴퓨터 하드웨어의 오동작 또는 고장으로 인해 응용프로그램 실행 오류가 발생하는 것
        - JVM 실행에 문제가 생겼다는 것이므로 개발자는 이런 에러에 대처할 방법이 전혀 없음
        - EX. 동적 메모리를 다 사용한 경우, STACK OVERFLOW 등
    - Exception
        - 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류
        - 예외가 발생되면 프로그램이 곧바로 종료된다는 점에서는 Error 와 동일
        - 예외 처리 (Exception Handling) 를 통해 프로그램을 종료하지 않고 정상 실행 상태 유지 가능
        - EX. 읽으려는 파일이 없는 경우, 네트워크나 소켓 연결 오류 등

- 예외 처리 단계
    1. 자바에서는 예외를 클래스로 관리를 관리함
    2. JVM 은 프로그램을 실행하는 도중에 예외가 발생하면 해당 예외 클래스로 객체를 생성함
    3. 예외 처리 코드에서 예외 객체를 이용할 수 있도록 함

- RuntimeException과 RE가 아닌 것의 차이는?
    - Exception (일반 예외)
        - 컴파일러가 체크하는 예외
        - 자바 소스를 컴파일하는 과정에서 예외 처리 코드가 필요한지 검사를 함
        - 만약 예외 처리 코드가 없다면 컴파일 오류가 발생함
        - Exception 을 상속받지만, Runtime Exception 을 상속받지 않는 클래스들

    - Runtime Exception (실행 예외)
        - 컴파일하는 과정에서 예외 처리 코드를 검사하지 않는 예외
        - 자바 컴파일러가 체크하지 않기 때문에 오로지 개발자의 경험에 의해서 예외 처리 코드를 삽입해야 함
        - 해당되는 예외 처리 코드가 없다면 컴파일 오류가 발생하여 종료함
        - Exception 을 상속받지만, JVM 은 Runtime Exception 을 상속했는지 여부를 보고 실행 예외 판단

- 자바가 제공하는 예외 계층 구조
    - java.lang.Exception
        - 일반 예외
            - java.lang.ClassNotFoundException
            - java.lang.InterruptedException
            - ...
        - 실행 예외
            - java.lang.RuntimeException
                - java.lang.NullPointerException
                  - 객체 참조가 없는 상태인 null 값을 갖는 참조 변수로 객체 접근 연산자인 도트를 사용했을 때 발생
                - java.lang.ArrayIndexOutOfBoundsException
                  - 배열에서 인덱스 범위를 초과하여 사용할 경우 발생
                - java.lang.NumberFormatException
                  - Integer.parseInt(String s) 와 Double.parseDouble(String s) 에서 s 내 숫자로 변환될 수 없는 문자가 포함되어 있을 경우 발생
                - java.lang.ClassCastException
                  - 연관 관계가 없는 클래스 간의 억지로 타입 변환이 이루어질 때 발생
                  - instanceof 연산자로 확인하는 것이 권장됨
                - ...

- 커스텀한 예외 만드는 방법
- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
