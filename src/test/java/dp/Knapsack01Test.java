package dp;
import org.junit.Test;

import static org.junit.Assert.*;
public class Knapsack01Test {
    
    @Test
    public void test_0() {
        Knapsack01 subject = new Knapsack01();
        int[] values = {2,4,8};
        int[] weights = {1,5,8};
        int knapsackCapacity = 10;
        assertEquals(10, subject.calculateMaxValue( values, weights, knapsackCapacity ));
    }
    
    @Test
    public void test_1() {
        Knapsack01 subject = new Knapsack01();
        int[] values = {20, 5, 10, 40, 15, 25};
        int[] weights = {1, 2, 3, 8, 7, 4 };
        int knapsackCapacity = 10;
        assertEquals(60, subject.calculateMaxValue( values, weights, knapsackCapacity ));
    }
    
    @Test
    public void test_2() {
        Knapsack01 subject = new Knapsack01();
        int[] values = {60,100,120};
        int[] weights = {10,20,30};
        int knapsackCapacity = 50;
        assertEquals(220, subject.calculateMaxValue( values, weights, knapsackCapacity ));
    }
    
    
    @Test
    public void test_3() {
        Knapsack01 subject = new Knapsack01();
        int[] values =  {1, 5, 8, 9,15,22,30,12,20,40 };
        int[] weights = {5,10,15,20,25,30,35,40,45,50};
        int knapsackCapacity = 100;
        assertEquals(78, subject.calculateMaxValue( values, weights, knapsackCapacity ));
        //System.out.println(subject.calculateMaxValue( values, weights, knapsackCapacity ));
    }
}
