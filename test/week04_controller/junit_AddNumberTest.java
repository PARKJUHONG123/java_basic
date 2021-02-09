package week04_controller;
import static org.junit.jupiter.api.Assertions.*;

class junit_AddNumberTest {
    @org.junit.jupiter.api.BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll method call");
    }

    @org.junit.jupiter.api.BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach method call");
    }

    @org.junit.jupiter.api.Test
    void add_2() {
        System.out.println("add_2 method call");
        junit_AddNumber ja = new junit_AddNumber();
        assertEquals(ja.add(8, 9), 17);
    }

    @org.junit.jupiter.api.Test
    void add_3() {
        System.out.println("add_3 method call");
        junit_AddNumber ja = new junit_AddNumber();
        assertEquals(ja.add(1, 2, 3), 3);
    }

    @org.junit.jupiter.api.AfterEach
    void afterEach() {
        System.out.println("afterEach method call");
    }

    @org.junit.jupiter.api.AfterAll
    static void afterAll() {
        System.out.println("afterAll method call");
    }
}