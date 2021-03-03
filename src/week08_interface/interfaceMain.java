package week08_interface;

// 인터페이스는 클래스의 필드, 생성자 또는 메소드의 매개 변수, 생성자 또는 메소드의 로컬 변수로 선언 가능함
public class interfaceMain {
    RemoteControl rc, rcm = new multiTV();
    interfaceMain(RemoteControl rc) {
        this.rc = rc;
    }

    void interfaceMethod(RemoteControl rcv) {
        if (rcv instanceof multiTV) {
            RemoteControl rc = rcv; // Promotion
            // rc.search("url");
            multiTV mt = (multiTV) rc; // Casting
            mt.search("url");
        }
    }

    public static void main(String[] args) {
        // 정적 메소드
        // 인터페이스로 바로 호출 가능함
        RemoteControl.changeBattery();

        // 익명 구현 클래스
        // 필드와 메소드를 추가적으로 선언할 수 있지만, 익명 객체 안에서만 사용할 수 있음
        RemoteControl Anonymous = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("[익명 구현 클래스] : turnOn");
            }

            @Override
            public void turnOff() {
                System.out.println("[익명 구현 클래스] : turnOff");
            }

            @Override
            public void setVolume(int volume) {
                // MAX_VOLUME += 1;
                System.out.println("[익명 구현 클래스] : setVolume");
            }
        };
        interfaceMain im = new interfaceMain(new multiTV());
        im.interfaceMethod(new multiTV());

        extendsImplementTV eit = new extendsImplementTV();
        eit.turnOn();
        abstractTV atv = (abstractTV) eit;
        atv.turnOn(); // Dynamic Method Dispatch
    }
}

// 인터페이스 내 구현해야 하는 메소드를 구현하지 않았을 경우, 구현 클래스는 자동적으로 추상 클래스가 됨 (abstract 키워드 추가)
abstract class abstractTV implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("[추상 클래스] : turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("[추상 클래스] : turnOff");
    }
}

class multiTV implements RemoteControl, Searchable {
    @Override
    public void turnOn() {
        System.out.println("[다중 인터페이스 구현 클래스] : turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("[다중 인터페이스 구현 클래스] : turnOff");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("[다중 인터페이스 구현 클래스] : setVolume");
    }

    @Override
    public void search(String url) {
        System.out.println("[다중 인터페이스 구현 클래스] : search");
    }
    
    @Override
    default void setMute(boolean mute) { 
        // Searchable.super.setMute(mute);
        // RemoteControl.super.setMute(mute);
        
        // 각 인터페이스에 default method 가 중복될 경우 위와 같이 특정 인터페이스를 지정해서 구현된 default method 를 실행할 수 있고
        // 또는 아래와 같이 overriding 이 가능함
        // 위임받은 인터페이스 간의 default method 가 중복되지 않은 경우는 따로 구현할 필요 없이 그대로 가져옴 (overriding 도 물론 가능)
        
        if (mute) {
            System.out.println("[다중 인터페이스 구현 클래스] : 무음 처리");
        }
        else {
            System.out.println("[다중 인터페이스 구현 클래스] : 무음 해제");
        }
    }
}

class extendsImplementTV extends abstractTV implements Searchable {
    @Override
    public void turnOn() {
        System.out.println("[extendsImplement] : turnOn");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("[extendsImplement] : setVolume");
    }

    @Override
    public void search(String url) {
        System.out.println("[extendsImplement] : search");
    }
}
