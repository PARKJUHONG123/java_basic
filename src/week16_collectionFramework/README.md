## 목표
    컬렉션 프레임워크과 내부클래스에 대해 학습하세요

## 학습할 것 (필수)
- 컬렉션 프레임워크의 정의
- List 인터페이스
- Stack 과 Queue 구현
- Set 인터페이스
- Map 인터페이스

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


## Collection 인터페이스
### 1. List 인터페이스
- 순서가 있는 자료 관리, 중복 허용
	- get(int index) 메소드를 통해 순회
- 종류
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

### 2. Set 인터페이스
- 순서가 없는 자료 관리, 중복 허용 X
- List는 순서기반의 인터페이스지만, Set은 순서가 없음
- get(int index) 메소드가 제공되지 않기 때문에 Iterator 로 순회해야 함
- 저장된 순서와 출력 순서가 다를 수 있음
- 아이디, 주민번호, 사번 등 유일한 값이나 객체를 관리할 때 사용함

- 종류
	- HashSet
		- 중복을 허용하지 않으므로 저장되는 객체의 동일함 여부를 알기 위해 equals() 와 hashCode() 메소드를 재정의해야 함
	- TreeSet
		- 객체의 정렬에 사용되는 클래스
		- 중복을 허용하지 않으면서 오름차순이나 내림차순으로 객체를 정렬함
		- 내부적으로 이진 검색 트리 중 Red-Black Tree 로 구현되어 있음
		- 이진 검색 트리에 자료가 저장될 때, 비교하여 저장될 위치를 정함
		- 객체 비교를 위해 Comparable 이나 Comparator 인터페이스를 구현해야 함

#### [참고] Iterator
- Collection 의 개체를 순회하는 인터페이스
- iterator() 메소드 호출
	- ex. Iterator<E> ir = memberArrayList.iterator();

- Iterator 에 선언된 메소드
	- (boolean) hashNext()
		- 이후에 요소가 더 있는지를 체크하는 메소드
		- 요소가 있으면 true 반환
	- (E) next()
		- 다음에 있는 요소 반환

## Map 인터페이스
- [Key : Value] Pair 의 객체를 관리하는데 필요한 메소드가 정의됨
- Key 는 중복될 수 없음
- 검색을 위한 자료 구조
- Key 를 이용하여 값을 저장하거나 검색, 삭제할 때 사용하면 유용함
- 내부적으로는 hash 방식으로 구현됨 
	- ex. int index = hash(key);
- key 가 되는 객체는 객체의 유일 여부를 알기 위해 equals() 와 hashCode() 메소드를 재정의함

### HashMap 클래스
- Map 인터페이스를 구현한 클래스 중 가장 일반적으로 사용하는 클래스
- HashTable 클래스는 자바 2부터 제공된 클래스로 Vector 처럼 동기화 제공
- Pair 자료를 쉽고 빠르게 관리할 수 있음

## TreeMap 클래스
- Key 객체를 정렬하여 Key-Value 를 Pair 로 관리하는 클래스
- Key 에 사용되는 클래스에 Comparable, Comparator 인터페이스를 구현해서 사용함
- Java 의 많은 클래스들은 이미 Comparable 이 구현되어 있기 때문에 구현된 클래스를 Key로 사용하는 경우는 구현할 필요가 없음

```
	public final class Integer extends Number implements Comparable<Integer> {
		...
		public int compareTo(Integer anotherInteger) {
			return compare(this.value, anotherInteger.value);
		}
	}
```