package queueDataStructure;

public class Queue <T>{
    private Node<T> front;
    private Node<T> back;

    public Queue() {
        this.front = null;
        this.back=null;
    }

    public Boolean isEmpty(){
        return front==null;
    }

    public void enqueue(T value){
        Node<T> newNode=new Node<>(value);
        if (isEmpty()){
            front=newNode;
            back=newNode;
        }else {
            back.next=newNode;
            back=newNode;
        }
    }

    public T dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T removedValue= front.value;
        if (front==back){
            front=null;
            back=null;
        }else {
            front=front.next;
        }

        return removedValue;
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return front.value;
    }



}
