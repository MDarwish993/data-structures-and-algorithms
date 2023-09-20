# Challenge 17
#### Breadth-first Traversal.
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc17.jpg "/>

### - Initial Breadth-first Traversal in a Binary Tree Method:
- Arguments: tree
- Return: list of all values in the tree, in the order they were encountered
## Solution
Function breadthFirst():
Initialize an empty list called result to store the traversal values.

    If the root of the binary tree is null:
        Return the empty result list.
    
    Initialize an empty list called treeValues.
    Add the root node of the binary tree to the treeValues list.
    
    While treeValues is not empty:
        Remove the first node (front) from treeValues and store it in a variable called current.
        Add the value of current to the result list.
        
        If current has a left child:
            Add the left child to the treeValues list.
        
        If current has a right child:
            Add the right child to the treeValues list.
    
    Return the result list containing the breadth-first traversal values.