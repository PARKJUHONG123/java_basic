## 목표
    컬렉션 프레임워크과 내부클래스에 대해 학습하세요

## 학습할 것 (필수)
- 컬렉션 프레임워크의 정의
- List 인터페이스
- Stack 과 Queue 구현
- Set 인터페이스
- Map 인터페이스
- 내부클래스

## 컬렉션 프레임워크
- 프로그램 구현에 필요한 자료구조와 알고리즘을 구현해 놓은 라이브러리
- java.uitl 패키지에 구현되어 있음
- Collection 인터페이스와 Map 인터페이스로 구성됨

1. Collection 인터페이스
	- 하나의 객체의 관리를 위해 선언된 인터페이스로 기본 메소드가 선언되어 있음
	- 하위에 List, Set 인터페이스가 있음
		- List
			- ArrayList (Array 구조, Vector 보다 최적화되어 있음)
			- Vector (Array 구조)
			- LinkedList
		- Set
			- HashSet
			- TreeSet

2. Map 인터페이스
	- 쌍으로 이루어진 객체를 관리하는데 필요한 여러 메소드가 선언되어 있음 (Pair)
	- Map 을 사용하는 객체는 KEY-VALUE 쌍으로 되어 있고, KEY는 중복될 수 없음
		- Hashtable (Hashtable의 75% 정도 차게 되면 크기를 확장함 - Hashset 과 HashMap 또한 Hash 함수를 사용하기 때문에 Hashtable 을 내부적으로 사용함)
			- Properites
		- HashMap
		- TreeMap

### [참고] Iterator
- Collection 의 개체를 순회하는 인터페이스
- iterator() 메소드 호출
	- ex. Iterator<E> ir = memberArrayList.iterator();

- Iterator 에 선언된 메소드
	- (boolean) hashNext()
		- 이후에 요소가 더 있는지를 체크하는 메소드
		- 요소가 있으면 true 반환
	- (E) next()
		- 다음에 있는 요소 반환

## List 인터페이스
- 순서가 있는 자료 관리, 중복 허용
	- get(int index) 메소드를 통해 순회
- ArrayList 와 Vector
- 객체 배열 클래스
- Vector 
	- 자바 2부터 제공된 클래스
	- 멀티 쓰레드 프로그램에서 동기화 지원
		- 단일 쓰레드에서는 동기화가 오버헤드가 됨
	- 두 개의 쓰레드가 동시에 하나의 리소스에 접근할 때 순서를 맞춰서 데이터의 오류가 일어나지 않도록 방지함
	- capacity 와 size 의 차이점
		- capacity : 배열의 용량 
		- size : 배열 내에 몇 개의 요소가 들어있는지 나타냄

- ArrayList
	- 단일 쓰레드에서 많이 사용됨
	- 논리적으로 순차적 구조
	- 물리적으로 순차적 구조
	
- LinkedList
	- 논리적으로 순차적 구조
	- 물리적으로 순차적이지 않을 수 있음

## Set 인터페이스
- 순서가 없는 자료 관리, 중복 허용 X

