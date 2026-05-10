import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList; // Список смежности [cite: 36]

    public Graph() { adjList = new HashMap<>(); }

    public void addVertex(Vertex v) { // [cite: 38]
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) { // [cite: 39]
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
        }
    }

    public void printGraph() { // [cite: 40]
        adjList.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    // Алгоритм BFS (Обход в ширину) [cite: 43]
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int neighbor : adjList.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Алгоритм DFS (Обход в глубину) [cite: 44]
    public void dfs(int start) {
        dfsRecursive(start, new HashSet<>());
    }

    private void dfsRecursive(int curr, Set<Integer> visited) {
        visited.add(curr);
        System.out.print(curr + " ");
        for (int neighbor : adjList.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
}