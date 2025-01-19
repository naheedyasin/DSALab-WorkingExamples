package lab3;

//singly linked list.

class linkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void traverseList(){
        Node n = head;
        while(n !=  null){
            System.out.print(n.data+" ");
            n = n.next;
        }
    }

    public void addAtFront(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addAt(int pos,int data){
        Node newNode = new Node(data);

        if(pos ==0){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for(int i = 0;i<pos-1 && current !=null;i++){
            current = current.next;
        }

        if(current == null){
            System.out.println("Position out of bound.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void addAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void deleteNode(int pos){
        if(head == null || pos <1){
            System.out.println("Position out of bounds or list is empty.");
            return;
        }

        if(pos == 0){
            head = head.next;
            return;
        }

        Node current = head;
        for(int i=0;i<pos-1&&current !=null;i++){
            current = current.next;
        }

        if(current == null || current.next == null){
            System.out.println("Position out of bounds.");
            return;
        }

        current.next = current.next.next;
    }

    public boolean search(int x){
        Node current = head;
        while(current!=null){
            if(current.data == x){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //lab assignment...
    public void findLength(){
        int count = 0;

        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        System.out.println("\nThe length of the Linked list is = "+count);
    }

    public void getMiddleNode(){
        if(head == null){
            System.out.println("\nThe list is empty.");
            return;
        }

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("\nMiddle node = "+slow.data);

    }

    public linkedList reverse() {
        linkedList reversedList = new linkedList();
        Node current = head;

        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = reversedList.head;
            reversedList.head = newNode;
            current = current.next;
        }

        return reversedList;
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public static linkedList merge(linkedList list1, linkedList list2) {
        linkedList mergedList = new linkedList();
        Node dummy = new Node(0);
        Node tail = dummy;
        Node l1 = list1.head, l2 = list2.head;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        mergedList.head = dummy.next;
        return mergedList;
    }

    public void deleteAll() {
        head = null;
    }

}

public class LinkedListMain{
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.addAtEnd(70);
        ll.addAtEnd(50);
        ll.addAtEnd(12);
        ll.addAtFront(20);
        ll.addAt(2,18);
        ll.addAtEnd(4);
        ll.addAtEnd(4);

        ll.traverseList();
        ll.findLength();
        ll.getMiddleNode();

        linkedList reversedList = ll.reverse();
        System.out.println("\nReversed List: ");
        reversedList.traverseList();

        System.out.println("\n\nRemove Duplicates: ");
        ll.removeDuplicates();
        ll.traverseList();

        linkedList list2 = new linkedList();
        list2.addAtEnd(5);
        list2.addAtEnd(10);
        list2.addAtEnd(6);
        linkedList mergedList = linkedList.merge(ll, list2);
        System.out.println("\n\nMerged List:");
        mergedList.traverseList();

        ll.deleteAll();
        System.out.println("\n\nList after deletion:");
        ll.traverseList();

    }
}
