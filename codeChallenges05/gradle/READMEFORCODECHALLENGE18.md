# Challenge 18
####  fizz buzz tree.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc18.jpg "/>

### - Initial Breadth-first Traversal in a Binary Tree Method:
- Arguments: k-ary tree
- Return: new k-ary tree
## Solution

function fizzBuzzTree(root):

if root is null:

return null

    newRoot = new KTreeNode(root.value)
    for each child in root.children:
        newChild = fizzBuzzTree(child)
        add newChild to newRoot's children
    if root.value is divisible by 3 and divisible by 5:
        newRoot.value = "FizzBuzz"
    else if root.value is divisible by 3:
        newRoot.value = "Fizz"
    else if root.value is divisible by 5:
        newRoot.value = "Buzz"
    else:
        newRoot.value = convert root.value to string
    return newRoot
