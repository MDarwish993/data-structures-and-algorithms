# Challenge 05&06
#### Linked list implimintaion

## Approach & Efficiency
### - Initial LinkedList Class Methods:

insert: Inserts a new node at the beginning of the list.
includes: Checks if a value exists in the list.
toString: Creates a string representation of the list.
Approach: These methods operate by traversing the linked list linearly.

Time Complexity: O(n), where n is the number of nodes in the linked list.

Space Complexity: O(1) for each method.

### - Additional LinkedList Class Methods (Append, Insert Before, Insert After):

append: Adds a new node to the end of the list.
insertBefore: Inserts a new node before a given target value.
insertAfter: Inserts a new node after a given target value.
kthFromEnd:Return the node’s value that is k places from the tail of the linked list.
Approach: These methods also involve traversing the linked list linearly, either to find the last node or to locate the target node.

Time Complexity: O(n), where n is the number of nodes in the linked list.

Space Complexity: O(1) for each method.

## Solution
public class Main {
public static void main(String[] args) {
LinkedList linkedList = new LinkedList();

        linkedList.insert(3);
        linkedList.insert(7);
        linkedList.insert(10);

        System.out.println("Linked List: " + linkedList);
        System.out.println("Includes 7? " + linkedList.includes(7));
        System.out.println("Includes 5? " + linkedList.includes(5));

        linkedList.append(20);
        System.out.println("After Append: " + linkedList);

        linkedList.insertBefore(7, 5);
        System.out.println("After Insert Before: " + linkedList);

        linkedList.insertAfter(7, 8);
        System.out.println("After Insert After: " + linkedList);

        System.out.println("kthFromEnd 0 : "+ myLinkedList.kthFromEnd(0));
    }
}
