
public class DoublyLinkedList<V> {
    class Node<V> {
        V value;
        Node<V> next;
        Node<V> prev;
    
        public Node(V value) {
            this.value = value;
        }
    }

    private int length = 0;
    private Node<V> head;
    private Node<V> tail;

    public DoublyLinkedList() {
        length = 0;
        head = tail = null;
    }

    // offerLast
    public void add(V v) {
        Node<V> node = new Node<>(v);
        length++;
        if(length == 1) {
            tail = head = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node; 
    }

    // offerLast
    public int add(int index, V v) {
        Node<V> node = new Node<>(v);
        length++;
        if(length == 1) {
            tail = head = node;
            return 0;
        }
        if(index >= length) {
            node.prev = tail;
            tail.next = node;
            tail = node;
            return length - 1;
        }

        Node<V> prev = head;
        int i = 0;
        for(; i < (index - 1) && prev.next != null; i++) {
            prev = prev.next;
        }

        Node<V> nextNode = prev.next;
        prev.next = node;
        node.prev = prev;
        nextNode.prev = node;
        node.next = nextNode;
        
        return i;
    }

    public V get(int index) {
        if(length == 0) {
            return null;
        }

        Node<V> node = head;
        for(int i = 0; i < index && node.next != null; i++) {
            node = node.next;
        }
        
        return node.value;
    }

    public V pop() {
        if(length == 0) {
            return null;
        }

        Node<V> out = head;
        if(head.next != null) {
            head.next.prev = null;
            head = head.next; 
            head.next = null;
        } else {
            tail = head = null;
        }
        
        length--;
        return out.value;
    }

    // public V removeLast() {
    // }

    public V peekFirst() {
        if(length == 0) {
            return null;
        }
        
        return head.value;
    }
    
    public V peekLast() {
        if(length == 0) {
            return null;
        }
        
        return tail.value;
    }
    

    public Integer length() {
        return Integer.valueOf(length);
    }
}