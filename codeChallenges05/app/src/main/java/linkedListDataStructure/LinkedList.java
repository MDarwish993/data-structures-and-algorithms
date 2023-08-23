package linkedListDataStructure;

public class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public boolean includes(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertBefore(int targetValue, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            head = newNode;
            return;
        }

        if (head.value == targetValue) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != targetValue) {
            current = current.next;
        }

        if (current.next != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void insertAfter(int targetValue, int newValue) {
        Node newNode = new Node(newValue);

        Node current = head;
        while (current != null && current.value != targetValue) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }


    public int kthFromEnd(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("k must be a non-negative integer");
        }

        Node slow = head;
        Node fast = head;


        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("k is greater than the length of the linked list");
            }
            fast = fast.next;
        }


        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow == null) {
            throw new IllegalArgumentException("k is greater than the length of the linked list");
        }

        return slow.value;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append("{ ").append(current.value).append(" } -> ");
            current = current.next;
        }
        result.append("NULL");
        return result.toString();
    }


}
