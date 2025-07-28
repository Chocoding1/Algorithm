import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges.add(new int[]{S, E, T});
                edges.add(new int[]{E, S, T});
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges.add(new int[]{S, E, -T});
            }

            int[] time = new int[N + 1];
            Arrays.fill(time, 2000000000); // 이를 Integer.MAX_VALUE로 하게 되면, 시간을 더할 경우 아예 다른 값이 나오기 때문에
            time[1] = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int[] edge : edges) {
                    int s = edge[0];
                    int e = edge[1];
                    int t = edge[2];

                    if (time[e] > time[s] + t) {
                        time[e] = time[s] + t;
                    }
                }
            }

            boolean flag = false;
            for (int[] edge : edges) {
                int s = edge[0];
                int e = edge[1];
                int t = edge[2];

                if (time[e] > time[s] + t) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
