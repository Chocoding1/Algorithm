import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1197 {

    private static int[] uf;
    private static final PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        uf = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            uf[i] = i;
        }

        int edgeCnt = 0;
        int minValue = 0;
        while (edgeCnt < V - 1) {
            int[] edge = queue.poll();

            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                minValue += edge[2];
                edgeCnt++;
            }
        }

        System.out.println(minValue);

    }

    private static int find(int v) {
        if (v == uf[v]) {
            return v;
        }

        uf[v] = find(uf[v]);

        return uf[v];
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        uf[Math.max(v1, v2)] = Math.min(v1, v2);
    }
}
