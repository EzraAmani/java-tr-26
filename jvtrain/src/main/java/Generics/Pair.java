package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.setKey(key);
        this.setValue(value);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static <T> List<T> createList(T... elements) {
        List<T> list = new LinkedList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }

}
