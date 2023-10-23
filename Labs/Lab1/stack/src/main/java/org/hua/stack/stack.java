package org.hua.stack;

public interface stack<E> {
    
    void push(E elem);
    
    E pop();
    
    E top();
    
    boolean isEmpty();
    
    int size();
    
    void clear();
    
    
}
