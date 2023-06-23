class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUsinmgLinkedlist {
    Node front, rear;

    QueueUsinmgLinkedlist() {
        // Implement the Constructor
        front = null;
        rear = null;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        if (rear == front)
            return true;
        return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        Node node = new Node(data);
        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    int dequeue() {
        // Implement the dequeue() function
        if (isEmpty())
            return -1;
        int temp = front.data;
        front = front.next;
        if (rear == front) {
            rear = null;
        }
        return temp;
    }

    int front() {
        // Implement the front() function
        return front.data;
    }
}
