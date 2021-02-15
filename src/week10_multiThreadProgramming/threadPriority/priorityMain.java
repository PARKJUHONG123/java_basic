package week10_multiThreadProgramming.threadPriority;

// 동시성 - 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가면서 실행하는 성질
// 병렬성 - 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질

// 스레드의 개수가 코어의 수보다 많을 경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가를 결정해야 함 = 스레드 스케쥴링
// 자바의 스레드 스케쥴링은 Priority 방식과 Round-Robin 방식을 사용함
// Round-Robin 방식은 JVM 에 의해서 정해지기 때문에 코드로 제어할 수 없음
// Priority 방식은 우선순위를 부여할 수 있음

// 우선순위는 1~10 까지 부여할 수 있는데, 모든 스레드들은 기본적으로 5의 우선순위를 할당받음
// CPU 코어의 수에 따라서 우선순의의 존재의미가 달라지는데, 쿼드 코어일 경우 4개의 스레드를 사용하게 되면 병렬성으로 실행될 수 있기 때문에 크게 영향 X

public class priorityMain {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread thread = new priorityThread("Thread " + i);
            if (i != 0 & i != 5) {
                thread.setPriority(Thread.MIN_PRIORITY); // 1
            }
            else if (i == 5) {
                thread.setPriority(Thread.NORM_PRIORITY); // 5
            }
            else {
                thread.setPriority(Thread.MAX_PRIORITY); // 10
            }
            thread.start();
        }
    }
}
