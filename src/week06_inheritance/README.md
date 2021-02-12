## 목표
    자바의 상속에 대해 학습하세요.

## 학습할 것 (필수)
- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스

### Object 클래스
    - 모든 클래스의 직/간접적 슈퍼클래스
    - java.lang 패키지에 존재
    - 매개변수 없는 생성자

- protected Object clone() throws CloneNotSupportedException
    - 객체의 복사본을 만들고 반환
    - 복제 불가능한 경우 예외 발생
- public boolean equals(Object obj)
    - 다른 객체와 비교해서 다른 객체와 이 객체가 같은지를 나타내는 동등성 비교를 수행
    - 내부 구현은 == 동일성 비교여서 오버라이딩을 해주지 않으면 기본적으로 동일성 비교를 수행
    - 이 메서드를 오버라이딩 할 때에는 아래에 설명할 hashCode() 메서드 또한 오버라이딩 해야함
- protected void finalize() throws Throwable
    - 가비지 컬렉터가 객체에 대한 참조가 없는 경우 호출 
    - 실행될지 불확실하기 때문에 크리티컬한 코드를 여기에 두면 X
- public final Class getClass()
    - 객체의 런타임 클래스를 호출
- public int hashCode()
    - 객체의 해시코드 값을 반환
    - 두 객체가 같으면 해시코드도 같아야하기 때문에 equals()를 오버라이딩 할 때, hashCode() 또한 오버라이딩 해야함
- public String toString()
    - 객체의 문자열 형태를 반환 
    - 기본적으로는 거의 의미 없는 정보를 보여주기에 이 메서드의 오버라이딩을 통해 객체가 유용한 정보를 반환하도록 정의해야 함 

- 오버라이딩 할 수 없도록 final 로 선언된 notify(), notifyAll(), wait() 메서드는 독립적으로 실행되는 스레드간의 동기화에 사용됨

