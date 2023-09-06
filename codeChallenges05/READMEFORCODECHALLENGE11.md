# Challenge 11
#### Implement a Queue using two Stacks
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc11.jpg "/>

### - Initial PseudoQueue Class Methods:
enqueue:Inserts a value into the PseudoQueue, using a first-in, first-out approach , O(1).

dequeue:Extracts a value from the PseudoQueue, using a first-in, first-out approach , O(n) in the worst case , O(1) on average.

## Solution
public class Main {
public static void main(String[] args) {
PseudoQueue pseudoQueue = new PseudoQueue();
pseudoQueue.enqueue(10);
pseudoQueue.enqueue(15);
pseudoQueue.enqueue(20);

        System.out.println(pseudoQueue.dequeue());
        System.out.println(pseudoQueue.dequeue());
}
