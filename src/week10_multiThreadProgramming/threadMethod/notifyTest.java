package week10_multiThreadProgramming.threadMethod;

import java.util.ArrayList;

public class notifyTest {
    public static Library library = new Library();

    public static void main(String[] args) {
        ArrayList<Student> als = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            als.add(new Student());
            als.get(i).start();
        }
    }

}

class Student extends Thread {
    public void run() {
        try {
            String title = notifyTest.library.lendBook();
            sleep(500);
            notifyTest.library.returnBook(title);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Library {
    public ArrayList<String> books = new ArrayList<>();

    public Library() {
        for (int i = 1; i < 5; i++) {
            books.add(("태백산맥 " + i));
        }
    }

    public synchronized String lendBook() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (books.size() == 0) {
            System.out.println(t.getName() + " waiting start");
            wait();
            System.out.println(t.getName() + " waiting end");
        }
        String title = books.remove(0);
        System.out.println(t.getName() + " lend " + title);
        return title;
    }

    public synchronized void returnBook(String title) {
        Thread t = Thread.currentThread();
        books.add(title);
        notifyAll();
        System.out.println(t.getName() + " return " + title);
    }
}