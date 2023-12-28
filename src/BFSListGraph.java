import java.util.*;
import java.util.stream.IntStream;

public class BFSListGraph {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[5];
    static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[] dist = new int[5];

    static int n = 4;
    static StringBuilder sb;
    public static void main(String[] args) {
        int[][] inputArr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] node : inputArr) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }
        bfs(0);
        System.out.println(Arrays.toString(dist));
    }

    static void bfs(int node) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        visited[0] = true;
        while (!Q.isEmpty()) {
            int dx = Q.poll();
            System.out.println(dx + " ");
            for (int nx : graph.get(dx)) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    dist[nx] = dist[dx] + 1;
                    Q.add(nx);
                }
            }
        }
    }
}
