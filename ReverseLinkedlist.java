

public class ReverseLinkedlist {
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static LinkedListNode<Integer> reverseLinkedListIterative(LinkedListNode<Integer> head) {
        // Write your code here!
        LinkedListNode<Integer> newHead = null;
        LinkedListNode<Integer> curr = head;

        while (curr != null) {
            LinkedListNode<Integer> nextNode = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = nextNode;

        }
        return newHead;
    }

    public static LinkedListNode<Integer> reverseLinkedListRecursive(LinkedListNode<Integer> head) {
        // Write your code here!
        if (head == null || head.next == null)
            return head;
        LinkedListNode<Integer> newNode = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
