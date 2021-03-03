package week08_interface;

// 인터페이스
// 목적 : 구현하는 모든 클래스에 대해 특정한 메서드가 반드시 존재하도록 강제하는 역할
// 부모로부터 유전자를 물려받는 것이 아니라 사교적으로 필요에 따라 결합하는 관계
// 구현 객체가 같은 동작을 한다는 것을 보장하기 위함
// 다중 상속 (implements)
// 인터페이스의 모든 메소드는 public 접근 제한자를 갖기 때문에 실체 메소드는 모두 public 접근 제한으로 작성해야 함

public interface RemoteControl extends Machine, ModuleTV { // 인터페이스 간 상속은 extends (다중 상속 가능)
    // 상수
    // public static final 의 특성을 갖기 때문에 생략하더라도 자동적으로 컴파일 과정에서 붙게 됨
    // static {} 블록으로 초기화할 수 없기 때문에 반드시 선언과 동시에 초기값을 지정해야 함
    int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;

    // 추상 메소드
    // public abstract 의 특성을 갖기 때문에 public abstract 를 생략하더라도 자동적으로 컴파일 과정에서 붙게 됨
    void turnOn();
    void turnOff();
    public abstract void setVolume(int volume);

    // [디폴트 메소드] : 자바 8
    // 인터페이스에 선언되지만, 객체가 가지고 있는 인스턴스 메소드 (기본 메소드) 라고 생각해도 됨
    // public 특성을 갖기 때문에 public 을 생략하더라도 자동적으로 컴파일 과정에서 붙게 됨

    // 디폴트 메소드 허용 이유
    // 기존에 Interface 를 구현한 Class 가 있을 때, 시간이 많이 지나서 Interface 에 기능을 추가해야 할 필요성이 생겼음
    // 이 때 Class 가 해당 추상 메소드를 추가하기 위해 수정할 여건이 안되는 상황을 극복하기 위해 자바 8부터 허용하게 됨

    // 목적 : 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서
    default void setMute(boolean mute) { 
        if (mute) {
            System.out.println("무음 처리");
            privateMethod(); // private 메소드 사용
        }
        else {
            System.out.println("무음 해제");
        }
    }

    // [정적 메소드] : 자바 8
    // 객체가 없어도 인터페이스 호출만으로 호출 가능
    // public 특성을 갖기 때문에 public 을 생략하더라도 자동적으로 컴파일 과정에서 붙게 됨
    static void changeBattery() {
        System.out.println("건전지 교환");
        privateStaticMethod(); // private static 메소드 사용
    }
    
    // [Private 메소드] : 자바 9
    // 인터페이스 내에서만 사용 가능한 메소드
    // 디폴트 메소드나 정적 메소드에 사용하기 위해 작성된 메소드
    // 인터페이스를 구현하는 클래스에서 재정의하거나 사용할 수 없고 디폴트나 정적 메소드를 통해서만 사용 가능함
    private void privateMethod() { // 디폴트 메소드에서 사용하기 위해 작성
        System.out.println("private method");
    }
    private static void privateStaticMethod() { // 정적 메소드에서 사용하기 위해 작성
        System.out.println("private static method");
    }

}

interface Machine {
    default void charge() {
        System.out.println("충전");
    }
}

interface ModuleTV {
    default void powerOn() {
        System.out.println("TV의 전원을 킴");
    }

    default void powerOff() {
        System.out.println("TV의 전원을 끔");
    }
}
