import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17404 {

    private static final int INF = 1000 * 1000;
    private static int[][] cost;
    private static int[][] dp;
    private static int N;
    private static int ans = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) { // 1번 집부터 N번 집까지
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) { // R, G, B 입력값
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int color = 0; color < 3; color++) { // 첫 번 째 집을 각각 R, G, B로 색칠하며 시작하는 세 경우를 계산
            for (int i = 0; i < 3; i++) {
                if (i == color) {
                    dp[1][i] = cost[1][i];
                } else {
                    dp[1][i] = INF;
                }
            }

            for (int i = 2; i <= N; i++) {
                // 현재 집을 각각 R, G, B로 칠할 때, 이전 집의 색과 겹치지 않는 것만 골라서 그 중 최솟값과 현재 집을 칠하는 비용을 더하며 dp 완성시킨다.
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i == color) continue; // 첫 번 째 집에 칠해진 색과 같을 경우 결과값 계산에 포함하지 않는다.

                ans = Math.min(ans, dp[N][i]); // N번째 집까지 특정 색으로 칠했을 때 총 비용의 최솟값을 구한다.
            }
        }

        System.out.println(ans);
    }
}
