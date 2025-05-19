import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2096 {

    private static int N;
    private static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();

        int maxSum = Math.max(calMax(N - 1, 0), Math.max(calMax(N - 1, 1), calMax(N - 1, 2)));
        sb.append(maxSum).append(" ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        int minSum = Math.min(calMin(N - 1, 0), Math.min(calMin(N - 1, 1), calMin(N - 1, 2)));
        sb.append(minSum);

        System.out.println(sb);
    }

    private static int calMax(int n, int idx) {
        if (n == 0) {
            return arr[0][idx];
        }

        if (dp[n][idx] != -1) {
            return dp[n][idx];
        }

        if (idx == 0) {
            dp[n][idx] = Math.max(calMax(n - 1, 0), calMax(n - 1, 1));
        } else if (idx == 1) {
            dp[n][idx] = Math.max(calMax(n - 1, 0), Math.max(calMax(n - 1, 1), calMax(n - 1, 2)));
        } else {
            dp[n][idx] = Math.max(calMax(n - 1, 1), calMax(n - 1, 2));
        }
        dp[n][idx] += arr[n][idx];

        return dp[n][idx];
    }

    private static int calMin(int n, int idx) {
        if (n == 0) {
            return arr[0][idx];
        }

        if (dp[n][idx] != -1) {
            return dp[n][idx];
        }

        if (idx == 0) {
            dp[n][idx] = Math.min(calMin(n - 1, 0), calMin(n - 1, 1));
        } else if (idx == 1) {
            dp[n][idx] = Math.min(calMin(n - 1, 0), Math.min(calMin(n - 1, 1), calMin(n - 1, 2)));
        } else {
            dp[n][idx] = Math.min(calMin(n - 1, 1), calMin(n - 1, 2));
        }
        dp[n][idx] += arr[n][idx];

        return dp[n][idx];
    }
}
