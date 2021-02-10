package week04_controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void test() {
        LinkedList ll = new LinkedList();
        ListNode head = new ListNode();

        ll.add(head, new ListNode(12), 1);
        ll.add(head, new ListNode(34), 2);
        ll.add(head, new ListNode(56), 3);
        ll.add(head, new ListNode(78), 4);
        ll.add(head, new ListNode(90), 1);

        assertEquals(90, ll.remove(head, 1).value);
        assertEquals(12, ll.remove(head, 1).value);
        assertEquals(78, ll.remove(head, 3).value);
        assertEquals(34, ll.remove(head, 1).value);
        assertEquals(56, ll.remove(head, 1).value);
    }
}