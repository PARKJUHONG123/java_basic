package week10_multiThreadProgramming.threadMethod;

import java.io.IOException;

public class TerminateTest extends Thread {
    private boolean flag = false;

    public TerminateTest(String name) {
        super(name);
    }

    public void run() {
        while (!flag) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " End");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws IOException {
        TerminateTest threadA = new TerminateTest("A");
        TerminateTest threadB = new TerminateTest("B");

        threadA.start();
        threadB.start();

        int in;
        while (true) {
            in = System.in.read();
            if (in == 'A') {
                threadA.setFlag(true);
            }
            else if (in == 'B') {
                threadB.setFlag(true);
            }
            else if (in == 'M') {
                threadA.setFlag(true);
                threadB.setFlag(true);
                break;
            }
            else if (in == 10) { }
            else {
                System.out.println("Try Again");
            }
        }
        System.out.println("Main Thread End");
    }
}
