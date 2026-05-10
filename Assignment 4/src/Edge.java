public class Edge {
    private Vertex source; // [cite: 26]
    private Vertex destination; // [cite: 28]

    public Edge(Vertex source, Vertex destination) { // [cite: 31]
        this.source = source;
        this.destination = destination;
    }
    public Vertex getSource() { return source; } // [cite: 32]
    public Vertex getDestination() { return destination; } // [cite: 32]
    @Override
    public String toString() { return source + " -> " + destination; } // [cite: 33]
}