package linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseSinglyLinkedListTest {
    
    @Test
    public void test_1() {
        Node<String> head = new Node<>( "a" );
        head.next("b").next("c").next("d");
    
        Node<String> expected = new Node<>( "d" );
        expected.next("c").next("b").next("a");
        
        Node<String> flipped = new ReverseSinglyLinkedList<String>().flip( head );
        System.out.println(flipped);
        Node<String> c1 = expected, c2 = flipped;
        while(c1 != null) {
            assertEquals( c1.value, c2.value );
            c1 = c1.next;
            c2 = c2.next;
        }
        assertEquals( c1, c2 ); // both should be null at this point
    }
    
    @Test
    public void test_2() {
        Node<String> head = new Node<>( "a" );
        Node<String> expected = new Node<>( "a" );
        
        Node<String> flipped = new ReverseSinglyLinkedList<String>().flip( head );
        Node<String> c1 = expected, c2 = flipped;
        while(c1 != null) {
            assertEquals( c1.value, c2.value );
            c1 = c1.next;
            c2 = c2.next;
        }
        assertEquals( c1, c2 ); // both should be null at this point
    }
    
    @Test
    public void test_3() {
        assertNull( new ReverseSinglyLinkedList<Integer>().flip( null ) );
    }
}