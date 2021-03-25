package week10_multiThreadProgramming.threadMethod;

public class SyncTest {
    public static Bank bank = new Bank(); // 공유되는 객체
    public static void main(String[] args) throws InterruptedException {
        Park p = new Park();
        p.start();

        Thread.sleep(200);

        Kim k = new Kim();
        k.start();
    }
}

class Park extends Thread {
    public void run() {
        System.out.println("Park : Start inMoney");
        SyncTest.bank.inMoney(5000);
        System.out.println("Park : End inMoney" + " [Result] " + SyncTest.bank.getMoney());
    }
}

class Kim extends Thread {
    public void run() { // public synchronized void run() 은 아무런 의미가 없음 - 동기화를 원하는 객체에 적용해야 하는데 쓰레드는 해당되지 않음
        // 동기화를 적용하기 위해서는 다음과 같이 해야 함
        // [방법 1] thread run 에서 객체에 직접 적용하는 방식
        synchronized (SyncTest.bank) {
            System.out.println("Kim : Start outMoney");
            SyncTest.bank.outMoney(3000);
            System.out.println("Kim : End outMoney" + " [Result] " + SyncTest.bank.getMoney());
        }
    }
}

class Bank {
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void inMoney(int in) {
        // [방법 2] 필요한 부분을 동기화 블록으로 선언
        synchronized (this) {
            int m = this.getMoney();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setMoney(m + in);
        }
    }

    // [방법 3] 메소드 자체를 동기화 블록으로 선언
    public synchronized void outMoney(int out) {
        int m = this.getMoney(); // 10000

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(m - out);
    }
}
