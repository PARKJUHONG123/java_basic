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

### super 키워드
- super() 로 호출되는 생성자는 상위 클래스의 기본 생성자
- 만약 상위 클래스의 기본생성자가 없는 경우 (즉 매개변수가 있는 생성자만 존재하는 경우), 하위 클래스는 명시적으로 상위 클래스의 생성자를 호출해야 함

```
    // VIP.java
    public class VIP extends Customer {
        public VIP(int customerID, String customerName) {
            super(customerID, customerName);
            //super(); // 오류 발생함 = 상위 클래스의 생성자가 기본 생성자가 아니기 때문
        }
    }
    
    // Customer.java
    public class Customer {
        private int customerID;
        private String customerName;
        public Customer(int customerID, String customerName) {
            this.customerID = customerID;
            this.customerName = customerName;
        }
    }
```

### final 키워드
#### 1. final 변수
- 값이 변경될 수 없는 상수
- public static final double PI = 3.14; 처럼 final 로 설정해서 값을 변경할 수 없게 하고 static 으로 메모리 하나를 배정한 뒤 공용으로 사용할 수 있게 함
- 오직 한 번만 값을 할당할 수 있음

#### 2. final 메소드 (템플릿 메소드)
- 하위 클래스에서 재정의 (overriding) 할 수 없음

```
    public abstract class Car {
        public abstract void drive();
        public abstract void stop();
        
        public void turnOn() {
            System.out.println("시동 ON");
        }
        
        public void turnOff() {
            System.out.println("시동 OFF");
        }
        
        // 템플릿 메소드
        // 하위 클래스에서 재정의할 수 없는 메소드
        // 순서가 변경되지 않거나, 내부 내옹이 변경되지 않을 메소드
        final public void run() { // 다음과 같이 final 로 수정이 되지 않도록 함 
            turnOn();
            drive();
            stop();
            turnOff();
        }    
    }
    
```

#### 3. final 클래스
- 더 이상 상속되지 않음 (자손이 없음)
- ex. java의 String 클래스


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

