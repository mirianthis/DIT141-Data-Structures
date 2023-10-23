/**
 * This code is part of the lab exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.bst;

import java.util.Iterator;

public class BinarySearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private Node<K, V> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public V put(K key, V value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V get(K key) {
        Node<K,V>tmp = searchRecursively(root,key);
       if(tmp == null){
           return null;
       }
        return tmp.value;
    }

    @Override
    public boolean contains(K key) {
        return searchRecursively(root,key) !=null;
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
        this.root = null;
        this.size = 0;

    }

    @Override
    public Iterator<K> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    private static class Node<K extends Comparable<K>, V> {

        public K key;
        public V value;
        public Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node<K,V> searchRecursively(Node<K,V> x,K key){
        if(x == null){
            return null;
        }
        
       int c = key.compareTo(x.key);
       if(c == 0){
           return x;
       }
       if(c < 0){
           if(x.left == null){
               return null;
           }
           return searchRecursively(x.left,key);
       }
       if(x.right == null){
           return null;
       }
                return searchRecursively(x.right,key);
    }

}
