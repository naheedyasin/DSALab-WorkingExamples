package lab5;
//singly circular linked list.

class circularLL{
    Node head;
    Node tail;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void traversal(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do{
            System.out.print(current.data+" ");
            current = current.next;
        }while(current!=head);
        System.out.println("(head)");
    }

    public void insertAtHead(int data){

        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            newNode.next = head;
        }else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void insertAt(int pos,int data){
        Node newNode = new Node(data);
        if(pos == 0){
            insertAtHead(data);
            return;
        }
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        for(int i=1;i<pos;i++){
            if(current.next == head){
                System.out.println("Position exceeds the size of the list.");
                return;
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
         //10 20 30 40 50 60 ,pos = 2 = 30,
    }

    public void insertAtEnd(int data){
        if(head == null){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty.");return;
        }
        if(head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty.");return;
        }
        if(head == tail){
            head = tail = null; return;
        }
        Node current = head;
        while(current.next != tail){
            current = current.next;
        }

        current.next = head;
        tail = current;
    }

    public void deleteAt(int pos){
        if(head == null){
            System.out.println("List is empty."); return;
        }
        if(pos == 0) {
            if (head == tail) {
                head = tail = null;
            }else{
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node current = head;
        for(int i=0;i<pos-1;i++){
            if(current.next == head){
                System.out.println("Invalid position.Position out of bounds");
                return;
            }
            current = current.next;
        }
        if(current.next == tail){
            tail = current;
        }
        current.next = current.next.next;

    }
}
public class circularLinkedList {
    public static void main(String[] args) {
        circularLL cll = new circularLL();
        cll.head = new circularLL.Node(10);
        circularLL.Node two = new circularLL.Node(20);
        circularLL.Node three = new circularLL.Node(30);
        cll.tail = new circularLL.Node(40);

        cll.head.next = two;
        two.next = three;
        three.next = cll.tail;
        cll.tail.next = cll.head;
        cll.insertAtHead(50);
        cll.insertAt(2,60);
        cll.insertAtEnd(70);

        cll.traversal();
        cll.deleteFirst();
        cll.traversal();
        cll.deleteLast();
        cll.traversal();
        cll.deleteAt(4);
        cll.traversal();


    }
}
