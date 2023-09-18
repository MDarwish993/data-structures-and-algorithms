# Challenge 16
#### Find the Maximum Value in a Binary Tree
## Picture of whiteboard
<img src="C:\Users\C-ROAD\IdeaProjects\data-structures-and-algorithms\codeChallenges05\app\src\assets\cc16.jpg "/>

### - Initial Maximum Value in a Binary Tree Method:
- findMax Method:
  - Arguments: none
  - Returns: number
  
- findMaxRecursive Method:
  - Arguments: node
  - Returns: number
  
## Solution
function findMax():
if root is null:
throw IllegalStateException("The tree is empty")
return findMaxRecursive(root)

function findMaxRecursive(node):
if node is null:
return Integer.MIN_VALUE
leftMax = findMaxRecursive(node.getLeftChild())  
rightMax = findMaxRecursive(node.getRightChild())  
return max(node.getValue(), max(leftMax, rightMax))