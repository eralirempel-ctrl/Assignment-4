public class Experiment {
    public static void runTraversals(Graph g, int startNode) { // [cite: 48]
        System.out.print("BFS: ");
        g.bfs(startNode);
        System.out.print("\nDFS: ");
        g.dfs(startNode);
        System.out.println();
    }

    public static void runMultipleTests() { // [cite: 49]
        int[] sizes = {10, 30, 100}; // [cite: 61, 62]
        for (int size : sizes) {
            Graph g = new Graph();
            for (int i = 0; i < size; i++) g.addVertex(new Vertex(i));
            for (int i = 0; i < size - 1; i++) g.addEdge(i, i + 1); // Создаем цепочку

            System.out.println("\n--- Testing Graph Size: " + size + " ---");

            long start = System.nanoTime(); // [cite: 68]
            g.bfs(0);
            long end = System.nanoTime(); // [cite: 69]
            System.out.println("\nBFS Time: " + (end - start) + " ns");

            start = System.nanoTime();
            g.dfs(0);
            end = System.nanoTime();
            System.out.println("\nDFS Time: " + (end - start) + " ns");
        }
    }
}
