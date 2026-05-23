// Bonus
import java.util.*;

public class Graph {
    private Map<Integer, List<int[]>> adjList;

    public Graph() { adjList = new HashMap<>(); }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int weight) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(new int[]{to, weight});
            adjList.get(to).add(new int[]{from, weight});
        }
    }

    public void printGraph() {
        adjList.forEach((key, value) -> {
            System.out.print(key + " -> ");
            for (int[] edge : value) {
                System.out.print(edge[0] + "(w=" + edge[1] + ") ");
            }
            System.out.println();
        });
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int[] edge : adjList.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(edge[0])) {
                    visited.add(edge[0]);
                    queue.add(edge[0]);
                }
            }
        }
    }

    public void dfs(int start) {
        dfsRecursive(start, new HashSet<>());
    }

    private void dfsRecursive(int curr, Set<Integer> visited) {
        visited.add(curr);
        System.out.print(curr + " ");
        for (int[] edge : adjList.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(edge[0])) {
                dfsRecursive(edge[0], visited);
            }
        }
    }

    public void dijkstra(int start) {
        int n = adjList.size();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            if (u == -1) break;
            visited[u] = true;

            for (int[] edge : adjList.getOrDefault(u, new ArrayList<>())) {
                int v = edge[0];
                int w = edge[1];
                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                }
            }
        }

        printDijkstraResults(start, dist, parent);
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printDijkstraResults(int start, int[] dist, int[] parent) {
        System.out.println("\nDijkstra from vertex " + start + ":");
        System.out.printf("%-10s %-12s %s%n", "Vertex", "Distance", "Path");
        System.out.println("----------------------------------");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.printf("%-10d %-12s %s%n", i, "Unreachable", "N/A");
            } else {
                System.out.printf("%-10d %-12d %s%n", i, dist[i], buildPath(parent, i));
            }
        }
    }

    private String buildPath(int[] parent, int v) {
        if (parent[v] == -1) return String.valueOf(v);
        return buildPath(parent, parent[v]) + " -> " + v;
    }
}
