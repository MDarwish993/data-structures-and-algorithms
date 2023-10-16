# Challenge InsertionSort
#### Pseudocode
Insert(int[] sorted, int value)

initialize i to 0

WHILE value > sorted[i]

set i to i + 1

WHILE i < sorted.length

set temp to sorted[i]

set sorted[i] to value

set value to temp

set i to i + 1

append value to sorted

InsertionSort(int[] input)

LET sorted = New Empty Array

sorted[0] = input[0]

FOR i from 1 up to input.length

Insert(sorted, input[i])

return sorted

## Trace
Sample Array:[8, 4, 23, 42, 16, 15]

1-Initial State - sorted is an empty array, and we take the first element of the input array, which is 8, and set it as the first element of sorted. Our arrays look like this:

input: [8, 4, 23, 42, 16, 15]
sorted: [8]

2-Insert 4 - We take the next element, 4, and insert it into the sorted array. Here's the step-by-step process:

- Compare 4 with 8. Since 4 is less than 8, we insert 4 before 8.
- sorted becomes [4, 8].

3-Insert 23 - We continue with 23. Here's the process:

- Compare 23 with 8. 23 is greater, so we leave it after 8.
- sorted becomes [4, 8, 23].

4-Insert 42 - 42 is greater than all the elements in the current sorted array, so we simply append it to the end:

- sorted becomes [4, 8, 23, 42].

5-Insert 16 - Now, we insert 16:

- Compare 16 with 42. 16 is less, so we move 42 one position to the right.
- Compare 16 with 23. 16 is less, so we move 23 one position to the right.
- Finally, we insert 16 in its correct position:
- sorted becomes [4, 8, 16, 23, 42].

6- Insert 15 - The last element is 15:

- Compare 15 with 42. 15 is less, so we move 42 one position to the right.
- Compare 15 with 23. 15 is less, so we move 23 one position to the right.
- Compare 15 with 16. 15 is less, so we move 16 one position to the right.
- Finally, insert 15 in its correct position:
- sorted becomes [4, 8, 15, 16, 23, 42].
- 
## Efficency
- Time Complexity: O(n^2).
- Space Complexity: O(1).

