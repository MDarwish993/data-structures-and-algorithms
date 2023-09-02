package queueDataStructure;

public class Queue {
    private Node front;
    private Node back;

    public Queue() {
        this.front = null;
        this.back=null;
    }

    public Boolean isEmpty(){
        return front==null;
    }

    public void enqueue(int value){
        Node newNode=new Node(value);
        if (isEmpty()){
            front=newNode;
            back=newNode;
        }else {
            back.next=newNode;
            back=newNode;
        }
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int removedValue= front.value;
        if (front==back){
            front=null;
            back=null;
        }else {
            front=front.next;
        }

        return removedValue;
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return front.value;
    }



}
