import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20040 {

    private static int n, m;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if (find(v1) == find(v2)) {
                System.out.println(i);
                return;
            }

            union(v1, v2);
        }

        System.out.println(0);
    }

    private static int find(int v) {
        if (v == parent[v]) {
            return v;
        }

        parent[v] = find(parent[v]);
        return parent[v];
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        parent[Math.max(v1, v2)] = Math.min(v1, v2);
    }
}
