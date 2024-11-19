package queue;

class linkedList{
    private Node front;
    private Node rear;

    static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void insertLast(int new_data){
        Node newNode = new Node(new_data);
        if(isEmpty()) {
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int deleteFirst(){
        int temp = front.data;
        if(front.next == null) {
            rear = null;
        }
        front = front.next;
        return temp;
    }

    public void displayList(){
        System.out.println("===Displaying elements of DEQ===");
        Node current = front;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class Queue2{
    linkedList ll;

    public Queue2(){
        ll = new linkedList();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }

    public void enqueue(int newData) {
        ll.insertLast(newData);
    }

    public int dequeue(){
        return ll.deleteFirst();
    }

    public void printQueue(){
        ll.displayList();
    }
}

public class queueWithLL {
    public static void main(String[] args) {
        Queue2 q = new Queue2();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.printQueue();
        q.dequeue();
        q.printQueue();
    }
}
