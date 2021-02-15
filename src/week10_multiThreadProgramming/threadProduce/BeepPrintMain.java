package week10_multiThreadProgramming.threadProduce;

import java.awt.*;
import java.util.Scanner;

public class BeepPrintMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            Runnable beepTask = new BeepRunnable(); // Runnable 은 작업 내용을 가지고 있는 객체이지 실제 스레드는 아님
            Thread thread = new Thread(beepTask); // java.lang.Thread 클래스로부터 작업 스레드 객체를 직접 생성하려면 Runnable 매개값을 갖는 생성자를 호출해야 함
            thread.setName("Runnable 구현 객체를 매개값으로 한 작업 스레드");
            System.out.println("[작업 스레드 이름] : " + thread.getName());
            thread.start(); // 작업 스레드는 매개값으로 받은 Runnable 의 run() 메소드를 실행하면서 자신의 작업을 처리함
        }
        else if (choice == 2) {
            // Runnable 익명 객체 이용
            String name = "[Runnable 익명 객체] : ";
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    for (int i = 0; i < 5; i++) {
                        toolkit.beep();
                        System.out.println(name + "소리 울림");
                        sleep500();
                    }
                }
            });
            thread.start();
        }
        else if (choice == 3) {
            // 람다식 이용
            String name = "[람다식 이용] : ";
            Thread thread = new Thread(() -> {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    System.out.println(name + "소리 울림");
                    sleep500();
                }
            });
            thread.start();
        }
        else if (choice == 4) {
            // Thread 하위 클래스 이용
            Thread thread = new BeepThread();
            thread.start();
        }
        else if (choice == 5) {
            // Thread 익명 객체 이용
            String name = "[Thread 익명 객체] : ";
            Thread thread = new Thread() {
                @Override
                public void run() {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    for (int i = 0; i < 5; i++) {
                        toolkit.beep();
                        System.out.println(name + "소리 울림");
                        sleep500();
                    }
                }
            };
            thread.start();
        }

        System.out.println("[Main 쓰레드] : " + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) { // main 스레드가 작업 스레드들과 동시에 실행됨
            System.out.println("[Main 쓰레드] : 띵");
            sleep500();
        }
    }

    static void sleep500() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {}
    }
}
