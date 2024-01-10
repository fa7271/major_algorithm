import javax.swing.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 이중우선순위큐 {

    static class Node {
        int num;
        int idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        String[] operation = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        PriorityQueue<Node> min_heap = new PriorityQueue<>(((o1, o2) -> (o1.num - o2.num)));
        PriorityQueue<Node> max_heap = new PriorityQueue<>(((o1, o2) -> (o2.num - o1.num)));
        int[] visited = new int[operation.length];
        int i = 0;
        for (String op : operation) {
            String order = op.split(" ")[0];
            String act = op.split(" ")[1];

            if (order.equals("I")) {
                min_heap.add(new Node(Integer.valueOf(act), i));
                max_heap.add(new Node(Integer.valueOf(act), i));
            } else {
                if (Character.toString(act.charAt(0)).equals("-")) {
                    if (min_heap.size() != 0) {
                        visited[min_heap.peek().idx] = 1;
                    }
                } else {
                    if (max_heap.size() != 0) {
                        visited[max_heap.peek().idx] = 1;
                    }
                }
            }
            // 다음 제거 대상이 될 인덱스에 있는 원소가 이미 다른 쪽에서 지워진 원소면 제거
            while (!min_heap.isEmpty() && visited[min_heap.peek().idx] == 1) {
                min_heap.poll();
            }
            while (!max_heap.isEmpty() && visited[max_heap.peek().idx] == 1) {
                max_heap.poll();
            }
            i++;
        }
        int[] res = new int[]{0, 0};
        if (min_heap.size() == 0) {
            System.out.println(1);
        } else {
            res[0] = max_heap.peek().num;
            res[1] = min_heap.peek().num;
        }
        System.out.println(Arrays.toString(res));
    }
}

//    public static void main(String[] args) {
//        String[] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (String op : operation) {
//            String odrer = op.split(" ")[0];
//            String act = op.split(" ")[1];
////            insert 일경우
//            if (odrer.equals("I")) pq.add(Integer.valueOf(act));
//            else {
//                if (Character.toString(act.charAt(0)).equals("-")) pq.poll();
//                else {
//                    int x = pq.stream().mapToInt(Integer::intValue).max().orElse(0);
//                    pq.remove(x);
//                }
//            }
//        }
//        int x = pq.stream().mapToInt(Integer::intValue).max().orElse(0);
//        int y = pq.stream().mapToInt(Integer::intValue).min().orElse(0);
//        return new int[]{x, y};
//
//    }