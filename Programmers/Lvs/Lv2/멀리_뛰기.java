package Lv2;

public class 멀리_뛰기 {

    /**
     * 내 풀이
     */
    static public long solution(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    /**
     * AI 풀이
     */

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }
}
