package dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumbersTest {
    @Test
    public void testF0() {
        assertEquals(0, new FibonacciNumbers().f(0));
    }
    
    @Test
    public void testF1() {
        assertEquals(1, new FibonacciNumbers().f(1));
    }
    
    @Test
    public void testF5() {
        assertEquals(5, new FibonacciNumbers().f(5));
    }
    
    @Test
    public void testF8() {
        assertEquals(21, new FibonacciNumbers().f(8));
    }
    
    @Test
    public void testF20() {
        assertEquals(6765, new FibonacciNumbers().f(20));
    }
    
    @Test
    public void testF30() {
        long start = System.currentTimeMillis();
        assertEquals(832040L, new FibonacciNumbers().f(30));
        long end = System.currentTimeMillis();
        System.out.printf("f(30) took %s ms%n", end-start);
    }
    
    @Test
    public void testF40() {
        // without memoization takes ~600ms, with memoization 0ms
        long start = System.currentTimeMillis();
        assertEquals(102334155L, new FibonacciNumbers().f(40));
        long end = System.currentTimeMillis();
        System.out.printf("f(40) took %s ms%n", end-start);
    }
    
    @Test
    public void testF50() {
        // without memoization takes ~69 seconds, with memoization 0ms
        long start = System.currentTimeMillis();
        assertEquals(12586269025L, new FibonacciNumbers().f(50));
        long end = System.currentTimeMillis();
        System.out.printf("f(50) took %s ms%n", end-start);
    }
    
    @Test
    public void testF90() {
        // without memoization takes ~? seconds, with memoization 0ms
        long start = System.currentTimeMillis();
        assertEquals(2880067194370816120L, new FibonacciNumbers().f(90));
        long end = System.currentTimeMillis();
        System.out.printf("f(90) took %s ms%n", end-start);
    }
}