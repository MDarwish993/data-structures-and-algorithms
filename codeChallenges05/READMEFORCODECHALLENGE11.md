# Challenge 11
#### Implement a Queue using two Stacks
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc11.jpg "/>

### - Initial PseudoQueue Class Methods:
enqueue:Inserts a value into the PseudoQueue, using a first-in, first-out approach.

dequeue:Extracts a value from the PseudoQueue, using a first-in, first-out approach.

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
