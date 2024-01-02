import java.util.Arrays;

public class 입국심사 {
    static int n = 6;
    static int[] times = {7, 10};
    static int res ;
    public static void main(String[] args) {



        int left = 1;
        int right = Arrays.stream(times).max().getAsInt() * n; // 가장 오래 걸리는 시간

        while (left <= right) {
            int mid = (left + right) / 2;

            int people = 0; // 상담 받은 사람
            for (int i : times) {
                people += mid / i; // 개인 상담원이 mid시간동안 상담 한 사람 추가
                if (people >= n) { // 상담한 사람이 많으면 더 안보고 break > 시간줄여
                    break;
                }
            }
//            상담 다 받음.
            if (people >= n) {
                res = mid;
                right = mid - 1;
//           상담 다 못함 시간 더 필요
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }
}
