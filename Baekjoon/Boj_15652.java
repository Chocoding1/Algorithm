import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15652 {

    private static int N, M;
    private static int[] seq;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int n) {
        if (n == M) {
            for (int num : seq) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            seq[n] = i;
            dfs(i, n + 1);
        }
    }
}
