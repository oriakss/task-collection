package by.clevertec;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class MainTest {

    @Test
    void testDoesNotThrowTask1() {
        assertDoesNotThrow(Main::task1);
    }

    @Test
    void testTimeoutTask1() {
        assertTimeout(Duration.ofMillis(500), Main::task1);
    }

    @Test
    void testDoesNotThrowTask2() {
        assertDoesNotThrow(Main::task2);
    }

    @Test
    void testTimeoutTask2() {
        assertTimeout(Duration.ofMillis(500), Main::task2);
    }

    @Test
    void testDoesNotThrowTask3() {
        assertDoesNotThrow(Main::task3);
    }

    @Test
    void testTimeoutTask3() {
        assertTimeout(Duration.ofMillis(500), Main::task3);
    }

    @Test
    void testDoesNotThrowTask4() {
        assertDoesNotThrow(Main::task4);
    }

    @Test
    void testTimeoutTask4() {
        assertTimeout(Duration.ofMillis(500), Main::task4);
    }

    @Test
    void testDoesNotThrowTask5() {
        assertDoesNotThrow(Main::task5);
    }

    @Test
    void testTimeoutTask5() {
        assertTimeout(Duration.ofMillis(500), Main::task5);
    }

    @Test
    void testDoesNotThrowTask6() {
        assertDoesNotThrow(Main::task6);
    }

    @Test
    void testTimeoutTask6() {
        assertTimeout(Duration.ofMillis(500), Main::task6);
    }

    @Test
    void testDoesNotThrowTask7() {
        assertDoesNotThrow(Main::task7);
    }

    @Test
    void testTimeoutTask7() {
        assertTimeout(Duration.ofMillis(500), Main::task7);
    }

    @Test
    void testDoesNotThrowTask8() {
        assertDoesNotThrow(Main::task8);
    }

    @Test
    void testTimeoutTask8() {
        assertTimeout(Duration.ofMillis(500), Main::task8);
    }

    @Test
    void testDoesNotThrowTask9() {
        assertDoesNotThrow(Main::task9);
    }

    @Test
    void testTimeoutTask9() {
        assertTimeout(Duration.ofMillis(500), Main::task9);
    }

    @Test
    void testDoesNotThrowTask10() {
        assertDoesNotThrow(Main::task10);
    }

    @Test
    void testTimeoutTask10() {
        assertTimeout(Duration.ofMillis(500), Main::task10);
    }

    @Test
    void testDoesNotThrowTask11() {
        assertDoesNotThrow(Main::task11);
    }

    @Test
    void testTimeoutTask11() {
        assertTimeout(Duration.ofMillis(500), Main::task11);
    }
}