## 목표
    자바의 람다식에 대해 학습하세요.

## 학습할 것 (필수)
- 내부 클래스
- 람다식 사용법
- 함수형 인터페이스
- Effectively final (유사 파이널)
- Variable Capture
- 메소드, 생성자 레퍼런스
- 스트림
- 클로저

## 내부 클래스
- 클래스 내부에 구현한 클래스 (중첩된 클래스)
- 클래스 내부에서 사용하기 위해 선언하고 구현한 클래스
- 주로 외부 클래스 생성자에서 내부 클래스를 생성
- 종류
    - Instance Inner Class
    - Static Inner Class
    - Local Inner Class
    - Annonymous Inner Class
  
## 람다식
- 자바에서 함수형 프로그래밍 (functional programming) 을 구현하는 방식
- 클래스를 생성하지 않고 함수의 호출만으로 기능을 수행
- 함수형 인터페이스를 선언함
- 자바 8부터 지원되는 기능

- 순수 함수 (pure function) 를 구현하고 호출
- 매개 변수만을 사용하도록 만든 함수
- 외부 자료에 부수적인 영향 (side effect) 가 발생하지 않도록 함
- 입력 받은 자료를 기반으로 수행되고 외부에 영향을 미치지 않으므로 병렬처리 등에 적용
- 안정적이고 확장성 있는 프로그래밍 방식

### 람다식 문법
- 매개변수 하나인 경우 괄호 생략가능 (두 개인 경우는 괄호 생략불가)
  - str -> {System.out.println(str);}
- 중괄호 안의 구현부가 한 문장인 경우 중괄호 생략
  - str -> System.out.println(str);
- 중괄호 안의 구현붑가 한 문장이라도 return 문은 생략할 수 없음
  - str -> return str.length();
- 중괄호 안의 구현부가 return 문 하나라면 return 과 중괄호 모두 생략 가능
  - (x, y) -> x + y   // 두 값을 더하여 반환
  - str -> str.length() // 문자열 길이를 반환

### 람다식 변수
- 자바 프로그램에서 변수는
  - 자료형에 기반하여 선언하고 // int a;
  - 매개변수로 전달하고 // int add(int x, int y);
  - 메소드의 반환 값으로 사용 // return num;
  
- 람다식은 프로그램 내에서 변수처럼 사용 가능함 (람다식 = 변수)

## 메소드 레퍼런스
- 메소드 레퍼런스 형태
  - 클래스::인스턴스 메소드 (public)
    - 첫번째 파라미터가 메소드의 수신자가 되고, 나머지 파라미터는 해당 메소드로 전달됨
      ```
      - [메소드 레퍼런스] String::compareToIgnoreCase
      - [람다식] (x, y) -> x.compareToIgnoreCase(y)
      ```
  - 클래스::정적 메소드 (static)
    - 모든 파라미터가 정적 메소드로 전달됨
      ```
      - [메소드 레퍼런스] Object::isNull
      - [람다식] x -> Object.isNull(x)
      ```

  - 객체::인스턴스 메소드 (new)
    - 주어진 객체에서 메소드가 호출되며 파라미터는 인스턴스 메소드로 전달됨
      ```
      - [메소드 레퍼런스] System.out::println
      - [람다식] x -> System.out.println(x)
      ```
 
- 메소드 레퍼런스 예제
  - [일반식] 리스트를 순회하며 각 요소를 출력하는 예제 코드
    ```
    String[] str = new String[] {
      "A", "B", "C"
    };
    List<String> list = Arrays.asList(str);
    for (String s : str) {
      System.out.println(s);
    }
    ```

  - [람다식] 자바8의 ArrayList 클래스의 forEach 메소드
    ```
    String[] str = new String[] {
      "A", "B", "C"
    };
    List<String> list = Arrays.asList(str);
    list.forEach(x -> System.out.println(x));

    /*
    - forEach 메소드는 매개변수로 Consumer Interface 를 전달받음
    - Consumer 가 구현해야 되는 accept 메소드가 실행될 때 list의 요소를 입력받고
    - 단순히 println 메소드를 한번 더 실행해주는 형태 (메소드의 Call Stack 이 1Depth 깊어진 형태)
    */
    ```

  - [메소드 레퍼런스] System 클래스가 가진 println 메소드를 forEach 에 전달하는 방식
    ```
    String[] str = new String[] {
      "A", "B", "C"
    };
    List<String> list = Arrays.asList(str);
    list.forEach(System.out::println);

    /*
    - forEach 에게 println 을 전달함
    - :: 연산자는 메소드 이름과 클래스를 분리하거나, 메소드 이름과 객체의 이름을 분리
    */
    ```

## 생성자 레퍼런스
- 생성자 레퍼런스 형태

|함수형 인터페이스|파라미터 타입|반환 타입|추상 메소드명|설명|다른 메소드|
|:---:|:---:|:---:|:---:|:---:|:---:|
|Runnable| 없음| void| run| 인자나 반환 값 없이 액션을 수행한다.|	없음|
Supplier|	없음|	T|	get| T 타입 값을 공급한다.|	없음|
Consumer|	T|	void|	accept|	T 타입 값을 소비한다.|	andThen|
BiConsumer<T, U>|	T, U|	void|	accept|	T와 U타입 값을 소비한다.|	andThen|
Function<T, R>|	T|	R|	apply|	T 타입 인자를 받는 함수다.|	compose, andThen, identity|
BiFunction<T, U, R>|	T, U|	R|	apply|	T와 U타입 인자를 받는 함수다.|	andThen|
UnaryOperator|	T|	T|	apply|	T 타입에 적용하는 단항 연산자다.|	compose, andThen, identity|
BinaryOperator|	T, T|	T|	apply|	T 타입에 적용하는 이항 연산자다.|	andThen, maxBy, minBy|
Predicate|	T|	boolean|	test|	Boolean 값을 반환하는 함수다.|	and, or, negate, isEqual|
BiPredicate<T, U>|	T, U|	boolean|	test|	두 가지 인자를 받고 boolean 값을 반환하는 함수다.|	and, or, negate

- 생성자 레퍼런스 예제
  ```
  @Data
  class Person {
      private String name;
      private String gender;

      public Person() {}

      public Person(String name) {
          this.name = name;
      }

      public Person(String name, String gender) {
          this.name = name;
          this.gender = gender;
      }
  }
  ```
  - [일반식] 객체 생성
  ```
  Person member1 = new Person();
  Person member2 = new Person("John");
  Person member3 = new Person("John", "M");
  ```

  - [람다식] 객체 생성
  ```
  Function<String, Person> constructFunc = name -> new Person(name);
  ```

  - [메소드 레퍼런스] 객체 생성
  ```
  Function<String, Person> constructFunc1 = Person::new;
  myFunction.apply("John");

  BiFunction<String, String, Person> constructFunc2 = Person::new;
  myFunction1.apply("John", "M");
  ```

## 스트림
- I/O 의 스트림과는 다름
- 자료의 대상과 관계없이 동일한 연산을 수행할 수 있는 기능 (자료의 )
- 배열, 컬렉션에 동일한 연산이 수행되어 일관성 있는 처리 가능
- 한번 생성하고 사용한 스트림은 재사용할 수 없음
- 스트림 연산은 기존 자료를 변경하지 않음
- 중간 연산과 최종 연산으로 구분됨
- 최종 연산이 수행되어야 모든 연산이 적용되는 지연 연산 (중간에 소팅된 결과를 볼 수 없음)

### 중간 연산
- 가장 많이 쓰는 연산 : filter(), map()
- 조건에 맞는 요소를 추출 (filter()) 하거나 요소를 변환함 (map())
- ex. 문자열의 길이가 5 이상인 요소만 출력하기
  sList.stream().filter(s -> s.length() >= 5).forEach(s -> System.out.println(s));
  스트림 생성 . 중간 연산 . 최종 연산
- ex. 고객 클래스에서 고객 이름만 가져오기
  customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
  스트림 생성 . 중간 연산 . 최종 연산

### 최종 연산
- 스트림의 자료를 소모하면서 연산을 수행
- 최종 연산 후에 스트림은 더 이상 다른 요소에서 적용 불가능
- 가장 많이 쓰이는 연산 : forEach(), count(), sum() 등
- reduce() 연산
  - 정의된 연산이 아닌 프로그래머가 직접 정의한 연산을 사용
  - 최종 연산으로 스트림의 요소를 소모하며 연산 수행
  - ex. 배열의 모든 요소의 합을 구하는 reduce() 연산
    Arrays.stream(arr).reduce(0, (a, b) -> a + b);
  - 첫 번째 요소는 초기값임
  - 두 번째 요소로 전달되는 람다식에 따라 다양한 기능을 수행함



## 클로저
- 외부 범위의 함수를 함수 내부로 바인딩하는 기술
- 자신을 둘러싼 Context 내의 변수에 접근할 수 있음
- 자신을 둘러싼 외부 함수가 종료되더라도 이 값이 유지가 됨
- 함수에서 사용하는 값들은 클로저가 생성되는 시점에 정의되고 함수 자체가 복사되어 따로 존재하기 때문
- 익명 클래스에 함수 캡쳐본을 넘겨줌 (마치 스냅샷처럼)

### Variable Capture
- 컴파일러는 이 필요한 정보를 복사해서 넘겨줌

### 람다와 클로저의 공통점과 차이점
- 결론
  - 람다는 클로저를 포함하는 더 큰 개념
  - 람다가 자신의 범위 밖에 있는 변수를 사용하면 람다인 동시에 클로저라고 할 수 있음

- 공통점
  - 모두 익명의 특정 기능 블록

- 차이점
  - Lambda
    - (server) -> server.isRunning()
    - 자신이 받는 매개변수만 참조함
    - 외부에 의존성이 없는 Static Method 와 비슷함
    - 예시
      ```
      static <T> void waitFor(T input, Predicate<T> predicate) throws InterruptedException {
        while (!predicate.test(input)) {
          Thread.sleep(250);
        }
      }
      ```
      ```
      waitFor(new HttpServer(), (server) -> !server.isRunning()); // 매개변수 참조
      waitFor(new HttpServer(), HttpServer::isRunning); // 메소드 참조
      ```


  - Closure
    - () -> server.isRunning() // 외부의 server 라는 변수를 참조
    - 외부 변수를 참조함
    - 외부에 의존성이 있는, 외부 변수를 참조하는 익명 클래스와 비슷함
    - 예시
      ```
      static <T> void waitFor(Condition condition) throws InterruptedException {
        while (!condition.isSatisfied()) {
          Thread.sleep(250);
        }
      }

      @FunctionalInterface
      interface Condition {
        boolean isSatisfied();
      }
      ```
      ```
      void closure() throws InterruptedException {
        HttpServer server = new HttpServer(); // 외부 변수
        waitFor(() -> !server.isRunning()); // 외부 변수 참조
      }
      ```
      ```
      // 클로저는 외부 변수를 참조하는 익명 클래스와 같은 역할을 함
      void anonymousClassClosure() throws InterruptedException {
        HttpServer server = new HttpServer(); // 외부 변수
        waitFor(new Condition() {
          @Override
          public boolean isSatisfied() {
            return !server.isRunning(); // 외부 변수 참조
          }
        });
      }
      ```
