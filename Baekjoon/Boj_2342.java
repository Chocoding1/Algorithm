import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2342 {

    private static final int[][] COST = new int[5][5];
    private static final List<Integer> STEP = new ArrayList<>();
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                break;
            }
            STEP.add(num);
        }
        dp = new int[STEP.size() + 1][5][5];

        setCost();

        System.out.println(search(0, 0, 0));

    }

    private static int search(int idx, int l, int r) {
        if (idx == STEP.size()) {
            return 0;
        }

        if (dp[idx][l][r] != 0) {
            return dp[idx][l][r];
        }

        int nxt = STEP.get(idx);
        dp[idx][l][r] = Math.min(search(idx + 1, nxt, r) + COST[l][nxt], search(idx + 1, l, nxt) + COST[r][nxt]);

        return dp[idx][l][r];
    }

    private static void setCost() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    COST[i][j] = 1;
                    continue;
                }
                if (j == 0) {
                    continue;
                }
                if (i == 0) {
                    COST[i][j] = 2;
                } else {
                    if (Math.abs(i - j) == 2) {
                        COST[i][j] = 4;
                    } else {
                        COST[i][j] = 3;
                    }
                }
            }
        }
    }
}
