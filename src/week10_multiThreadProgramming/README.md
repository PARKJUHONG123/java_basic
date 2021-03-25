## 목표
    자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.

## 학습할 것 (필수)
- Thread 클래스와 Runnable 인터페이스
- 쓰레드의 상태
- 쓰레드의 우선순위
- Main 쓰레드
- 동기화
- 데드락

## Thread 의 상태
- 상태
  - Start
  - Runnable
  - Run
  - Dead
  - Not Runnable
    
- Runnable -> Not Runnable
  - sleep(int time)
  - wait() : Shared Resource 를 기다리기 위해 사용함
    - 리소스가 더 이상 유효하지 않은 경우 리소스가 사용 가능할 때까지 thread 를 Non-Runnable 상태로 전환
    - wait() 상태가 된 thread 는 notify() 가 호출될 때까지 기다림
  - join() : A 쓰레드가 B 쓰레드에게 join 을 걸면 B 쓰레드가 끝날 때까지 A 쓰레드는 Not Runnable 상태가 됨
    
- Not Runnable -> Runnable
  - sleep(int time) -> time 만큼의 시간이 지날 경우
  - wait() -> notify(), notifyAll()
    - notify()
      - wait() 하고 있는 thread 중 하나의 thread 를 Runnable 한 상태로 깨움
      - thread 들 중에서 결국 Runnable 상태로 변환되지 못할 thread 가 존재할 가능성이 있음
    - notifyAll()
      - wait() 하고 있는 모든 thread 가 Runnable 한 상태가 되도록 함
      - notify() 보다 notifyAll() 을 사용하기를 권장
      - 특정 thread 가 통지를 받도록 제어할 수 없으므로 모두 깨운 후 scheduler 에 CPU 를 점유하는 것이 좀 더 공평함
  - join() -> B 쓰레드가 끝나고 나면 A 쓰레드가 Runnable 상태가 됨
  - interrupt()
    - 다른 Thread 에 예외를 발생시키는 interrupt 를 보냄
    - Thread 가 join(), sleep(), wait() 메소드에 의해 Not Runnable 상태로 Blocking 되었다면 interrupt 에 의해 다시 Runnable 상태가 될 수 있음
  
- Thread 종료하기
  - 데몬 등 무한히 반복하는 Thread 가 종료될 수 있도록 run() 메소드 내의 while 문을 활용함
  - Thread.stop() 은 사용하지 않음
  
## 자바에서 Synchronization 구현
- Synchronized 수행문 
  - 참조형 수식에 해당되는 객체에 lock 을 건다
```
  synchronized(참조형 수식) { }
```

- Synchronized 메소드
  - 현재 이 메소드가 속해 있는 객체에 lock 을 건다
  - synchronized 메소드 내에서 다른 synchronized 메소드를 호출할 수 없음 (Deadlock 방지를 위해)
  
#