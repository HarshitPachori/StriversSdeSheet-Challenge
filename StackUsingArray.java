public class StackUsingArray {

    int stack[];
    int top = -1;
    int n;

    StackUsingArray(int cap) {
        if (isFull() != 1) {
            stack = new int[cap];
            this.n = cap;
        }
    }

    void push(int num) {
        // Write your code here.
        if (isFull() != 1) {
            stack[++top] = num;
        }

    }

    int pop() {
        // Write your code here.
        if (isEmpty() != 1) {
            int x = stack[top--];
            return x;
        }
        return -1;
    }

    int top() {
        // Write your code here.
        if (isEmpty() != 1) {
            return stack[top];
        }
        return -1;
    }

    int isEmpty() {
        // Write your code here.
        if (top == -1)
            return 1;
        return 0;
    }

    int isFull() {
        // Write your code here.
        if (top == n) {
            return 1;
        }
        return 0;
    }

}
