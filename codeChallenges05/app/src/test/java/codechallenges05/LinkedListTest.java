package codechallenges05;
import linkedListDataStructure.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LinkedListTest {
    @Test public void testInstantiateEmptyList() {
        LinkedList linkedList = new LinkedList();

        assertNull(linkedList.head);
    }

    @Test public void testInsert() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);

        assertNotNull(linkedList.head);
        assertEquals(5, linkedList.head.value);
        assertNull(linkedList.head.next);
    }

    @Test public void testInsertMultipleNodes() {
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

    @Test public void testIncludesExistingValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertTrue(linkedList.includes(10));
    }

    @Test public void testIncludesNonExistingValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertFalse(linkedList.includes(20));
    }

    @Test public void testToString() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertEquals("{ 15 } -> { 10 } -> { 5 } -> NULL", linkedList.toString());
    }

    @Test public void testAppend() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);

        assertNotNull(linkedList.head);
        assertEquals(5, linkedList.head.value);
        assertNull(linkedList.head.next);
    }

    @Test public void testAppendMultipleNodes() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);

        assertNotNull(linkedList.head);
        assertEquals(5, linkedList.head.value);
        assertNotNull(linkedList.head.next);
        assertEquals(10, linkedList.head.next.value);
        assertNotNull(linkedList.head.next.next);
        assertEquals(15, linkedList.head.next.next.value);
        assertNull(linkedList.head.next.next.next);
    }

    @Test public void testInsertBeforeMiddle() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);

        linkedList.insertBefore(10, 12);

        assertEquals("{ 5 } -> { 12 } -> { 10 } -> { 15 } -> NULL", linkedList.toString());
    }

    @Test public void testInsertBeforeFirst() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);

        linkedList.insertBefore(5, 2);

        assertEquals("{ 2 } -> { 5 } -> { 10 } -> { 15 } -> NULL", linkedList.toString());
    }

    @Test public void testInsertAfterMiddle() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);

        linkedList.insertAfter(10, 12);

        assertEquals("{ 5 } -> { 10 } -> { 12 } -> { 15 } -> NULL", linkedList.toString());
    }

    @Test public void testInsertAfterLast() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);

        linkedList.insertAfter(15, 20);

        assertEquals("{ 5 } -> { 10 } -> { 15 } -> { 20 } -> NULL", linkedList.toString());
    }

    @Test
    public void testKthFromEndGreaterThanLength() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertThrows(IllegalArgumentException.class, () -> linkedList.kthFromEnd(4));
    }

    @Test
    public void testKthFromEndKEqualsLength() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertThrows(IllegalArgumentException.class, () -> linkedList.kthFromEnd(4));
    }

    @Test
    public void testKthFromEndNegativeK() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(15);

        assertThrows(IllegalArgumentException.class, () -> linkedList.kthFromEnd(-1));
    }


    @Test
    public void testKthFromEndHappyPath() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(3);
        linkedList.insert(8);
        linkedList.insert(2);

        assertEquals(3, linkedList.kthFromEnd(2));
    }

    @Test
    public void testZipLists() {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(2);

        LinkedList list2 = new LinkedList();
        list2.insert(5);
        list2.insert(9);
        list2.insert(4);

        LinkedList zippedList = LinkedList.zipLists(list1, list2);
        assertEquals("{ 2 } -> { 4 } -> { 3 } -> { 9 } -> { 1 } -> { 5 } -> NULL", zippedList.toString());
    }

    @Test
    public void testZipListsWithDifferentLengths() {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);

        LinkedList list2 = new LinkedList();
        list2.insert(5);
        list2.insert(9);
        list2.insert(4);

        LinkedList zippedList = LinkedList.zipLists(list1, list2);
        assertEquals("{ 3 } -> { 4 } -> { 1 } -> { 9 } -> { 5 } -> NULL", zippedList.toString());
    }

    @Test
    public void testZipListsWithOneEmpty() {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(2);

        LinkedList list2 = new LinkedList();

        LinkedList zippedList = LinkedList.zipLists(list1, list2);
        assertEquals("{ 2 } -> { 3 } -> { 1 } -> NULL", zippedList.toString());
    }



}
