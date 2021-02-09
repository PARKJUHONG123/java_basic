package week04_controller;

interface linkedListInterface {
    ListNode add(ListNode head, ListNode nodeToAdd, int position);
    ListNode remove(ListNode head, int positionToRemove);
    boolean contains(ListNode head, ListNode nodeToCheck);
}

class ListNode {
    public int value;
    public ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class linkedList implements linkedListInterface {

    public static void main(String[] args) {
        ListNode head = null;
        linkedList ll = new linkedList();
        head = ll.add(head, new ListNode(12), 0);
        head = ll.add(head, new ListNode(34), 1);
        head = ll.add(head, new ListNode(56), 2);
        head = ll.add(head, new ListNode(78), 3);
        head = ll.add(head, new ListNode(90), 4);
        ll.search(head);

        head = ll.remove(head, 5);
        ll.search(head);

    }

    public void search(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (position < 0) {
            System.out.println("해당 포지션에 넣을 수 없습니다. 기존의 LinkedList 의 끝에 넣었습니다.");
            position = Integer.MAX_VALUE;
        }

        if (head == null) {
            head = nodeToAdd;
            return head;
        }

        if (position == 0) {
            nodeToAdd.next = head;
            return nodeToAdd;
        }

        ListNode previous = null, current = head;
        int index = 0;

        while (index < position) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }
            index += 1;
        }
        nodeToAdd.next = current;
        previous.next = nodeToAdd;

        return head;
    }


    @Override
    public ListNode remove(ListNode head, int positionToRemove) {
        if (positionToRemove < 0 || head == null) {
            System.out.println("삭제 불가능");
            return head;
        }

        if (positionToRemove == 0) {
            head = head.next;
            return head;
        }

        ListNode previous = null, current = head;
        int index = 0;

        while (index < positionToRemove) {
            previous = current;
            current = current.next;
            if (current.next == null) {
                break;
            }
            index += 1;
        }

        previous.next = current.next;
        return head;
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeToCheck) {
        if (nodeToCheck == null) {
            System.out.println("탐색 불가");
            return false;
        }
        int checkValue = nodeToCheck.value;
        ListNode node = head;
        while (node != null) {
            if (node.value == checkValue) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}



