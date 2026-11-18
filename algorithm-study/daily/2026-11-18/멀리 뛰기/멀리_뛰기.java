// 프로그래머스 Lv.2
public class 멀리_뛰기 {

    public long solution(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        멀리_뛰기 solution = new 멀리_뛰기();

        System.out.println(solution.solution(4)); // 5
        System.out.println(solution.solution(3)); // 3
    }
}
