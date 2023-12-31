import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    static int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist ;
    public static void main(String[] args) {
        IntStream.rangeClosed(0,edge.length).forEach(x->{
                graph.add(new ArrayList<>());
        });
        for (int[] node : edge) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }
        dist = new int[edge.length];
        dist[1] =1;
        LinkedList<Integer> Q = new LinkedList<>();
        Q.add(1);

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (Integer next_x : graph.get(x)){
                if (dist[next_x] == 0) {
                    dist[next_x] = dist[x] + 1;
                    Q.add(next_x);
                }
            }
        }
        long x = Arrays.stream(dist).max().getAsInt();
        long result = Arrays.stream(dist).filter(a -> a == x).count();
        System.out.println( (int) result ) ;

    }
}

