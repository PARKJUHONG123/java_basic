package week10_multiThreadProgramming.threadProduce;

import java.awt.*;

// Runnable 은 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체
// Runnable 은 인터페이스 타입으로, 구현 객체를 만들어 대입해야 함
// run() 메소드 하나가 정의되어 있기 때문에, 구현 클래스는 run() 을 재정의해서 작업 스레드가 실행할 코드를 작성해야 함

public class BeepRunnable implements Runnable {
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            System.out.println("[Runnable 구현 객체를 매개값으로 한 작업 스레드] : 소리 울림");
            try {
                Thread.sleep(500);
            }
            catch (Exception e) { }
        }
    }
}
