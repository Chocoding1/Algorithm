import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_15663 {

    private static int N, M;
    private static HashSet<String> history = new HashSet<>();
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, "");
        System.out.println(sb);
    }

    private static void dfs(int idx, String seq) {
        if (idx == M) {
            if (history.contains(seq)) {
                return;
            }
            history.add(seq);
            for (String s : seq.split(",")) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(idx + 1, seq + arr[i] + ",");
            visited[i] = false;
        }
    }
}
