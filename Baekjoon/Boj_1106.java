import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 참고 링크 : https://jyeonnyang2.tistory.com/318#google_vignette
 */
public class Boj_1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] cities = new int[N][2];
        int[] dp = new int[C + 100];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            cities[i][0] = cost;
            cities[i][1] = customer;
        }

        for (int i = 0; i < C + 100; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; // 0명은 없는 거니까
        for (int i = 0; i < N; i++) {
            int cost = cities[i][0];
            int customer = cities[i][1];
            for (int j = customer; j < C + 100; j++) {
                if (dp[j - customer] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[j] = Math.min(dp[j], cost + dp[j - customer]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }


}
