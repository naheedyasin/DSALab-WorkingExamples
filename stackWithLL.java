package com.stack;
//creating stack using linked list.

class LinkedList{
    private Node top;

    public static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public void insertFirst(int data){
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    public Node deleteFirst(){
        Node temp = top;
        top = top.next;
        return temp;
    }

    public void displayList(){
        Node current = top;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class linkedListStack{
    LinkedList ll = new LinkedList();

    public void push(int element){
        ll.insertFirst(element);
    }

    public void pop(){
        ll.deleteFirst();
    }

    public void displayStack(){
        System.out.println("  ");
        ll.displayList();
    }
}

public class stackWithLL {
    public static void main(String[] args) {
        linkedListStack st = new linkedListStack();

        st.push(50);
        st.push(70);
        st.push(190);
        System.out.println("1.Stack after push operation: ");
        st.displayStack();
        st.pop();
        System.out.println("\n2.Stack after pop operation: ");
        st.displayStack();
    }

}
