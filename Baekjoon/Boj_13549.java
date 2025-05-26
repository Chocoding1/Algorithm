import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13549 {

    private static int N, K;
    private static final boolean[] visited = new boolean[100001];
    private static int resultTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs();

        System.out.println(resultTime);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curX = curPos[0];
            int curTime = curPos[1];

            int nxtX, nxtTime;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nxtX = curX * 2;
                    nxtTime = curTime;
                } else if (i == 1) {
                    nxtX = curX - 1;
                    nxtTime = curTime + 1;
                } else {
                    nxtX = curX + 1;
                    nxtTime = curTime + 1;
                }

                if (nxtX == K) {
                    resultTime = nxtTime;
                    return;
                }

                if (0 <= nxtX && nxtX <= 100000 && !visited[nxtX]) {
                    queue.offer(new int[]{nxtX, nxtTime});
                    visited[nxtX] = true;
                }
            }
        }
    }
}
