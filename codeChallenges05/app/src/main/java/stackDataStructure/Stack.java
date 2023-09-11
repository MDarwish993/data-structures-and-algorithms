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


}
