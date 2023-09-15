public class w4Arr {
    public static void main(String[] args) {
        ArrayQueue<Integer> test = new ArrayQueue<>();
        test.enQueue(4);
        test.enQueue(2);
        test.enQueue(3);
        System.out.println(test.getSize());
        System.out.println(test.peekFront());
        test.deQueue();
        System.out.println(test.peekFront());

    }
    
}
@SuppressWarnings("unchecked")
class ArrayQueue<T> {
    private int size, front, rear;

    private static int MAX_SIZE = 1000000;
    private T[] items;

    public ArrayQueue() {
        size = front = rear = 0;
        items = (T[])new Object[MAX_SIZE];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean enQueue(T data) {
        if (size < MAX_SIZE) {
            items[rear] = data;
            rear = (rear + 1) % MAX_SIZE;
            size++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (this.isEmpty()) return false;
        front = (front + 1) % MAX_SIZE;
        size--;
        return true;
    }

    public T peekFront() {
        if (this.isEmpty()) return null;

        return items[front];
    }
}

class LinkedListQueue<T> {
    static class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }
    private int size;
    private Node<T> head;
    public LinkedListQueue() {
        this.size = 0;
        this.head = null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return size;
    }

    public boolean enQueue(T data) {
        Node<T> a = new Node<T>(data);
        a.next = head;
        head = a;
        size++;
        return true;
    }

    public boolean deQueue() {
        Node<T> temp = head;
        if (this.isEmpty()) return false;
        if (head.next == null) head = null; 
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return true;
    }
    public T peekFront() {
        Node<T> temp = head;
        if (this.isEmpty()) return null;
        // if (head.next == null) return head.data; 
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }
}
