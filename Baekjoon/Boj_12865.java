import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12865 {

    private static int N, K;
    private static Thing[] things;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        things = new Thing[N];
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            things[i] = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - things[i - 1].getWeight() >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - things[i - 1].getWeight()] + things[i - 1].getValue());
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    private static class Thing {
        private int weight;
        private int value;

        public Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }


    }
}
