package week06_inheritance;

public class inheritanceMain {
    public static void main(String[] args) {
        Concorde C1 = new Concorde(100, "C1", true);
        Airplane A1 = C1; // Promotion (자동 타입 변환)
        A1.fly(); // 일반비행기에도 있지만, 콩코드비행기에서 재정의된 기능은 재정의된 기능으로 사용함
        // A1.changeStatus(); // 콩코드비행기에만 있는 기능은 사용할 수 없음

        Concorde A1C = (Concorde) A1; // Casting (강제 타입 변환) = 자동 타입 변환된 객체만 변환 가능함
        A1C.changeStatus(); // 기존의 메소드를 실행할 수 있게 됨

        Airplane AA = new Airplane(150, "AA");
        Airplane AC = new Concorde(200, "AC" , true);
        AA.fly();
        AC.fly(); // Dynamic Method Dispatch = 재정의된 기능을 사용함
        // 컴파일 타임에는 참조 타입만 확인하지만, 런타임에는 JVM 이 객체의 타입을 파악하고 그 객체에 정의된 메소드를 실행

        Airplane A2 = new Airplane(300, "A2");
        // Concorde C2 = (Concorde) A2; // 부모 타입의 변수는 자식 타입으로 변환 불가능함
        if (A2 instanceof Concorde) { // 객체가 부모 타입 클래스의 인스턴스이거나 해당 클래스의 인스턴스일 경우 true
            Concorde C2 = (Concorde) A2;
        }
        else {
            System.out.println("강제 타입 변환 불가능");
        }

    }
}

// 추상클래스
// 새로운 실체 클래스를 만들기 위해 부모 클래스로만 사용됨
// 실체 클래스들의 공통적인 특성을 추출해서 선언한 클래스로, 오로지 상속을 위해 사용됨 (실체 클래스처럼 객체 생성 불가능)
// 규격의 역할
abstract class airplaneFrame {
    int speed;
    String name;
    
    airplaneFrame(int speed, String name) {
        this.speed = speed;
        this.name = name;
    }
    
    void land() {
        System.out.println("[착륙] " + name);
    }
    
    void depart() {
        System.out.println("[이륙] " + name);
    }

    abstract void fly(); // 추상 메소드
    // 추상 클래스 내에서만 선언할 수 있음
    // 자식 클래스에서 무조건 override 해서 구현해야 하는 메소드를 지정함
    // 자식 클래스에서 구현하지 않으면 컴파일 에러 발생 (따라서 중괄호가 없음)
}

final class eunuch { } // final class 는 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없음
// class baby extends eunuch { } // 성불구자를 부모로 갖는 것이 불가능함

class Airplane extends airplaneFrame {
    Airplane(int speed, String name) {
        super(speed, name); // new 연산자로 직접 생성자를 호출할 수는 없지만, 추상 클래스 객체 생성 가능
    }

    @Override
    void fly() { // 추상 메소드를 override 해서 정의함
        depart();
        System.out.println("[일반 비행] " + this.name + " : " + this.speed);
    }
    
    final void stop() {
        land();
        System.out.println("비행기를 멈춤 : 오버라이딩으로 변경 불가");
    }
}

class Concorde extends Airplane {
    private boolean status;

    Concorde(int speed, String name, boolean status) {
        super(speed, name);
        this.status = status;
    }

    void changeStatus() {
        this.status = !this.status;
        System.out.println("[비행 모드 변환] " + this.name);
    }

    @Override
    void fly() {
        if (this.status) {
            depart();
            System.out.println("[초음속 비행] " + this.name + " : " + (int)Math.pow(this.speed, 2));
        }
        else {
            super.fly(); // 부모의 메소드 호출
        }
    }
    
    // void stop() { } // final 로 선언된 method 는 자식 클래스에서 변경 불가능
}
