package stackDataStructure;

public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public Boolean isEmpty(){
        return top==null;
    }

    public void push(int value){
        Node newNode=new Node(value);
        newNode.next=top;
        top=newNode;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int removedValue=top.value;
        top=top.next;
        return removedValue;
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return top.value;
    }


}
