package week04_controller;

/*
    - ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
    - void push(int data)를 구현하세요.
    - int pop()을 구현하세요.
 */

public class ListNodeStack extends LinkedList {
    ListNode head;
    public ListNodeStack() {
        this.head = new ListNode();
    }

    public static void main(String[] args) {
        ListNodeStack lns = new ListNodeStack();
    }

    public void push(int data) {
        ListNode node = new ListNode(data);
        ListNode current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        search(head);
    }

    public int pop() {
        ListNode current = head, previous = null;
        if (head.next == null) {
            System.out.println("스택 내 삭제할 데이터가 존재하지 않습니다");
            return -1;
        }

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current.value;
    }
}
