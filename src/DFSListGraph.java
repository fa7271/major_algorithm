import java.util.ArrayList;
import java.util.stream.IntStream;

public class DFSListGraph {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[5];
    static int[][] graph_input = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0}
    };

    static int n = 4;
    static StringBuilder sb;

    public static void main(String[] args) {
//        int[][] inputArr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
//        for (int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for (int[] node : inputArr) {
//            graph.get(node[0]).add(node[1]);
//            graph.get(node[1]).add(node[0]);
//        }
//        System.out.println(graph);
        sb = new StringBuilder().append(0).append(" ");
        IntStream.rangeClosed(0, 4).forEach(x ->
        {
            graph.add(new ArrayList<>());
            IntStream.rangeClosed(0, 4).filter(y -> graph_input[x][y] == 1).forEach(y -> {
                graph.get(x).add(y);
            });
        });
        System.out.println(graph);
        dfs(0);
        System.out.println("sb = " + sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int nextnode : graph.get(node)) {
            if (!visited[nextnode]) {
                sb.append(nextnode).append(" ");
                dfs(nextnode);
            }
        }
    }
}

