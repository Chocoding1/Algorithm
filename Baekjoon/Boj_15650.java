import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15650 {

    private static int[] num;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            num[i] = i;
        }

        dfs(1, 1, "1");
        dfs(1, 0, "");

        System.out.println(sb);
    }

    private static void dfs(int idx, int n, String seq) {
        if (n == M) {
            for (char s : seq.toCharArray()) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        if (idx == N) {
            return;
        }

        dfs(idx + 1, n + 1, seq + (idx + 1));
        dfs(idx + 1, n, seq);
    }
}
