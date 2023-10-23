package org.hua.queue;
    //FIFO QUEUE


public interface Queue<E> {
    boolean isEmpty();
    
    E pop();
    
    E first();
    
    void push (E elem);
    
    int size();
    
    void clear();
    
    
}
