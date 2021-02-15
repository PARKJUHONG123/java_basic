package week10_multiThreadProgramming.threadPriority;

public class priorityThread extends Thread{
    public priorityThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000000000; i++) { }
        System.out.println(getName());
    }
}
