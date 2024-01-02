public class GreedyCoinProblem {
    static int[] coins = {1, 5, 10, 25};
    static int amount = 99;
    static int idx = coins.length - 1;
    static int count = 0;
    public static void main(String[] args) {
        while (idx >= 0) {
            if (coins[idx] <= amount) {
                count += amount / coins[idx];
                amount %= coins[idx];
            }
            idx -= 1;
        }
        System.out.println(count);
    }
}
