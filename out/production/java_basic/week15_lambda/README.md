## 목표
    자바의 람다식에 대해 학습하세요.

## 학습할 것 (필수)
- 내부 클래스
- 람다식 사용법
- 함수형 인터페이스
- Variable Capture
- 메소드, 생성자 레퍼런스
- 스트림

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

