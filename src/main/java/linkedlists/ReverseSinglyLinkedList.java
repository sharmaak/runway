package linkedlists;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseSinglyLinkedList<T> {

    public Node<T> flip(Node<T> head) {
        if(head == null) {
            return null;
        }
        
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next;
        
        while(current != null) {
            
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
    
    /*
    *  ^ <- 1 <-2 <- 3    ^
    *                     c
    *                     n
    *                p
    * */
}
