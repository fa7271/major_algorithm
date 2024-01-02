import java.util.Arrays;

public class DPcoinProblem {
    static int[] dp;

    public static void main(String[] args) {
        int[] coins = {1, 4, 5};
        int target = 13;
        int[] targetlst = {13, 12, 9, 8};
        dp = new int[Arrays.stream(targetlst).max().getAsInt() + 1];
        dp[2] = 2;
        dp[3] = 3;
        dp[1] = dp[4] = dp[5] = 1;
        for (int i = 5; i <= target; i++) {
//            int min = (int) 1e9;
//            for (int c : targetlst) {
//                if (i - c < 0) {
//                    continue;
//                }
//                if (min > dp[i - c]) {
//                    min = dp[i - c];
//                }
//            }

            dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 4]), dp[i - 5]) + 1;
        }
        Arrays.stream(targetlst).forEach(x -> System.out.println(dp[x]));
    }
}
