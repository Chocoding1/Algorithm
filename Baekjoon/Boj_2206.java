import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 해설 : https://iseunghan.tistory.com/316#google_vignette
 */
public class Boj_2206 {

    private static int N, M;
    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i <N; i++) {
            int[] array = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = array[j];
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, 0)); // i, j, dist, isCrashed
        visited[0][0][0] = true;

        int result = -1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.i == N - 1 && cur.j == M - 1) {
                result = cur.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nxtI = cur.i + di[i];
                int nxtJ = cur.j + dj[i];
                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < M) {
                    if (map[nxtI][nxtJ] == 0) {
                        if (!visited[nxtI][nxtJ][cur.isCrashed]) {
                            queue.offer(new Node(nxtI, nxtJ, cur.dist + 1, cur.isCrashed));
                            visited[nxtI][nxtJ][cur.isCrashed] = true;
                        }
                    } else {
                        if (cur.isCrashed == 0) {
                            queue.offer(new Node(nxtI, nxtJ, cur.dist + 1, 1));
                            visited[nxtI][nxtJ][1] = true;
                        }
                    }
                }
            }
        }

        return result;
    }

    private static class Node {
        private int i;
        private int j;
        private int dist;
        private int isCrashed; // 벽을 한 번이라도 부쉈는지 아닌지 체크. 0 : 부순 적 없음, 1 : 부신 적 있음

        public Node(int i, int j, int dist, int isCrashed) {
            this.i = i;
            this.j = j;
            this.dist = dist;
            this.isCrashed = isCrashed;
        }
    }
}
