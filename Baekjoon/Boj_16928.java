import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928 {

    private static HashMap<Integer, Integer> shortcuts = new HashMap<>();
    private static boolean[] visited = new boolean[101];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            shortcuts.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bfs(1, 0);
    }

    private static void bfs(int idx, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{idx, cnt});
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int curIdx = curNode[0];
            int curCnt = curNode[1];
            if (curIdx == 100) {
                System.out.println(curCnt);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int nxtIdx = curIdx + i;
                if (nxtIdx > 100) {
                    break;
                }

                if (shortcuts.containsKey(nxtIdx)) {
                    nxtIdx = shortcuts.get(nxtIdx);
                }

                if (!visited[nxtIdx]) {
                    queue.offer(new int[]{nxtIdx, curCnt + 1});
                    visited[nxtIdx] = true;
                }
            }
        }
    }
}
