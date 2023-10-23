package org.hua.queue;

//Queue using linked lists.

import java.util.NoSuchElementException;


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
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public E pop() {
        E result = head.data; //Αποθηκευω την πληροφορια πριν την σβησω.
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        head = head.next;
        //Αν υπαρχει μονο ενας κομβος: 
        if(head==null){
            tail = null;
        }
        size--;
        return result;
        
    }

    @Override
    public E first() {
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public void push(E elem) {
        Node<E> n = new Node<>();
        n.data = elem;
        n.next = null;
        
        if (isEmpty()){
            //queue was empty
            head = n;
            tail=n;
            
        }else{
            tail.next = n;
            tail = n;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    
    private static class Node<E> {
        public E data;
        public Node<E> next;
    }
}
