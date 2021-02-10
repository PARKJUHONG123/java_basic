package week04_controller;

/*
- 과제 5. Queue를 구현하세요.
    - 배열을 사용해서 한번
    - ListNode를 사용해서 한번.
 */

public class Queue {
    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        ArrayQueue aq = new ArrayQueue();
        ListNodeQueue lnq = new ListNodeQueue();
    }
}

class StackQueue {
    Stack st1, st2;
    boolean pushFlag, popFlag;

    StackQueue() {
        st1 = new Stack();
        st2 = new Stack();
        pushFlag = true;
        popFlag = false;
    }

    public void enqueue(int data) throws Exception {
        if (pushFlag) {
            if (st1.getTop() == -1) {
                st2.push(data);
            }
            else {
                st1.push(data);
            }
        }
        else {
            if (st1.getTop() == -1) {
                while (st2.getTop() != -1) {
                    st1.push(st2.pop());
                }
                st1.push(data);
            }
            else {
                while (st1.getTop() != -1) {
                    st2.push(st1.pop());
                }
                st2.push(data);
            }

            pushFlag = true;
            popFlag = false;
        }
    }

    public int dequeue() throws Exception {
        if (popFlag) {
            if (st1.getTop() == -1) {
                return st2.pop();
            }
            else {
                return st1.pop();
            }
        }
        else {
            pushFlag = false;
            popFlag = true;

            if (st1.getTop() == -1) {
                while (st2.getTop() != -1) {
                    st1.push(st2.pop());
                }
                return st1.pop();
            }
            else {
                while (st1.getTop() != -1) {
                    st2.push(st1.pop());
                }
                return st2.pop();
            }
        }
    }
}

class ArrayQueue {
    private int[] array;
    private int last;

    ArrayQueue() {
        this.array = new int[0];
        this.last = -1;
    }

    public void enqueue(int data) {
        int arrayLength = this.array.length;
        this.last += 1;
        if (arrayLength == this.last) {
            int[] newArray = new int[arrayLength + 1];
            System.arraycopy(array, 0, newArray, 0, arrayLength);
            newArray[this.last] = data;
            this.array = newArray;
        }
        else {
            this.array[this.last] = data;
        }
    }

    public int dequeue() throws Exception {
        if (this.last == -1) {
            throw new Exception("삭제할 데이터가 존재하지 않습니다.");
        }
        else {
            int ret = this.array[0];
            System.arraycopy(array, 1, array, 0, this.last);
            this.last -= 1;
            return ret;
        }
    }

}

class ListNodeQueue {
    private ListNode head;
    ListNodeQueue() {
        head = new ListNode();
    }

    public void enqueue(int data) {
        ListNode node = new ListNode(data);
        ListNode current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public int dequeue() throws Exception {
        ListNode node = head.next;
        if (node == null) {
            throw new Exception("삭제할 데이터가 존재하지 않습니다.");
        }
        else {
            this.head.next = node.next;
            return node.value;
        }
    }
}