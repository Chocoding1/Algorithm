import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1149 {

/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] prices = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                prices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = prices[0][0];
        dp[0][1] = prices[0][1];
        dp[0][2] = prices[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + prices[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + prices[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + prices[i][2];
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
*/

    private static int[][] dp, prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        prices = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                prices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = prices[0][0];
        dp[0][1] = prices[0][1];
        dp[0][2] = prices[0][2];

        System.out.println(Math.min(getMinPrice(N - 1, 0), Math.min(getMinPrice(N - 1, 1), getMinPrice(N - 1, 2))));
    }

    private static int getMinPrice(int n, int col) {

        if (dp[n][col] == 0) {
            if (col == 0) {
                dp[n][col] = Math.min(getMinPrice(n - 1, 1), getMinPrice(n - 1, 2)) + prices[n][col];
            } else if (col == 1) {
                dp[n][col] = Math.min(getMinPrice(n - 1, 0), getMinPrice(n - 1, 2)) + prices[n][col];
            } else {
                dp[n][col] = Math.min(getMinPrice(n - 1, 0), getMinPrice(n - 1, 1)) + prices[n][col];
            }
        }

        return dp[n][col];
    }
}
