package org.hua.stack;

import java.util.NoSuchElementException;

/**
 *
 * a stack using a linked list representation
 */
public class LinkedStack<E> implements Stack<E>{
    
    private int size;
    private Node<E> head;
    
    public LinkedStack(){
        this.size = 0;
        this.head = null;
    }

    @Override
    public void push(E elem) {
        Node<E> n = new Node<>();
        n.data = elem;
        n.next = null;
        head = n;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        
        E result  = head.data;
        head = head.next;
        size--;
        return result;
           
        
    }

    @Override
    public E top() {
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }
    
    
    
    private static class Node<E>{
        public E data;
        public Node<E> next;
        
    }
}
