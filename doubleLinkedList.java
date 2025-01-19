package lab4;

class doublyLL{
    Node head;
    Node tail;

    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data= data;
            this.prev = null;
            this.next = null;
        }
    }

    public void traverseForward(){
        System.out.println("Traversing Forward: ");
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("\n");
    }

    //task
    public void traverseBackward(){
        if(tail == null){
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Traversing Backward: ");
        Node current = tail;
        while(current !=null){
            System.out.print(current.data+" ");
            current = current.prev;
        }
        System.out.println("\n");
    }

    public void insertAtStart(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }
        else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    //task
    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(Node prevNode,int data){
        Node newNode = new Node(data);
        Node temp = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = temp;
        if(temp !=null){
            temp.prev = newNode;
        }
    }

    //task.
    public void insertBefore(Node nextNode, int data){
        Node newNode = new Node(data);
        Node temp = nextNode.prev;
        nextNode.prev = newNode;
        newNode.next = nextNode;
        newNode.prev = temp;
        if(temp!=null){
            temp.next = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    //task
    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        if(tail.prev == null){
            head = tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteAt(int pos){
        Node temp = head;
        for(int i = 0;i<pos-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}


public class doubleLinkedList {
    public static void main(String[] args) {
        doublyLL dll = new doublyLL();
        dll.head = new doublyLL.Node(5);
        doublyLL.Node two = new doublyLL.Node(8);
        dll.tail = new doublyLL.Node(10);

        dll.head.next = two;
        two.prev = dll.head;

        two.next = dll.tail;
        dll.tail.prev = two;


        dll.insertAfter(two,14);
        dll.insertAtStart(45);
        dll.insertAtEnd(80);
        dll.insertBefore(two.next,50);
        dll.traverseForward();
        dll.traverseBackward();

        dll.deleteFirst();
        dll.traverseForward();
        dll.deleteLast();
        dll.traverseForward();
        dll.deleteAt(3);
        dll.traverseForward();
    }
}






