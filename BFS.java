package lab11;

class vertexx {
    String label;
    boolean is_visited;
    vertexx[] neighbour;

    public vertexx(String label) {
        this.label = label;
        is_visited = false;
    }

    public void addNeighbours(vertexx[] v) {
        neighbour = new vertexx[v.length];
        for (int i = 0; i < v.length; i++) {
            neighbour[i] = v[i];
        }
    }
}

class edgee {
    vertexx start;
    vertexx end;

    public edgee(vertexx start, vertexx end) {
        this.start = start;
        this.end = end;
    }
}

class ll {
    Node front;
    Node rear;

    class Node {
        public vertexx data;
        public Node next;

        public Node(vertexx data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void insertLast(vertexx new_data) {
        Node newNode = new Node(new_data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void insertFirst(vertexx newData) {
        Node newNode = new Node(newData);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
    }

    public vertexx deleteFirst() {
        if (front == null) {
            return null;
        } else {
            vertexx temp = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return temp;
        }
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = front;
        while (current != null) {
            System.out.println(current.data.label + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Queue {
    lab11.ll ll;

    public Queue() {
        ll = new ll();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public void enqueue(vertexx newData) {
        ll.insertLast(newData);
    }

    public vertexx dequeue() {
        return ll.deleteFirst();
    }

    public vertexx front() {
        if (ll.front == null) {
            return null;
        } else {
            return ll.front.data;
        }
    }
}

class graphh {
    private int v;
    edgee[] edgeList;

    public graphh(int v) {
        this.v = v;
    }

    public vertexx createVertex(String label) {
        return new vertexx(label);
    }

    public edgee createEdge(vertexx start, vertexx end) {
        return new edgee(start, end);
    }

    public void createEdge(edgee[] edges) {
        edgeList = new edgee[edges.length];
        for (int i = 0; i < edgeList.length; i++) {
            edgeList[i] = edges[i];
        }
    }

    //task1
    //degree of a node = number of edges connected to that node.
    public void calculateDegree(){
        System.out.println("Node Degrees: ");
        if(edgeList == null){
            System.out.println("No edges in the graph.");
            return;
        }

        for(edgee e: edgeList){
            System.out.println(e.start.label + " -> "+e.end.label);
        }
    }

    //task2
    public void printGraphBF(Queue q) {
        if (q.front() != null) {
            q.front().is_visited = true;
        }
        vertexx current = q.dequeue();
        if (current == null) return;
        System.out.println(current.label);

        for (int i = 0; i < current.neighbour.length; i++) {
            if (!current.neighbour[i].is_visited) {
                q.enqueue(current.neighbour[i]);
                current.neighbour[i].is_visited = true;
            }
        }

        if (!q.isEmpty()) {
            printGraphBF(q);
        }
    }
}

public class BFS {
    public static void main(String[] args) {
        graphh graph = new graphh(5);
        vertexx a, b, c, d, e;
        a = graph.createVertex("A");
        b = graph.createVertex("B");
        c = graph.createVertex("C");
        d = graph.createVertex("D");
        e = graph.createVertex("E");

        a.addNeighbours(new vertexx[]{b, d});
        b.addNeighbours(new vertexx[]{a, c});
        c.addNeighbours(new vertexx[]{b});
        d.addNeighbours(new vertexx[]{a, e});
        e.addNeighbours(new vertexx[]{d});

        edgee[] edges = {
                graph.createEdge(a,b),
                graph.createEdge(a,d),
                graph.createEdge(b,c),
                graph.createEdge(d,e)
        };
        graph.createEdge(edges);

        graph.calculateDegree();

        System.out.println("Printing Graph: BFS");
        Queue q = new Queue();
        q.enqueue(a);
        graph.printGraphBF(q);
    }
}
