import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2623 {

    private static int N;
    private static List<Integer>[] order;
    private static int[] indegree;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        order = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            order[i] = new ArrayList<>();
        }

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int e = Integer.parseInt(st.nextToken());
                order[s].add(e);
                indegree[e]++;
                s = e;
            }
        }

        int cnt = topologySort();

        if (cnt != N) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

    private static int topologySort() {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            sb.append(cur).append("\n");
            cnt++;

            for (Integer nxt : order[cur]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    queue.offer(nxt);
                }
            }
        }

        return cnt;
    }
}
