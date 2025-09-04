import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Boj_1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] list = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                list[i] = new ArrayList<>();
            }
            int[] order = new int[N + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                list[X].add(Y);
                order[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            int[] dp = new int[N + 1];
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i < N + 1; i++) {
                if (order[i] == 0) {
                    queue.offer(i);
                    dp[i] = D[i];
                }
            }

            while (true) {
                Integer cur = queue.poll();
                if (cur == W) {
                    System.out.println(dp[W]);
                    break;
                }

                for (Integer nxt : list[cur]) {
                    dp[nxt] = Math.max(dp[nxt], dp[cur] + D[nxt]);
                    if (--order[nxt] == 0) {
                        queue.offer(nxt);
                    }
                }
            }
        }
    }
}
