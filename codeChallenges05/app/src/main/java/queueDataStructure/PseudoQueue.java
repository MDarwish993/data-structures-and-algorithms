package queueDataStructure;
import stackDataStructure.Stack;
public class PseudoQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public PseudoQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void enqueue(T value) {
        stack1.push(value);
    }


    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}


