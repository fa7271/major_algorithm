public class DFSArrayGraph {
    static boolean[] visited;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static StringBuilder sb;
    static int[][] graph = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0}
    };


    public static void main(String[] args) {
        visited = new boolean[graph.length];
        sb = new StringBuilder();
        sb.append(0).append(" ");
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 0; i <= 4; i++) {
            // 방문가능한 지역이고, 아직 방문 안 한 지역이면
            if (graph[node][i] == 1 && !visited[i]) {
                // 호출
                sb.append(i).append(" ");
                dfs(i);
            }
        }
    }

//    private static int dfs(int x, int y) {
//        visited[x][y] = true;
//        for (int[] direction: move ) {
//            int nx = x + direction[0];
//            int ny = y + direction[1];
//            if (graph[nx][ny] == 1 && !visited[nx][ny]) {
//                dfs(nx, ny);
//            }
//        }
//        return x;
}

