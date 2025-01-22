package lab11;

class Vertex{
    String label;
    boolean is_visited;
    Vertex neighbour[];

    public Vertex(String label){
        this.label = label;
        is_visited = false;
    }

    public void addNeighbours(Vertex[] v){
        neighbour = new Vertex[v.length];
        for(int i = 0;i < v.length;i++){
            neighbour[i] = v[i];
        }
    }
}

class Edge{
    Vertex start;
    Vertex end;

    public Edge(Vertex start, Vertex end){
        this.start = start;
        this.end = end;
    }
}

class LinkedListStack{
    LinkedList li = new LinkedList();

    public void push(Vertex element){
        li.insertFirst(element);
    }

    public void pop(){
        li.deleteFirst();
    }

    public void displayStack(){
        System.out.println(" ");
        li.displayList();
    }

    public Vertex peek(){
        return li.front.data;
    }
}

class LinkedList{
    Node front;
    Node rear;

    class Node{
        public Vertex data;
        public Node next;
        public Node(Vertex data){
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void insertLast(Vertex new_data){
        Node newNode = new Node(new_data);
        if(!isEmpty()){
            front = newNode;
        }else{
            newNode.next = front;
            front = newNode;
        }
    }

    public void insertFirst(Vertex newData){
        Node newNode = new Node(newData);
        if(isEmpty()){
            front = newNode;
        }else{
            newNode.next = front;
            front = newNode;
        }
    }

    public Vertex deleteFirst(){
        if(front == null){
            return null;
        }else{
            Vertex temp = front.data;
            if(front.next == null){
                rear = null;
            }
            front = front.next;
            return temp;
        }
    }

    public Vertex deleteLast(){
        Vertex temp = rear.data;
        Node current = front;
        while(current.next != null){
            current = current.next;
        }
        current.next = null;
        rear = current;
        return temp;
    }

    public void displayList(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return;
        }

        Node current = front;
        while(current != null){
            System.out.println(current.data.label + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Graph{
    private int v;
    Edge[] edgeList;

    public Graph(int v){
        this.v = v;
    }

    public Vertex createVertex(String label){
        return new Vertex(label);
    }

    public Edge createEdge(Vertex start, Vertex end){
        return new Edge(start,end);
    }

    public void createEdge(Edge[] edges){
        edgeList = new Edge[edges.length];
        for(int i=0;i<edgeList.length;i++){
            edgeList[i] = edges[i];
        }
    }

    //task1
    public void calculateDegree(){
        System.out.println("Node Degrees: ");
        if(edgeList == null){
            System.out.println("No edges in the graph.");
            return;
        }

        for(Edge e: edgeList){
            System.out.println(e.start.label + " -> "+e.end.label);
        }
    }

    //task2
    public void printGraphDF(LinkedListStack s){
        s.peek().is_visited = true;
        Vertex current = s.peek();
        if(current == null) return;
        System.out.println(""+current.label);
        s.pop();
        for(int i=0;i<current.neighbour.length;i++){
            if(current.neighbour[i].is_visited != true){
                s.push(current.neighbour[i]);
                printGraphDF(s);
            }
        }

    }
}

public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        Vertex a, b, c, d, e;
        a = graph.createVertex("A");
        b = graph.createVertex("B");
        c = graph.createVertex("C");
        d = graph.createVertex("D");
        e = graph.createVertex("E");

        a.addNeighbours(new Vertex[]{b, d});
        b.addNeighbours(new Vertex[]{a, c});
        c.addNeighbours(new Vertex[]{b});
        d.addNeighbours(new Vertex[]{a, e});
        e.addNeighbours(new Vertex[]{d});

        Edge[] edges = {
                graph.createEdge(a,b),
                graph.createEdge(a,d),
                graph.createEdge(b,c),
                graph.createEdge(d,e)
        };
        graph.createEdge(edges);

        graph.calculateDegree();

        LinkedListStack ls = new LinkedListStack();
        ls.push(a);
        System.out.println("Printing Graph: DFS");
        graph.printGraphDF(ls);
    }
}
