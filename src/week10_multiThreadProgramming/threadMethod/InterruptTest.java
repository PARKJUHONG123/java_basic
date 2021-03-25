package week10_multiThreadProgramming.threadMethod;

public class InterruptTest extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
            System.out.println("Wake Up");
        }
    }

    public static void main(String[] args) {
        InterruptTest interruptTest = new InterruptTest();
        interruptTest.start();
        interruptTest.interrupt();
        System.out.println("Main Thread End");
    }
}
