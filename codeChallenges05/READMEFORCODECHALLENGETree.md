# Challenge Tree
## Problem Domain
In this problem domain, we are tasked with creating classes and methods for handling binary trees and binary search trees (BSTs).
## Picture of whiteboard
I didn't make a white board for this challenge because it's not  one method challenge and i mentioned every thing here in reademe.

### - Initial BinaryTree  Method:
- preorderTraversal(node, traversal): Performs a preorder traversal of the tree starting from the given node and appends values to the traversal list.
- inorderTraversal(node, traversal): Performs an inorder traversal of the tree starting from the given node and appends values to the traversal list.
- postorderTraversal(node, traversal): Performs a postorder traversal of the tree starting from the given node and appends values to the traversal list.

### - Initial Binary Search Tree Class (BST)  Method:
- add(value): Adds a new node with the given value in the correct location within the binary search tree.
- contains(value): Checks if the tree contains a node with the specified value and returns a boolean indicating whether or not the value is in the tree at least once.

## - Algorithms:

1. Binary Tree Traversals:

Preorder Traversal (Root-Left-Right):

Start from the root node.
Visit the current node and append its value to the traversal list.
Recursively perform a preorder traversal on the left subtree.
Recursively perform a preorder traversal on the right subtree.
Inorder Traversal (Left-Root-Right):

Start from the root node.
Recursively perform an inorder traversal on the left subtree.
Visit the current node and append its value to the traversal list.
Recursively perform an inorder traversal on the right subtree.
Postorder Traversal (Left-Right-Root):

Start from the root node.
Recursively perform a postorder traversal on the left subtree.
Recursively perform a postorder traversal on the right subtree.
Visit the current node and append its value to the traversal list.
2. Binary Search Tree (BST) Operations:

add(value):

Start from the root node.
Compare the value to the current node's value.
If the value is less than the current node's value, move to the left subtree.
If the value is greater than the current node's value, move to the right subtree.
Repeat the process until you find an empty spot for the new node.
Insert the new node with the specified value at that spot.
contains(value):

Start from the root node.
Compare the value to the current node's value.
If the value matches the current node's value, return true.
If the value is less than the current node's value, move to the left subtree.
If the value is greater than the current node's value, move to the right subtree.
Repeat the process until you find a matching node or reach a leaf node.
If a matching node is found, return true; otherwise, return false.

## Solution

class Node:
value
liftChild
rightChild

    constructor(value):
        this.value = value
        this.liftChild = null
        this.rightChild = null

class BinaryTree:
root

    constructor(rootValue):
        this.root = new Node(rootValue)

    function preorderTraversal(node, traversal):
        if node is not null:
            traversal.append(node.value)
            preorderTraversal(node.liftChild, traversal)
            preorderTraversal(node.rightChild, traversal)

    function inorderTraversal(node, traversal):
        if node is not null:
            inorderTraversal(node.liftChild, traversal)
            traversal.append(node.value)
            inorderTraversal(node.rightChild, traversal)

    function postorderTraversal(node, traversal):
        if node is not null:
            postorderTraversal(node.liftChild, traversal)
            postorderTraversal(node.right, traversal)
            traversal.append(node.value)

class BinarySearchTree extends BinaryTree:

    constructor(rootValue):
        super(rootValue)

    function add(value):
        root = insert(root, value)

    function insert(root, value):
        if root is null:
            root = new Node(value)
            return root

        if value < root.value:
            root.left = insert(root.liftChild, value)
        else if value > root.value:
            root.right = insert(root.rightChild, value)

        return root

    function contains(value):
        return search(root, value)

    function search(root, value):
        if root is null:
            return false

        if root.value == value:
            return true

        if value < root.value:
            return search(root.liftChild, value)
        else:
            return search(root.rightChild, value)
