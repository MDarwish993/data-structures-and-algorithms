package stackDataStructure;

public class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public Boolean isEmpty(){
        return top==null;
    }

    public void push(T value){
        Node<T> newNode=new Node<>(value);
        newNode.next=top;
        top=newNode;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        T removedValue=top.value;
        top=top.next;
        return removedValue;
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return top.value;
    }

    public boolean validateBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty()) {
                    return false; // Closing bracket without a corresponding opening bracket
                }

                char top = stack.pop();
                if (!areBracketsMatching(top, character)) {
                    return false; // Mismatched brackets
                }
            }
        }

        return stack.isEmpty(); // If the stack is empty, all brackets are balanced.
    }

    private  boolean areBracketsMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }


}
