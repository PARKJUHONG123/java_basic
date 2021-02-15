package week10_multiThreadProgramming.threadProduce;

import java.awt.*;

// 작업 스레드가 실행할 작업을 Runnable 로 만들지 않고, Thread 의 하위 클래스로 작업 스레드를 정의하면서 작업 내용을 포함시킴
// Thread 클래스를 상속한 후, run 메소드를 override 해서 스레드가 실행할 코드를 작성함

public class BeepThread extends Thread {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            System.out.println("[직접 상속 스레드] : 소리 울림");
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {}
        }
    }
}
