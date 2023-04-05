public class FIFO<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public FIFO() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public T dequeue() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T item = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return item;
    }
    
    public T peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }
    
    public int size() {
        return size;
    }
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
}
