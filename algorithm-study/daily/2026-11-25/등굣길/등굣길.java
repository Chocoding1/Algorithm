// 프로그래머스 Lv.3
public class 등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (isBlocked(i, j, puddles)) {
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        return dp[n][m];
    }

    private boolean isBlocked(int i, int j, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (i == puddle[1] && j == puddle[0]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        등굣길 solution = new 등굣길();

        System.out.println(solution.solution(
                4,
                3,
                new int[][]{{2, 2}}
        )); // 4
    }
}
