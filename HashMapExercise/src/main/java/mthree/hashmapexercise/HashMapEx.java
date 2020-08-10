/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.hashmapexercise;

import java.util.Arrays;

/**
 *
 * @author utkua
 * @param <T>
 * @param <V>
 */
public class HashMapEx<T,V> {
    
    Array<HashMapExEntry<T,V>> mappy;
    private int size;
    
    private int bucketCount;
    
    public HashMapEx() {
        bucketCount = 1;
        mappy = new Array(bucketCount);
        size = 0;
    }
    
    public void putEntry(T key, V value) {
        int hashCode = key.hashCode()%bucketCount;
        System.out.println("Bucket: " + hashCode);
        HashMapExEntry entry = new HashMapExEntry(key, value, null);
        if (mappy.get(hashCode) == null) {
            mappy.set(hashCode, entry);
        } else {
            int bucketSize = 0;
            HashMapExEntry current = mappy.get(hashCode);
            while (current.hasNext()) {
                current = current.getNext();
                bucketSize++;
                if (bucketSize == 2) {
                    splitMap(entry);
                    break;
                }
                System.out.println("Bucket not null: " + hashCode);
            }
            current.setNext(entry);
        }
        size++;
    }
    
    public void removeEntry(T key) {
        for (int i = 0; i < bucketCount; i++) {
            HashMapExEntry current = mappy.get(i);
            if (current == null) {
                continue;
            }
            if (current.getKey().equals(key)) {
                HashMapExEntry next = current.getNext();
                mappy.set(i, next);
                return;
            }
            while (current.hasNext()) { 
                HashMapExEntry previous = current;
                current = current.getNext();
                if (current.getKey().equals(key)) {
                    HashMapExEntry next = current.getNext();
                    previous.setNext(next);
                    return;
                }
            }
        }
    }
    
    public HashMapExEntry<T,V> getEntry(T key) {
        int hashCode = key.hashCode()%bucketCount;
        HashMapExEntry current = mappy.get(hashCode);
        hashCode = key.hashCode();
        if (current == null) {
            return current;
        } else {
            while (current.hasNext()) {
                if (current.getKey().hashCode() == hashCode) {
                    return current;
                }
                current = current.getNext();
            }
        }
        return current;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean containsKey(T key) {
        for (int i = 0; i < bucketCount; i++) {
            HashMapExEntry current = mappy.get(i);
            if (current == null) {
                continue;
            }
            if (current.getKey().equals(key)) {
                return true;
            }
            while (current.hasNext()) {                
                current = current.getNext();
                if (current.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean containsValue(V value) {
        for (int i = 0; i < bucketCount; i++) {
            HashMapExEntry current = mappy.get(i);
            if (current == null) {
                continue;
            }
            if (current.getValue().equals(value)) {
                return true;
            }
            while (current.hasNext()) {                
                current = current.getNext();
                if (current.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void splitMap(HashMapExEntry<T,V> entry) {
        bucketCount = bucketCount * 2;
        System.out.println("bucketCount: " + bucketCount);
        Array<HashMapExEntry<T,V>> oldMap = mappy;
        Array<HashMapExEntry<T,V>> newMap = new Array<HashMapExEntry<T,V>>(bucketCount);
        mappy = newMap;
        for (int i = 0; i < bucketCount / 2; i++) {
            HashMapExEntry<T,V> current = oldMap.get(i);
            if (current == null) {
                continue;
            }
            putEntry(current.getKey(), current.getValue());
            while (current.hasNext()) {
                
                current = current.getNext();
                putEntry(current.getKey(), current.getValue());
            }
        }
        putEntry(entry.getKey(), entry.getValue());
    }
 
    class Array<E> {
        private final Object[] obj_array;   //object array
        public final int length;
        // class constructor
        public Array(int length)    {
            // instantiate a new Object array of specified length
            obj_array = new Object [length];
            this.length = length;
        }
        // get obj_array[i]
        E get(int i) {
            @SuppressWarnings("unchecked")
            final E e = (E)obj_array[i];
            return e;
        }
        // set e at obj_array[i]
        void set(int i, E e) {
            obj_array[i] = e;
        }
        @Override
        public String toString() {
            return Arrays.toString(obj_array);
        }
    }
    
    /**
     *
     * @author utkua
     * @param <T>
     * @param <V>
     */
    class HashMapExEntry<T,V> {

        private T key;
        private V value;
        private HashMapExEntry next;

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
    
}
