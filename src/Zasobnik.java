public class Zasobnik<T> {
    private Node<T> head;
    private int size;

    // Constructor
    public LIFO() {
        this.head = null;
        this.size = 0;
    }

    // Node class
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    // Push a new item onto the top of the stack
    public void push(T item) {
        Node<T> newNode = new Node<>(item, head);
        head = newNode;
        size++;
    }

    // Pop the top item off the stack and return it
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = head.data;
        head = head.next;
        size--;
        return item;
    }

    // Peek at the top item on the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return head.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the number of items in the stack
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
