package org.hua.stack;


public interface Stack<E> {
    void push(E elem);
    
    E pop();
    
    E top();
    
    boolean isEmpty();
    
    int size();
    
    void clear();
}
