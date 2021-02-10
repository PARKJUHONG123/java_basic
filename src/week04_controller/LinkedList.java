package week04_controller;

interface LinkedListInterface {
    ListNode add(ListNode head, ListNode nodeToAdd, int position);
    ListNode remove(ListNode head, int positionToRemove);
    boolean contains(ListNode head, ListNode nodeToCheck);
}

class ListNode {
    public int value;
    public ListNode next;

    ListNode() { }
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedList implements LinkedListInterface {
    public void search(ListNode head) {
        ListNode node = head.next;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (position <= 0) {
            System.out.println("포지션 값은 항상 양수여야 함");
            return null;
        }

        ListNode previous = null, current = head;

        while (position-- > 0) {
            previous = current;
            current = current.next;

            if (current == null && position > 0) {
                System.out.println("범위를 벗어남");
                return null;
            }
        }

        nodeToAdd.next = current;
        previous.next = nodeToAdd;
        search(head);
        return current;
    }


    @Override
    public ListNode remove(ListNode head, int positionToRemove) {
        if (positionToRemove <= 0) {
            System.out.println("포지션 값은 항상 양수여야 함");
            return null;
        }

        ListNode previous = null, current = head;

        while (positionToRemove-- > 0) {
            previous = current;
            current = current.next;
            if (current == null && positionToRemove >= 0) {
                System.out.println("범위를 벗어남");
                return null;
            }
        }
        previous.next = current.next;
        search(head);
        return current;
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeToCheck) {
        if (nodeToCheck == null) {
            return false;
        }

        ListNode node = head.next;
        while (node != null) {
            if (node.value == nodeToCheck.value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}



