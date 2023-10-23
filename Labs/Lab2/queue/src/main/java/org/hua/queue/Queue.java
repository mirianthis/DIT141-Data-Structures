package org.hua.queue;

/**
 * A FIFO queue
 *
 */
public interface Queue<E> {
    
    void push(E elem);
    
    E pop();
           
    E first(); 
        
    boolean isEmpty();
    
    int size();
    
    void clear();
    
}
