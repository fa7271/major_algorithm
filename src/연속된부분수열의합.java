import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 연속된부분수열의합 {
    static int[] sequence = {1, 1, 1, 2, 3, 4, 5};
    static int k = 5;

    // sum : 총합 end 마지막 인덱스
    static int sum, end;

    //    k를 만들었을때, 시작인덱스, 마지막인덱스, 두 인덱스 차이 저장
    static class Node {
        int start;
        int end;
        int count;

        public Node(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        //        정렬을 하기 위해
        public int getCount() {
            return count;
        }
    }

    // 투포인터 start, end = 0,0
    public static void main(String[] args) {
//        k 를 만들 수 있는 리스트
        List<Node> list = new ArrayList<>(); // 1
        ArrayList<Point> arrayList = new ArrayList<>();
//        i 는 시작인덱스
        for (int i = 0; i < sequence.length; i++) {
//            end를 하나씩 늘려가며 sum을 더해주고, sum이 K보다 작을때
            while (sum < k && end < sequence.length) {
                sum += sequence[end];
                end += 1;
            }
//            k랑 같을때는 정답 후보 이므로 list에 넣어줌.
            if (sum == k) {
//                시작점, 끝점, 갯수
                list.add(new Node(i, end - 1, end - i - 1));
            }
//            start 부분이 한 칸 올라감.
            sum -= sequence[i];
        }
//        카운트 기준 정렬

//        list.sort(Comparator.comparing(Node::getCount));
//        int x = list.get(0).start;
//        int y = list.get(0).end;
//        int[] res = {x, y};

        list.sort((o1, o2) -> o1.count - o2.count);
        System.out.println(new int[]{list.get(0).start, list.get(0).end});

    }
}
