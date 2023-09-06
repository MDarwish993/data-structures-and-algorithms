package codechallenges05;


import org.junit.jupiter.api.Test;
import queueDataStructure.PseudoQueue;
import stackDataStructure.Stack;
import queueDataStructure.Queue;
import static org.junit.jupiter.api.Assertions.*;

public class StackQueueTest {



    @Test
    void testStack() {
        Stack stack= new Stack();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertEquals(1, stack.peek());

        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());

        assertThrows(RuntimeException.class, () -> stack.pop());
        assertThrows(RuntimeException.class, () -> stack.peek());
    }

    @Test
    void testQueue() {
        Queue queue= new Queue();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertEquals(1, queue.peek());

        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());

        assertThrows(RuntimeException.class, () -> queue.dequeue());
        assertThrows(RuntimeException.class, () -> queue.peek());
    }

    @Test
    void testEnqueueAndDequeue() {
        PseudoQueue queue = new PseudoQueue();

        assertTrue(queue.isEmpty());

        queue.enqueue(10);
        assertEquals(10, queue.dequeue());

        queue.enqueue(15);
        queue.enqueue(20);
        assertEquals(15, queue.dequeue());
        assertEquals(20, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueueDequeueOrder() {
        PseudoQueue queue = new PseudoQueue();
        assertTrue(queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);

        assertEquals(10, queue.dequeue());
        queue.enqueue(25);
        assertEquals(15, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(25, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    void testEmptyQueue() {
        PseudoQueue queue = new PseudoQueue();
        assertTrue(queue.isEmpty());

        assertThrows(RuntimeException.class, () -> queue.dequeue());
        assertTrue(queue.isEmpty());

        queue.enqueue(10);
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

}
