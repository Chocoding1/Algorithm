import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15666 {

    private static int N, M;
    private static int[] arr, seq;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int baseIdx, int n) {
        if (n == M) {
            for (int i : seq) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastNum = 0;
        for (int i = baseIdx; i < N; i++) {
            if (lastNum == arr[i]) {
                continue;
            }

            seq[n] = arr[i];
            lastNum = arr[i];
            dfs(i, n + 1);
        }
    }
}
