package week04_controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    ArrayQueue aq = new ArrayQueue();
    @Test
    void test() throws Exception {
        aq.enqueue(1);
        aq.enqueue(2);
        assertEquals(aq.dequeue(), 1);
        assertEquals(aq.dequeue(), 2);
        aq.enqueue(3);
        assertEquals(aq.dequeue(), 3);
    }
}