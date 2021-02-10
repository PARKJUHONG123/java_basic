package week04_controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack s = new Stack();
    @Test
    void test() throws Exception {
        s.push(1);
        s.push(2);
        assertEquals(s.pop(), 2);
        assertEquals(s.pop(), 1);
        s.push(4);
        assertEquals(s.pop(), 4);

        Exception exception = assertThrows(Exception.class, ()-> {
            s.pop();
        });
        assertEquals("스택에 삭제할 데이터가 존재하지 않음", exception.getMessage());
    }

}