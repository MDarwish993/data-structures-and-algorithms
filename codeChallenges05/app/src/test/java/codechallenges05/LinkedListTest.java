package codechallenges05;
import linkedListDataStructure.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LinkedListTest {
    @Test
    public void testInstantiateEmptyList() {
        LinkedList linkedList = new LinkedList();

        assertNull(linkedList.head);
    }

    @Test
    public void testInsert() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);

        assertNotNull(linkedList.head);
        assertEquals(5, linkedList.head.value);
        assertNull(linkedList.head.next);
    }

    @Test
    public void testInsertMultipleNodes() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);

        assertNotNull(linkedList.head);
        assertEquals(30, linkedList.head.value);
        assertNotNull(linkedList.head.next);
        assertEquals(20, linkedList.head.next.value);
        assertNotNull(linkedList.head.next.next);
        assertEquals(10, linkedList.head.next.next.value);
        assertNull(linkedList.head.next.next.next);
    }

    @Test
    public void testIncludesExistingValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertTrue(linkedList.includes(10));
    }

    @Test
    public void testIncludesNonExistingValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertFalse(linkedList.includes(20));
    }

    @Test
    public void testToString() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertEquals("{ 15 } -> { 10 } -> { 5 } -> NULL", linkedList.toString());
    }
}
