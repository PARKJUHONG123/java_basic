## 목표
    자바의 제네릭에 대해 학습하세요.

## 학습할 것 (필수)
- 제네릭 사용법
- 제네릭 주요 개념 (바운디드 타입, 와일드 카드)
- 제네릭 메소드 만들기
- Erasure

### 제네릭 프로그래밍
- 컬렉션 프레임워크에 모두 적용되어 있음
- c++ 의 템플릿 클래스와 유사함
- JAVA 5 부터 적용됨

- 변수의 선언이나 메소드의 매개변수를 하나의 참조 자료형이 아닌 여러 자료형으로 변환될 수 있도록 프로그래밍하는 방식
- 실제 사용되는 참조 자료형으로의 변환은 컴파일러가 검증하므로 안정적인 프로그래밍 가능
- 컴파일 타임에 타입에 대한 안정성을 보장받을 수 있음
- 런타임에서 ClassCastException 과 같은 UnCheckedException 을 보장받을 수 있음

### 자료형 매개 변수 T
- 여러 참조 자료형으로 대체될 수 있는 부분을 하나의 문자로 표현
- type 의 의미로 T 를 주로 사용함
```
public class GenericPrinter<T> { // 제네릭 클래스
	private T material;
	
	public void setMaterial(T material) {
		this.material = material;
	}
	
	public T getMaterial() {
		return material;
	}
}
```

### 제네릭과 배열의 차이
1. 배열은 공변이고, 제네릭은 불공변이다.
- 공변 : 자기 자신과 자식 객체로 타입 변환을 허용하는 것
	- Object[] before = new Long[1];
	- Object 가 Long 의 상위 클래스이기 때문에 변환 허용
	
- 불공변 : 자기와 타입이 같은 것만 같다고 인식함
	- List<String> 과 List<Object> 는 서로 전혀 관련없는 타입
	- [예시]
	```
	public class Test {
		public static void test(List<Object> list) { }
		
		public static void main(String[] args) {
			List<String> list = new ArrayList<>();
			list.add("Gummy");
			test(list); // 컴파일 에러 발생 (List<String> 과 List<Object> 는 서로 다르기 때문)
		}
	}
	```

2. 배열은 구체화되고, 제네릭은 비구체화된다.
- 구체화 : 자신의 타입 정보를 런타임에서도 알고 있음
- 비구체화 : 런타임에는 소거 (Erasure) 가 되기 때문에 컴파일 타임보다 정보를 적게 가지는 것

### Erasure (Java 컴파일러의 타입 소거)
1. unbounded Type(<?>, <T>)는 Object로 변환
```
// 컴파일 할 때 (타입 소거 전) 
public class Test<T> {
    public void test(T test) {
        System.out.println(test.toString());
    }
}
```

```
// 런타임 때 (타입 소거 후)
public class Test {
    public void test(Object test) {
        System.out.println(test.toString());
    }
}
```

2. bound type(<E extends Comparable>)의 경우는 Object가 아닌 Comparable로 변환
```
// 컴파일 할 때 (타입 소거 전) 
public class Test<T extends Comparable<T>> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
```
```
// 런타임 때 (타입 소거 후)
public class Test {
    private Comparable data;

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }
}
```

3. 제네릭 타입을 사용할 수 있는 일반 클래스, 인터페이스, 메소드에만 소거 규칙을 적용함
4. 타입 안정성 보존을 위해 필요하다면 type casting을 넣음
5. 확장된 제네릭 타입에서 다형성을 보존하기 위해 bridge method를 생성
  
```
// 컴파일 할 때 (타입 소거 전) 
public class MyComparator implements Comparator<Integer> {
   public int compare(Integer a, Integer b) {
      //
   }
}
```
```
// 런타임 때 (1. 타입 소거 후)
public class MyComparator implements Comparator {
   public int compare(Integer a, Integer b) { // compare 메소드의 매개변수 타입을 Object 로 변환할 수 없음
      //
   }
}
```
```
// 런타임 때 (2. 메소드 시그니처 사이의 불일치를 없애기 위해 bridge method 생성)
public class MyComparator implements Comparator<Integer> {
   public int compare(Integer a, Integer b) {
      //
   }

   //bridge method
   public int compare(Object a, Object b) {
      return compare((Integer)a, (Integer)b); // type casting
   }
}
```

### 와일드카드
- 제네릭 타입이지만 정보를 기억하지 못하고 그때그때 사용하는, 즉 지속력 없는 제네릭 타입

```
List<? extends Number> wildCardTest(List<? extends Number> list, List<? extends Number> list2) {
	list.add(list.get(0)); // 컴파일 에러 발생
	// 와일드 카드의 경우 반환값 타입을 보장할 수 없음
}

<T extends Number> List<T> genericMethodTest(List<T> list, List<T> list2) {
	list.add(list.get(0));
	// 제네릭 타입은 하나의 타입 T로 선언된다면 반환값에 명시된 T도 파라미터의 들어간 T와 같은 타입임을 보장할 수 있음
}
```