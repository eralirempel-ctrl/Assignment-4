// Bonus
public class Main {
    public static void main(String[] args) {
        Experiment.runMultipleTests();

        System.out.println("\n=== Bonus: Dijkstra's Algorithm ===");
        Graph g = new Graph();
        for (int i = 0; i < 6; i++) g.addVertex(new Vertex(i));

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 10);
        g.addEdge(2, 4, 3);
        g.addEdge(4, 3, 4);
        g.addEdge(3, 5, 11);
        g.addEdge(4, 5, 7);

        g.dijkstra(0);
    }
}
