public class QueueUsingArray {

    int front;
    int rear;
    int currSzie;
    int maxSize = 5000;
    int q[];

    QueueUsingArray() {
        // Implement the Constructor
        q = new int[maxSize];
        front = -1;
        rear = -1;
        currSzie = 0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        if (front == -1) {
            return true;
        }
        return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        if (currSzie == maxSize) {
            return;
        }
        if (rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxSize;
        }
        q[rear] = data;
        currSzie++;
    }

    int dequeue() {
        // Implement the dequeue() function

        if (isEmpty()) {
            return -1;
        }
        int ele = q[front];
        if (currSzie == 1) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
        currSzie--;
        return ele;
    }

    int front() {
        // Implement the front() function
        if (!isEmpty()) {
            return q[front];
        }
        return -1;
    }

}
