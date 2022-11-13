package com.example.datastructure.basic.hash;

public class ChainHash<K, V> {

    private int size;
    private Node<K, V>[] table;

    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    class Node<K, V> {
        private K key; //키 값
        private V data; //데이터 벨류
        private Node<K, V> next; //다음 노드에 대한 참조

        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() { //키 값 그대로 반환
            return key;
        }

        V getValue() { //데이터 값 그대로 반환
            return data;
        }

        public int hashCode() { //키 값의 해시값을 반환
            return key.hashCode();
        }
    }
}
