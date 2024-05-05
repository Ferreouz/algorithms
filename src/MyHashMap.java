class Node<K, V> {
    private K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }
}

public class MyHashMap<K, V> {
    private int size = 5;
    private Node<K, V>[] table;

    public MyHashMap() {
        this.table = new Node[size];
    }

    public MyHashMap(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    public V get(K key) {
        int hash = key.hashCode() % size;
        var node = table[hash];
        if(node == null) {
            return null;
        }

        while (node != null) {
            if(node.getKey() == key) {
                return node.value;
            }
            node = node.next;
        }

        return null;

    }

    public void put(K key, V value) {
        int hash = key.hashCode() % size;
        var node = table[hash];

        while (node != null) {
            if(node.getKey() == key) {
                node.value = value;
                return;
            }
            if(node.next == null) {
                node.next = new Node<>(key, value);
                return;
            }
            node = node.next;
        }

        table[hash] = new Node<>(key, value);

    }

    public V remove(K key) {
        int hash = key.hashCode() % size;
        var node = table[hash];
        if(node == null) {
            return null;
        }

        Node<K, V> prev = null;
        while (node != null) {

            if(node.getKey() != key) {
                prev = node;                
                node = node.next;
                continue;
            }

            if(prev != null) {
                prev.next = node.next;
                node.next = null;
                return node.value;
            }

            table[hash] = node.next;
            node.next = null;
            return node.value;
        }

        return null;
    }

    public String toString() {
        String out = "HashMap{";
        
        for (int i = 0; i < this.size; i++) {
            Node<K, V> node = table[i];
            out += "[ " + i + "=>";
            while (node != null) { 
                out += "{ " + node.getKey() + " " + node.value + " },";
                node = node.next;
            }
            out += "] ";
        }

        return out.concat("}");
    }
}
