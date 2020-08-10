/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.hashmapexercise;

/**
 *
 * @author utkua
 * @param <T>
 * @param <V>
 */
public class HashMapExEntry<T,V> {
    
    private T key;
    private V value;
    private HashMapExEntry<T,V> next;

    public HashMapExEntry(T key, V value, HashMapExEntry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
    
    public boolean hasNext() {
        return !(next == null);
    }
    
    public T getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
    
    public HashMapExEntry getNext() {
        return next;
    }
    
    public void setNext(HashMapExEntry next) {
        this.next = next;
    }
}
