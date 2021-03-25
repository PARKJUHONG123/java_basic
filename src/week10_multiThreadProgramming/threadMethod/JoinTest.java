package week10_multiThreadProgramming.threadMethod;

public class JoinTest extends Thread {
    int start, end, total;

    public JoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            total += i;
        }
    }

    public static void main(String[] args) {
        JoinTest jt1 = new JoinTest(1, 50);
        JoinTest jt2 = new JoinTest(51, 100);

        jt1.start();
        jt2.start();

        // join 을 걸지 않으면 main thread 가 먼저 종료되서 결과가 0이 나오게 됨
        try {
            jt1.join(); // main thread 가 jt1 thread 에 join 을 걸어서 jt1 이 끝날 때까지 기다리고 있음
            jt2.join(); // main thread 가 jt2 thread 에 join 을 걸어서 jt2 가 끝날 때까지 기다리고 있음
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int total = jt1.total + jt2.total; // jt1 과 jt2 thread 가 종료되고 나서 total 을 구함
        System.out.println(jt1.total);
        System.out.println(jt2.total);

        System.out.println(total);
    }
}
