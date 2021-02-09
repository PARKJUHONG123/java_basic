# 2주차 과제: 자바 데이터 타입, 변수 그리고 배열.md

## 목표
	자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.

## 학습할 것
### 1. 프리미티브 타입 종류와 값의 범위 그리고 기본 값
- 1byte = 8bit
- 1bit = 2진수의 한 자리
- 초기 저장 시 값의 범위를 넘어가면 컴파일 에러가 발생함
- 실행 중 저장할 수 있는 값의 범위를 초과하면 최소값부터 다시 반복 저장됨
    - byte 일 경우, -128부터 시작해서 127을 넘으면 다시 -128부터 시작함
- MSB 방식 (Most Significant Bit = 최상위 비트)
    - 예를 들어, byte 타입의 경우 127 은 0111 1111 로 표현되며, -128은 1000 0000
    - 가장 앞의 비트가 0이면 양수, 1이면 음수를 의미함
    - -3를 어떻게 MSB 방식으로 표현하는가?
        - 3의 이진수 표현 값인 0000 0011 에서 1을 뺀다
        - 0000 0010 의 보수 값을 구하면 1111 1101이 나온다
    - 반대로 MSB 방식의 값을 십진수로 변환하는 방법?
        - 1111 1101 의 보수 값을 구하면 0000 0010 이 나온다
        - 0000 0010 에서 1을 더하면 0000 0011이 나온다
        - 해당 값에 - 를 붙이면 -3으로 표현할 수 있다

#### 1. 논리형
- 색상 정보 및 파일 또는 이미지 등의 이진 데이터를 처리할 때 주로 사용됨

```
- boolean
    - 메모리 크기 : 1byte
    - 기본 값 : false
    - 저장되는 값의 범위 : true, false
```

#### 2. 정수형

자바는 기본적으로 정수 연산을 int 타입으로 수행하기 때문에 특별한 이유가 없는 한 int 타입 변수에 저장하는 것이 좋음

```
- byte
    - 메모리 크기 : 1byte
    - 기본 값 : 0
    - 저장되는 값의 범위 : -2^7 ~ 2^7 -1
    - 양수가 2^7 - 1 인 이유 : 0이 포함되기 때문

- short
	- 메모리 크기 : 2byte
	- 기본 값 : 0
	- 저장되는 값의 범위 : -2^15 ~ 2^15 - 1
    - C언어와의 호환을 위해 사용되며 비교적 자바에서는 잘 사용되지 않음

- int
	- 메모리 크기 : 4byte
    - 기본 값 : 0
    - 저장되는 값의 범위 : -2^31 ~ 2^31 - 1
    - byte 타입 또는 short 타입의 변수를 + 연산하면 int 타입으로 변환된 후 연산되고 연산의 결과 역시 int 타입이 됨
    - 자바에서 정수 연산을 4byte 로 처리하기 때문 (성능 차이 거의 없음)
    
- long
	- 메모리 크기 : 8byte
    - 기본 값 : 0L
    - 저장되는 값의 범위 : -2^63 ~ 2^63 - 1
    - 수치가 큰 데이터를 다루는 프로그램에서 사용됨
    - long 타입의 변수를 초기화할 때에는 정수값 뒤에 L 또는 l를 붙여서 컴파일러에게 알림
```

#### 3. 실수형
- 메모리 사용 크기는 정수형과 같지만, 정수 타입과 다른 저장 방식 때문에 훨씬 더 큰 범위의 값 저장 가능
- 정수와 달리 부동 소수점 방식 (floating-point) 으로 저장됨
    - 부호 + 가수 m + 지수 n 으로 표현한 방식 (ex. + m * 10^n)
    - 가수 m은 0 <= m < 1 범위의 실수
    - ex. 1.2345 는 + 0.12345 * 10^1 로 표현함
- 정수 리터럴에 10의 지수를 나타내는 E또는 e를 포함하고 있으면, 정수 타입 변수에 저장할 수 없고 실수 타입 변수에 저장해야 함
    - int var = 3000000; (O) / int var = 3e6; (X)
    - float var = 3e6f; / double var = 3e6; / double var = 2e-3;

```
- float
	- 메모리 크기 : 4byte
    - 기본 값 : 0.0F
    - 저장되는 값의 범위 : 3.4 * 10^-38 ~ 3.4 ^ 10^38
    - 부호 (1bit) + 지수 (8bit) + 가수 (23bit) = 32bit = 4byte
    - 실수 리터럴을 float 타입 변수에는 그냥 저장할 수 없기 때문에 리터럴 뒤에 f나 F를 붙여야 함
    - float var = 3.14; (X) / float var = 3.14F; (O)
    
- double
	- 메모리 크기 : 8byte
    - 기본 값 : 0.0
    - 저장되는 값의 범위 : 1.7 * 10^-308 ~ 1.7 * 10^308
    - 부호 (1bit) + 지수 (11bit) + 가수 (52bit) = 64bit = 8byte
    - 자바는 실수 리터럴의 기본 타입을 double로 간주함
```

#### 4. 문자형
- 자바는 모든 문자를 유니코드로 처리함
- 하나의 유니코드를 저장하기 위해 2byte 크기인 char 타입 제공
- 유니코드는 음수가 없기 때문에 char 타입의 변수에는 음수 값을 저장할 수 없음
- String은 기본 타입 X / 클래스 타입으로 String 변수는 참조 변수
- 문자열을 String 변수에 대입하면 문자열이 변수에 직접 저장되는 것이 아니라, String 객체가 생성되고, String 변수는 String 객체의 번지를 참조함
- char c = ''; 는 컴파일 에러가 발생하기 때문에 초기화를 하기 위해서는 char c = ' ';
- String str = ""; 은 대입해도 괜찮음

```
- char	
	- 메모리 크기 : 2byte
    - 기본 값 : '\u0000'
	- 저장되는 값의 범위 : 0 ~ 2^16 - 1
    - char c = 65; (10진수) == char c = '\u0041' (16진수);
    - char c = 'A'; 의 유니코드 값은 int uniCode = c; 를 통해 알 수 있음 (uniCode == 65)
```

### 2. 프리미티브 타입과 레퍼런스 타입
1. 프라미티브 타입
    - 저장되는 값이 실제 값 그 자체 (실제 값이 변수에 저장됨)
    - 정수형 (byte, short, int, long), 실수형 (float, double), 논리형 (boolean), 문자형 (char)

2. 레퍼런스 타입
    - 저장되는 값이 메모리의 주소값 (참조 값이 변수에 저장됨)
    - 클래스 타입, 인터페이스 타입, 배열 타입, 열거 타입
    - 전체적으로 Call by Value를 따르면서 레퍼런스 타입의 참조 값 방식을 적용함
        - 얕은 복사 : 주소값을 복사하여 동일한 Garbage Collection Heap 영역의 객체 참조
        - 깊은 복사 : 프라미티브 타입에서의 값에 의한 복사처럼 완전히 똑같은 새로운 객체를 만들어 복사함

```
public class Data {
	public int value = 1;
}

public class test {
	public static void main(String[] args) {
		Data obj1 = new Data();
		Data obj2 = obj1; 
    	obj2.value = 3;
        // obj1과 obj2는 같은 참조 값을 가지고 있고, 참조 값은 new Data()가 만든 객체이기 때문에 obj1.value 또한 3 
    }
}
```

```
public class test {
	public static void main(String[] args) {
		String name = "park";
        int age = 17;
        
        // 레퍼런스 타입의 name 변수와 프라미티브 타입의 age 변수는 JVM의 Runtime Data Area 중 Runtime Stack 영역에 저장됨
        // 레퍼런스 타입의 값인 주소 값과, 프라이미티브 타입의 값인 17 역시 Runtime Stack 영역에 저장됨
        // 다만, 레퍼런스 타입의 값인 주소값이 가리키는 실제 값 "park" 은 JVM의 Runtime Data Area 중 Garbage Collection Heap 영역에 객체가 생성됨        
    }
}

```


### 3. 리터럴 (대입 연산자를 기준으로 모든 우항의 값들)
- 정수 리터럴 (byte, char, short, int, long)
    1. 소수점이 없는 정수 리터럴 (10진수)
        - ex. 0, 75, -100
    2. 0으로 시작되는 리터럴 (8진수)
        - ex. 02, -04
    3. 0x 또는 0X로 시작하고 16진수로 표현된 리터럴 (16진수)
        - ex. 0x5, 0xA, 0xB3, 0xAC08

- 실수 리터럴 (float, double)
    1. 소수점이 있는 리터럴 (10진수)
        - ex. 0.25, -3.14
    2. E 또는 e가 있는 리터럴 (10진수 지수와 가수)
        - ex. 5E7 (= 5 x 10^7), 0.12E-5 (= 0.12 x 10^-5)

- 문자 리터럴 (char)
    - ex. 'A', '한', '\t', '\n'

- 문자열 리터럴 (String)
    - ex. "대한민국", "탭만큼 이동 \t 합니다", "한줄 내려쓰기 \n 합니다"

- 논리 리터럴 (boolean)
    - ex. true, false


### 4. 변수 선언 및 초기화하는 방법
```
public class test {
	public static void main(String[] args) {
		    char char_err = ''; // 컴파일 에러
            char char_v1 = ' ';
            String str_v1 = "";
            
            int int_v1 = 10, int_v2, int_v3;
            int_v2 = 30, int_v3 = 50;
            double double_v1 = 3.14d;
            boolean boolean_v1 = 12 > 34, boolean_v2 = true;
            
            Engine engine = new Engine(); // 참조형 변수의 초기화            
    }
}

```

```
public class blockTest {
	public static void main(String[] args) {
    	System.out.println("blockTest bt_1 = new blockTest()");
		blockTest bt_1 = new blockTest();
        
        System.out.println("blockTest bt_2 = new blockTest()");
        blockTest bt_2 = new blockTest();
	}
}

// 클래스 초기화 블럭
static {
	System.out.println("static{} : class init block");
}

// 인스턴스 초기화 블럭
{
	System.out.println("{} : instance init block");
}

// 생성자
public blockTest {
	System.out.println("blockTest() : constructor");
}

```

```
static{} : class init block
blockTest bt_1 = new blockTest()
{} : instance init block
blockTest() : constructor

blockTest bt_2 = new blockTest()
{} : instance init block
blockTest() : constructor

- 클래스 초기화 블럭, 인스턴스 블럭, 생성자 순으로 진행됨
- 클래스 초기화 블럭의 경우, 메모리에 로딩될 때 한번만 초기화
- 인스턴스 블럭과 생성자의 경우, 인스턴스가 생성될 때마다 초기화
```


### 5. 변수의 스코프와 라이프타임

```
public class test {
	static int value = 10;
	public static void main(String[] args) {
    	int value = 30;
        System.out.println("result = " + value); // result = 30
        // 즉 자신과 가까운 블록 스코프에서 찾고, 없을 경우 상위 블록 스코프에 존재하는지 탐색함
        
        emptyClass ec = new emptyClass(); 
        // JVM의 Runtime Data Area 중 Runtime Stack 영역에 ec 변수가 생성되고, 변수는 Garbage Collection Heap 영역에 생성된 new emptyClass() 로 만들어진 객체가 저장된 주소 값을 가지고 있다
        
        ec = null; 
        // Runtime Stack 영역의 ec 변수의 값인 주소값에 null을 할당하면, new emptyClass()로 만든 이 객체는 더 이상 아무도 참조하지 않으므로 Garbage Collection 의 대상이 됨
        // Runtime Stack 영역에 생성된 변수의 라이프 타임은 블록 스코프에 의존적임
        // 블록 내에서 선언된 변수는 블록이 종료될 때 Runtime Stack 영역에서 함께 소멸함
    }
}

class emptyClass {

}
```



### 6. 타입 변환, 캐스팅 그리고 타입 프로모션
- 데이터 타입을 다른 데이터 타입으로 변환하는 것

1. 자동 (묵시적) 타입 변환 (Promotion)
    - 프로그램 실행 도중 자동적으로 타입 변환이 일어나는 것
    - 작은 크기를 가지는 타입이 큰 크기를 가지는 타입에 저장될 때 발생
    - 큰 크기의 타입 = 작은 크기의 타입
    - byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
        - 표현할 수 있는 값의 범위가 long보다 float이 더 크기 때문에 Promotion
    - char 는 2byte의 크기를 가지지만 범위가 0~2^16 - 1 이므로 음수가 저장될 수 없기 때문에 음수가 저장될 수 있는 byte 타입을 char 타입으로 자동 변환시킬 수 없음

```
byte byteValue = 10;
int intValue = byteValue; // 10

int intValue = 100;
double doubleValue = intValue; // 100.0

char charValue = 'A';
int intValue = charValue; // 65 (char 타입의 경우 int 타입으로 변환 시 유니코드 값 저장)

byte byteValue = 65;
char charValue = byteValue; // 컴파일 에러
char charData = (char) byteValue; // 강제 타입 변환으로 가능

```


2. 강제 (명시적) 타입 변환 (Casting)
    - 큰 크기의 타입은 작은 크기의 타입으로 자동 타입 변환이 불가능함
    - int 타입을 4개의 byte로 쪼갠 다음에 끝에 있는 1byte만 byte 타입 변수에 저장하는 것은 가능함
    - 강제적으로 큰 데이터 타입을 작은 데이터 타입으로 쪼개어서 저장하는 것
    - 작은 크기 타입 = (작은 크기 타입) 큰 크기의 타입
    - 값의 손실이 발생하면 안되기 때문에 안전하게 값이 보존될 수 있는지 검사하는 것이 필요함
        - ~.MIN_VALUE, ~.MAX_VALUE
        - byte : Byte
        - short : Short
        - int : Integer
        - long : Long
        - float : Float
        - double : Double

```
int intValue = 103029770; // 00000110 00100100 00011100 00001010
byte byteValue = (byte) intValue; // 끝에 있는 00001010 이 byteValue 에 저장됨 (10)
System.out.println(byteValue); //10

int intValue = 'A';
char charValue = (char) intValue;
System.out.println(charValue); // 65

// 실수 타입의 정수 타입으로 강제 변환의 경우, 소수점 이하 부분은 버려지고 정수만 저장
double doubleValue = 3.14;
int intValue = (int) doubleValue;
System.out.println(intValue); // 3

```

```
// 강제 변환 전 사전 검사
public class test {
	public static void main(String[] args) {
    	double doubleValue = 123.456789;
        
        if ( (doubleValue < Byte.MIN_VALUE) || (doubleValue > Byte.MAX_VALUE) ) {
        	System.out.println("변환 불가 - 손실 발생");
        }
        else {
			byte B = (byte) doubleValue;
            System.out.println("변환 가능");
        }
	}
}

```

```
int intValue = 10;
double doubleValue = 5.5;
double result = intValue + doubleValue; // 서로 다른 타입의 피연산자가 있을 경우, 두 피연산자 중 크기가 큰 타입으로 자동 변환된 후 연산 수행

// 자바의 정수 연산은 int 타입을 기본으로 함 (피연산자를 4byte 단위로 저장하기 때문)
char ai = 'A';
int result = ai + 1;
char na = (char) result; // 'B' 가 저장됨

byte byteValue1 = 10, byteValue2 = 20;
byte byteResult = byteValue1 + byteValue2; // 컴파일 에러
int intResult = byteValue1 + byteValue2;

char charValue1 = 'A', charValue2 = 1;
char charResult = charValue1 + charValue2; // 컴파일 에러
int intResult = charValue1 + charValue2;
System.out.println("유니코드 : " + intResult + " 출력문자 : " + (char)intResult);

int intValue = 10;
int intResult = intValue / 4;
System.out.println(intResult); // 2

int intValue = 10;
int intResult = intValue / 4.0; // 컴파일 에러
double doubleResult = intValue / 4.0;
System.out.println(doubleResult); // 2.5

```

### 7. 1차 및 2차 배열 선언하기

```

public class test {
    public static void main(String[] args) {
    	// 크기 할당과 초기화 없이 배열 참조변수만 선언하기
    	int[] arr;
        int arr[];
        
        // 선언과 동시에 배열 크기 할당하기
        // 배열의 크기는 최초 선언한 값으로 고정됨
        int[] arr = new int[5];
        String[] arr = new String[5];
        
        // 기존 배열의 참조 변수에 초기화 할당하기
        int[] arr;
        arr = new int[5]; // {0, 0, 0, 0, 0}        

		// 5의 크기를 가지고 설정한 값을 가진 배열 생성하기
		int[] arr = {1, 2, 3, 4, 5};
        
        // 선언과 동시에 배열의 크기 지정 및 값 초기화
        String[] weeks = {'월', '화', '수', '목', '금', '토', '일'};
        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int number : arr) {
        	System.out.println(number);
        }
        
        // 객체 배열 선언
        Student[] studentArr = new Student[5]; // Student 클래스의 인스턴스 최대 5개를 할당할 수 있는 배열 - 엘리먼트의 초기값이 null 임
        studentArr[0] = new Student(); // 초기화가 필요함
        
        // 2차원 배열 선언
        int[][] arr = new int[4][3]; // 3 크기의 int 1차원 배열을 4개 생성
        int[][] arr = { {2, 5, 3}, {4, 4, 1}, {1, 7, 3}, {3, 4, 5} };
    }
}

```

### 8. 타입 추론, var
- Java 10부터 var 키워드를 통해 변수 선언 가능
- 컴파일러가 우항에 초기화 값으로 제공되는 것을 통해 타입을 유추함
- 초기화 값이 있는 지역변수로만 선언 가능함
- 맴버변수, 메소드의 파라미터, 리턴 타입으로 사용 불가능
- 키워드가 아님 = 어떠한 타입도 아니고, 클래스에서 사용할 수 있는 예약어가 아님
    - int var = 3; 이 가능함
- 런타임 오버헤드가 없음
    - 컴파일 시점에서 var를 초기화된 값을 보고 추론함 : 바이트코드에 명시적으로 int는 int다, string은 string 이다라고 결정되어 있는 상태
    - 타입추론 변수를 읽을 때마다 타입을 알아내기 위한 연산을 하지 않음
    - var로 선언된 변수는 중간에 타입이 절대 변경되지 않음
```
// var 를 사용했을 때
// 기존 코드
Map<String, List<String>> countryToCity = new HashMap<>();
// ...
for (Map.Entry<String, List<String>> citiesInCountry : countryToCity.entrySet()) {
  List<String> cities = citiesInCountry.getValue();
  // ...
}
Consumer<String> testFoo = s -> System.out.println("s = " + s);

// var를 사용한 코드
var countryToCity = new HashMap<String, List<String>>();
// ...
for (var citiesInCountry : countryToCity.entrySet()) { // for each문에서 사용 가능
  var cities = citiesInCountry.getValue();
  // ...
}
Consumer<String> testFoo = (var s) -> System.out.println("s = " + s);
Consumer<String> testFoo = (@Nonnull var s) -> System.out.println("s = " + s);
```

```
public class VarDemo {
    // var a = 1; // var는 지역변수에서만 사용 가능
    public static void main(String[] args) {
    	// private var i = "No member variable" // 맴버 변수에 사용 불가능
        // var x = 1, y = 2; // ,와 함께 사용 불가능
        // var arr = { 6 }; // 배열의 선언자로 사용 불가능
        var arr : Int = { 6 }; 
                
        // var arr[] = new int[4]; // 불가능
        // var messages = new ArrayList<>(); // 컴파일러가 타입을 유추할 수 있는 정보가 없음
        
        // var str = null; // null은 String에서만 사용할 수 있는 것이 아니므로 타입 추론 불가능 
        
        // var err; // var를 사용할 때는 초기화를 바로 해야 함 (타입 추론이 불가능하므로)
        // err = 1;
        
        // var l = () -> {} // 람다식에서 사용 불가능
        var l : <lambda expression> = (String s) -> System.out.println("s = " + s);
        // var obj = (obj = 7); // 선언자에서 자기 참조 불가능
    }
    // void test(var x) {} // 메소드의 인수타입은 지역변수여도 var 사용 불가
}

```