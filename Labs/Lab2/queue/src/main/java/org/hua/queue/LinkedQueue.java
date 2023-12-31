package org.hua.queue;

import java.util.NoSuchElementException;

/**
 *
 * FIFO Queue
 */
public class LinkedQueue<E> implements Queue<E>{
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public LinkedQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void push(E elem) {
        Node<E> n = new Node<>();
        n.data = elem;
        n.next = null;
        
        if(head == null){
            //queue was empty
            head = n;
            tail = n;
        }else{
            //queue was not empty
            tail.next = n;
        }
    }

    @Override
    public E pop() {
         if(isEmpty()){
           throw new NoSuchElementException();
       } 
         E result = head.data;
         head = head.next;
         if(head == null){
             tail = null;
         }
         size--;
         return result;
    }

    @Override
    public E first() {
       if(isEmpty()){
           throw new NoSuchElementException();
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
        tail = null;
        size = 0;
    }
    
    private static class Node<E> {
        public E data;
        public Node<E> next;
        
    }
    
}
