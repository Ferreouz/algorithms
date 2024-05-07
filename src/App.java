
public class App {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3, 5);
        System.out.println(list.pop());
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
    }

}
