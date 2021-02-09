package week04_controller;

public class controllerMain {
    public static void main(String[] args) {
        simpleClass sc = new simpleClass();
        sc.func();
        junit_AddNumber ja = new junit_AddNumber();
        System.out.println(ja.add(1, 3));
        System.out.println(ja.add(1, 3, 2));
    }
}


class junit_AddNumber {
    public int add(int a , int b) {
        return a + b;
    }
    public int add(int a, int b , int c) {
        return a + b + c;
    }
}

class simpleClass {
    void func() {
        int[] arr = {-1, 0, 1, 2, 3, 4};
        for (int i = -1; i < 5; i++) {
            print(i);
        }
        for (int i : arr) {
            print(i);
        }
    }

    void print(int i) {
        if (i < 0) {
            System.out.println("음수 : " + i);
        }
        else if (i % 2 == 0) {
            System.out.println("짝수 : " + i);
        }
        else {
            System.out.println("홀수 : " + i);
        }
    }
}