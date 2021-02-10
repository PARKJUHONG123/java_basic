package week04_controller;

/*
    - int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
    - void push(int data)를 구현하세요.
    - int pop()을 구현하세요.
 */
public class Stack {
    private int[] array;
    private int top;

    public Stack() {
        this.array = new int[0];
        this.top = -1;
    }

    public int getTop() {
        return this.top;
    }

    public void push(int data) {
        int arrayLength = this.array.length;
        this.top += 1;
        if (arrayLength == this.top) {
            int[] newArray = new int[arrayLength + 1];
            System.arraycopy(array, 0, newArray, 0, arrayLength);
            newArray[this.top] = data;
            this.array = newArray;
        }
        else {
            this.array[this.top] = data;
        }
    }

    public int pop() throws Exception {
        if (this.top == -1) {
            throw new Exception("스택에 삭제할 데이터가 존재하지 않음");
        }
        else {
            int ret = this.array[this.top];
            this.top -= 1;
            return ret;
        }
    }
}
