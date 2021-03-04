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
- String 클래스
- Wrapper 
- Class 클래스

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

```
    // 프로젝트 구현 시 여러 파일에서 공유해야 하는 상수 값은 하나의 파일에 선언하여 사용하면 편리함
    public class Define {
        public static final int MIN = 1;
        public static final int MAX = 999;
    }
    
    public class DefineTest {
        public static void main(String[] args) {
            System.out.println("최저 : " + Define.MIN + " 최대 : " + Define.MAX);
        }
    }
```

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
    - 모든 클래스의 직/간접적 슈퍼클래스 (최상위 클래스)
    - java.lang 패키지에 존재 (java.lang.Object 클래스) (jdk/library/src.zip/base/java/lang 에 위치함 | 컴파일러가 자동으로 import 해서 사용함)
    - 매개변수 없는 생성자
    - 모든 클래스는 Object 클래스에서 상속받고, Object 클래스의 메소드를 사용할 수 있으며, Object 클래스의 일부 메소드 (= final로 정의된 메소드 제외) 를 재정의하여 사용할 수 있음
    - 컴파일러가 자동으로 클래스 선언 시 뒤에 (extends Object) 를 붙였다고 생각하면 됨

- protected Object clone() throws CloneNotSupportedException
    - 객체의 복사본을 만들고 반환
    - 복제 불가능한 경우 예외 발생
    - [쉬운 설명]
        - 기본 틀 (Prototype) 으로부터 같은 속성 값을 가진 객체의 복사본을 생성할 수 있음
        - 객체지향 프로그래밍의 정보은닉에 위배되는 가능성이 있으므로 복제할 객체는 cloneable 인터페이스를 명시해야 함
    - [예시]
    ```
    class Book (implements Clonable) {
        String name, author;
        
        Book(String name, String author) {
            this.name = name;
            this.author = author;
        }
        
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }    
    }
    
    public class BookTest {
        public static void main(String[] args) {
            Book book = new Book("A", "B");
            Book copyBook = (Book)book.clone(); // Exception 발생함 = Book 이라는 클래스는 Clone 이 지원되지 않음 -> implements Clonable을 복제할 객체의 클래스에 명시해줘야 함
        }
    }    
    ```


- public boolean equals(Object obj)
    - 다른 객체와 비교해서 다른 객체와 이 객체가 같은지를 나타내는 동등성 비교를 수행
    - 내부 구현은 == 동일성 비교여서 오버라이딩을 해주지 않으면 기본적으로 동일성 비교를 수행
    - 이 메서드를 오버라이딩 할 때에는 아래에 설명할 hashCode() 메서드 또한 오버라이딩 해야함
    - [쉬운 설명]
        - 물리적으로 다른 메모리에 위치한 객체라도 논리적으로 동일함을 구현하기 위해 사용하는 메소드
        - 물리적 동일함 : 같은 주소를 가지는 객체
        - 논리적 동일함 : 같은 학번의 학생, 같은 주문 번호의 주문
    - [예시]
    ```
    Student A = new Student(100, "P");
    Student B = A;
    Student C = new Student(100, "P");
    // A와 B는 물리적 동일하지만 C는 논리적 동일함

    System.out.println(A == C); // false = 객체의 주소값을 비교함
    System.out.println(A.equals(C)); // false (재정의 하기 전까지는 == 연산자와 같음)
    
    class Student {
        int studentNum;
        String studentName;

        public Student(int studentNum, String studentName) {
            this.studentNum = studentNum;
            this.studentName = studentName;
        }
    
        @Override
        public boolean equals(Object obj) { // equals 재정의 추가
            if (obj instanceof Student) {
                Student std = (Student) obj;
                return (this.studentNum == std.studentNum);
            }
            return false;
        }
    }
    
    System.out.println(A == C); // false = 객체의 주소값을 비교함
    System.out.println(A.equals(C)); // true (재정의해서 학번을 비교하기 때문에)
    ```

- protected void finalize() throws Throwable
    - 이 객체가 HEAP 메모리에서 해제될 때 GC 에 의해서 호출되는 메소드
    - GC 가 객체에 대한 참조가 없는 경우 호출 
    - 실행될지 불확실하기 때문에 크리티컬한 코드를 여기에 두면 X
    - 리소스의 해제, 닫히지 않을 수 있던 소켓, 예외처리 등을 추가함

- public final Class getClass()
    - 객체의 런타임 클래스를 호출

- public int hashCode()
    - 객체의 해시코드 값을 반환
    - 두 객체가 같으면 해시코드도 같아야하기 때문에 equals()를 오버라이딩 할 때, hashCode() 또한 오버라이딩 해야함
    - [쉬운 설명]
        - 객체가 같다는 말은 같은 해시코드 값을 갖는다는 말과 같음
        - 해시코드는 JVM이 인스턴스가 생성됐을 때 메모리 주소를 할당하는데, 해당 메모리 주소값을 해시코드라고 함
        - hashcode() 메소드는 인스턴스가 저장된 가상머신의 주소를 10진수로 반환
        - 두 개의 서로 다른 메모리에 위치한 인스턴스가 동일하다는 것은 2가지 조건이 충족되어야 함
            - 논리적으로 동일 (equals() 의 반환값이 true)
            - 동일한 hashCode 값을 가짐 (hashCode() 의 반환 값이 동일함)
        - 실제 메모리 값은 다르지만, hashCode() 를 overriding 해서 논리적으로 같음을 나타내야 함
    - [예시]
    ```
    class Student {
        int studentNum;
        String studentName;

        public Student(int studentNum, String studentName) {
            this.studentNum = studentNum;
            this.studentName = studentName;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                Student std = (Student) obj;
                return (this.studentNum == std.studentNum);
            }
            return false;
        }
        
        @Override
        public int hashCode() { // hashCode 재정의 추가
            return studentNum;
        }
    }
    
    Student A = new Student(100, "P");
    Student B = A;
    Student C = new Student(100, "P");
    
    System.out.println(A.equals(C)); // true
    System.out.println(A.hashCode() == C.hashCode()); // true
    System.out.println(System.identityHashCode(A)); // 실제 메모리 주소값 (HASHCODE 형식으로)
    
    ```

- public String toString()
    - 객체의 문자열 형태를 반환 
    - String 의 경우 java.lang 패키지에 존재하기 때문에 String str = new String("문자"); 에서 System.out.println(str); 을 하게 되면 "문자" 가 출력되는데 이는 str.toString() 과 같음
    - 개별적으로 생성한 클래스의 경우인 Book book = new Book("책"); 에서 System.out.println(book); 을 하게 되면 객체의 주소값이 보이게 됨
    - 기본적으로는 거의 의미 없는 정보를 보여주기에 이 메서드의 오버라이딩을 통해 객체가 유용한 정보를 반환하도록 정의해야 함 

- 오버라이딩 할 수 없도록 final 로 선언된 notify(), notifyAll(), wait() 메서드는 독립적으로 실행되는 스레드간의 동기화에 사용됨

### String 클래스
- String 뿐만 아니라 Double, Integer 등 모두 인스턴스를 생성할 수 있고, 상수풀에 있는 메모리를 가리킬 수 있음
- [예시]
    ```
    String str1 = new String("abc"); // 인스턴스로 생성됨 (힙 메모리)
    String str2 = "abc"; // 상수풀에 있는 문자열을 가리킴 (리터럴들이 모여 있는 상수풀)
    String str3 = "abc";

    System.out.println(str1 == str2); // false (메모리의 위치가 다르기 때문에)
    System.out.println(str1.equals(str2)); // true (String 은 java.lang 패키지에 속해있고 내부적으로 equals 를 재정의했기 때문에 내용을 비교함)
    System.out.println(str2 == str3); // true (상수풀 내 동일한 주소를 가리키기 때문)
    ```

- String 은 immutable = 한번 선언되거나 생성된 문자열을 변경할 수 없음
- String 클래스의 concat() 메소드 혹은 "+" 를 이용하여 String 을 연결하는 경우, 문자열이 새롭게 생성됨 (새롭게 메모리를 할당해서 생성함)
- ctr1 + 클릭을 해서 String 을 검색하면, String 클래스 내 value 가 final 로 선언되어 있음
- [예시]
    ```
    String java = new String("java");
    String android = new String("android");
    String oldMem = System.identityHashCode(java);    

    java = java.concat(android);
    String newMem = System.identityHashCode(java);
    System.out.println(oldMem == newMem); // false
    ```

- String 을 계속 이어서 쓸 일이 있으면 StringBuilder 와 StringBuffer 를 사용하는 것이 좋음
    #### StringBuilder 와 StringBuffer
    - 가변적인 char[] 배열을 맴버변수로 가지고 있는 클래스
    - 문자열을 변경하거나 연결하는 경우 사용하면 편리함
    - toString() 메소드로 String 반환
    - [예시]
    ```
    String java = new String("java");
    StringBuilder buffer = new StringBuilder(java);
    
    buffer.append("android"); // javaandroid
    buffer.delete(0, 2); // vaandroid
    buffer.deleteCharAt(0); // aandroid
    buffer.insert(1, "x"); // axandroid
    buffer.reverse(); // diordnaxa
    buffer.setCharAt(4, 'i'); // diorinaxa
    buffer.setLength(10); // diorinaxa(띄어쓰기)
    buffer.setLength(4); // dior
    
    java = buffer.toString();
    
    ```

    #### StringBuilder
    - 멀티쓰레드 프로그래밍에서 동기화가 되지 않음
    - 단일쓰레드 프로그래밍에서 사용하는 것이 좋음
    
    #### StringBuffer
    - 멀티쓰레드 프로그래밍에서 동기화 (Synchronization) 이 보장됨
    
### Wrapper 클래스
|기본형|Wrapper 클래스|
|:------:|:---:|
|boolean|Boolean|
|byte|Byte|
|char|Character|
|short|Short|
|int|Integer|
|long|Long|
|float|Float|
|double|Double|

- 기본형을 감싼 클래스
- toString, hashCode, equals 등이 override 되어 있고, 앵간한 기능들이 추가되어 있음
- 자바 1.5 이전에는 int + Integer 를 위해서는 부가 작업이 필요했지만, 지금은 형변환이 필요로 하지 않음 (autoboxing 과 unboxing 이 자동으로 제공)
- 힙 메모리 내 인스턴스로 공간을 차지하게 됨

### Class 클래스
- .java 파일을 컴파일을 하고 나면 .class 파일을 생성됨
- class 파일에는 객체의 정보 (맴버변수, 메소드, 생성자 등) 가 포함되어 있음
- Class 클래스는 컴파일된 class 파일에서 객체의 정보를 가져올 수 있음
- Class 로드, Instance 생성 등 메소드 존재
- 일반적으로는 직접 다룰 기회는 없음
- Reflection 프로그래밍, 로컬에 모듈이 없는 경우, 동적 로딩할 때 주로 사용됨

- Class 클래스 가져오기
    1. String str = new String(); Class c = str.getClass(); // Object 의 메소드를 활용해서 가져옴
    2. Class c = String.Class; // 컴파일된 상태가 있을 때
    3. Class c = Class.forName("java.lang.String"); // 정적 로딩

- newInstance() 메소드
    - Class 클래스의 메소드
    - new 키워드를 사용하지 않고 객체를 생성함

- 동적 로딩 (정적 로딩 = Compile 때 Binding 이 됨)
    - Runtime 때 Binding 이 됨 (해당 Statement 를 실행할 때)
    - Class.forName 의 파라미터를 변경해서 Binding 하고 싶은 클래스를 로딩함
    - 해당 클래스가 로컬에 있으면 불러옴
    - 주로 자바의 JDBC 사용할 때 많이 쓰임
    - JDBC 관련 DB 라이브러리들을 모두 정적 링크해서 컴파일할 수 없음 (너무 많음)
    - 컴파일 타임이 아니라 그때그때 상황에 맞게 원하는 라이브러리, 클래스를 매칭할 수 있음
    - 단점 : 오타가 나게 되면 classNotFoundException 이 일어나서 프로그램이 죽을 수 있음
    - [예시]
    ```
    public static void main(String[] args) {        
        // 로컬에 클래스가 있는 경우
        Person person = new Person("James");
        System.out.println(person); // James
        
        // 로컬에 클래스가 없는 경우
        Class PC = Class.forName("myPackage.Person");

        /* 파라미터가 없는 생성자 호출 시 */
        Person foreigner = (Person)PC.newInstance();
        System.out.println(foreigner);
        
        /* 파라미터가 있는 생성자 호출 시 */
        Class[] parameterTypes = {String.class}; 
        Constructor cons = PC.getConstructor(parameterTypes); // 생성자 읽어오기
        Object[] initArgs = {"Park"}; // 파라미터 갯수만큼 넣으면 됨
        Person Korean = (Person)cons.newInstance(initArgs);
        Systemout.println(Korean);
    }
    ```

- reflection 프로그래밍
    - Class 클래스로부터 객체의 정보를 가져와 프로그래밍 하는 방식
    - 로컬에 객체가 없고 자료형을 알 수 없는 객체의 정보를 가져오는 방식
    - java.lang.relfect 패키지에 있는 클래스를 활용함
