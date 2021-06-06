package linkedlists;

import java.util.Objects;

/**
 * Represents the node of a singly linked list. Base class for all linked list problems.
 */
public class Node<T> {
    T value;
    Node<T> next;
    
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
    
    /** Fluent API to help craft linked lists quickly */
    public Node<T> next(T value) {
        this.next = new Node<T>(value, null);
        return next;
    }
    
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        
        if(this == o) {
            return true;
        }
        
        Node<T> that = (Node<T>) o;
        if(this.value != null && this.value.equals( that.value )) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash( value, next );
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
       Node<T> current = this;
       while(current != null) {
           b.append( current.value ).append( " -> " );
           current = current.next;
       }
       b.append( "∅" );
       
       return b.toString();
    }
}
