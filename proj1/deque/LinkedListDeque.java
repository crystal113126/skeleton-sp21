package deque;
class Node <T>{
    Node prev;
    T item;
    Node next;
    Node(Node prev, T item, Node next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }
public class LinkedListDeque<T> {


    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;

    }
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;

    }
    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node pos = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.println(pos.item + "->");
            pos = pos.next;
        }
        System.out.println(pos.item);

    }
    public T removeLast() {
        if (sentinel.prev == sentinel)
            return null;
        Node temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return temp.item;

    }

    public T get(int index) {
        Node pos = sentinel.next;
        if (index >= size)
            return null;
        while (index-- > 0) {
            pos = pos.next;
        }
        return pos.item;
    }
}
}
