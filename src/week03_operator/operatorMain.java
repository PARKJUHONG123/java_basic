package week03_operator;
/*
- 산술 연산자
- 비트 연산자
- 논리 연산자
- instanceof
- 화살표(->) 연산자
- (optional) Java 13. switch 연산자
*/

public class operatorMain {
    final static String line = "------------------------------------------";
    public static void main(String[] args) {
        arithmeticOperator ao = new arithmeticOperator();
        ao.func();
        System.out.println(line);

        bitOperator bo = new bitOperator();
        bo.func();
        System.out.println(line);

        boolOperator boo = new boolOperator();
        boo.func();
        System.out.println(line);

        instanceofClass ic = new instanceofClass();
        ic.func();
        System.out.println(line);

        arrowOperator aro = new arrowOperator();
        aro.func();
        System.out.println(line);

        switchOperator so = new switchOperator();
        so.func();
        System.out.println(line);

    }
}

class switchOperator {
    void func() {
        System.out.println(switchBasic("a"));
    }

    private static int switchBasic(String str) {
        int result;
        switch(str) {
            case "a":
            case "b":
                result = 1;
                break;
            case "c":
                result = 2;
                break;
            default:
                result = -1;
        }
        return result;
    }

    /*
    private static int switchWithArrow(String str) {
        // Java 12
        // multiCase 가능해짐
        // 더 이상 break 키워드를 사용하지 않아도 됨
        // arrow 를 사용하여 결과 반환
        int result = switch(str) {
            case "a", "b" -> 1;
            case "c" -> 2;
            default -> -1;
        };
        return result;
    }

    private static int switchWithYield(String str) {
        // Java 13
        // yield 키워드를 사용해서 switch 자체가 연산자로 동작하여 하나의 값으로 취급
        int result = switch(str) {
            case "a", "b":
                yield 1;
            case "c" :
                yield 2;
            default :
                yield -1;
        };
        return result;
    }
     */
}

class arrowOperator {
    // 기존 함수
    int min_original(int x, int y) {
        return x < y ? x : y;
    }

    // 람다 표현식 = 메소드를 하나의 식으로 표현함
    // 함수형 인터페이스
    @FunctionalInterface
    interface Calc {
        public int min_functional(int x, int y);
    }
    Calc minNum = (x, y) -> x < y ? x : y;

    void func() {
        System.out.println(
                min_original(3, 4)
        );
        System.out.println(
                minNum.min_functional(3, 4)
        );
    }

    void thread_func() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("전통적인 방식의 일회용 스레드 생성");
            }
        }).start();

        new Thread(()-> {
            System.out.println("람다 표현식을 사용한 일회용 스레드 생성");
        }).start();
    }
}

class instanceofClass {
    class parent implements gene { }
    class me extends parent { }
    class friend { }
    interface gene { }

    void func() {
        parent parentObject = new parent();
        me meObject = new me();
        friend friendObject = new friend();

        // 레퍼런스 타입의 변수가 레퍼런스 타입의 데이터 타입인지 확인하는 연산
        System.out.println(friendObject instanceof gene);
        System.out.println(meObject instanceof gene);
        System.out.println(parentObject instanceof gene);
        System.out.println(meObject instanceof parent);

        if (meObject instanceof gene) {
            gene familyGene = new me();
            System.out.println("자신의 상위 타입의 변수에 값을 할당할 수 있음 : " + familyGene.getClass().getName());
        }
    }
}


class boolOperator {
    void func() {
        System.out.println("&& 는 첫번째 조건이 참이 아니면 두번째 조건 확인 X");
        System.out.println("& 는 첫번째 조건이 참이 아니어도 두번째 조건 확인 O");
        System.out.println("|| 는 첫번째 조건이 참이면 두번째 조건 확인 X");
        System.out.println("| 는 첫번째 조건이 참이어도 두번째 조건 확인 O");
    }
}

class bitOperator {
    // 비트 반전 연산자 산출 타입은 int 타입이 됨
    // 따라서 byte b1 = ~i1 과 같은 연산은 컴파일 에러

    // byte = 1byte = 8bit
    // int = 8byte = 32bit
    byte v1 = 10; // 00001010
    byte v2 = 15; // 00001111

    void func() {
        int iv1 = ~v1;
        System.out.println(Integer.toBinaryString(v1));
        System.out.println("~v1 : " + Integer.toBinaryString(iv1));

        int v1_v2 = v1 ^ v2;
        System.out.println(Integer.toBinaryString(v1));
        System.out.println(Integer.toBinaryString(v2));
        System.out.println("v1 ^ v2 XOR : " + Integer.toBinaryString(v1_v2));

        int s1 = -8 << 3, s2 = -8 >> 3, s3 = -8 >>> 3;
        System.out.println(8 + " = " + Integer.toBinaryString(-8));
        System.out.println(s1 + " = " + Integer.toBinaryString(s1));
        System.out.println(s2 + " = " + Integer.toBinaryString(s2));
        System.out.println(s3 + " = " + "000" + Integer.toBinaryString(s3));
    }
}

class arithmeticOperator {
    int i1 = 10, i2 = 4, intResult;
    double doubleResult;
    float f1 = 0.1f;
    double d1 = 0.1;

    void func() {
        // 정수 타입 & int 타입보다 크기가 작은 타입일 경우 int 타입으로 변환 후 연산
        // byte + byte -> int + int = int

        // 정수 타입 & long 타입이 있을 경우 모두 long 타입 변환 후 연산
        // int + long -> long + long = long

        // 실수 타입이 있을 경우 크기가 큰 실수 타입으로 변환 후 연산
        // int + double -> double + double = double

        intResult = i1 / i2;
        doubleResult = i1 / i2;
        System.out.println("10 / 4 = " + intResult + ", " + doubleResult);
        System.out.println((double)i1 / i2); // 강제 타입 변환 필요함

        System.out.println(3.0 == 3); // 3을 double type 으로 변환해서 연산
        System.out.println(0.1 == 0.1f); // 이진 포맷의 가수를 사용하는 모든 부동소수점 타입은 0.1을 정확히 표현할 수 없어서 0.1f 는 0.100000000014924123 와 같은 값이 됨
        System.out.println((float)d1 == f1); // double 값을 float 타입으로 캐스팅 후 연산 필요
    }
}