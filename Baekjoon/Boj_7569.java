import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {

    private static int M, N, H;
    private static int allTmtCnt = 0; // 전체 토마토 개수
    private static int oneTmtCnt = 0; // 익은 토마토 개수
    private static int zeroTmtCnt = 0; // 안 익은 토마토 개수
    private static int[][][] boxes;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        boxes = new int[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    boxes[k][i][j] = Integer.parseInt(st.nextToken());
                    if (boxes[k][i][j] != -1) {
                        allTmtCnt++;
                        if (boxes[k][i][j] == 0) {
                            zeroTmtCnt++;
                        } else {
                            oneTmtCnt++;
                            queue.offer(new int[]{k, i, j, 0});
                        }
                    }
                }
            }
        }

        if (allTmtCnt == oneTmtCnt) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int result = 0;
        int[] dk = {-1, 1, 0, 0, 0, 0};
        int[] di = {0, 0, 0, 1, 0, -1};
        int[] dj = {0, 0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] curTmt = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nxtK = curTmt[0] + dk[i];
                int nxtI = curTmt[1] + di[i];
                int nxtJ = curTmt[2] + dj[i];

                if (0 <= nxtK && nxtK < H && 0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < M) {
                    if (boxes[nxtK][nxtI][nxtJ] == 0) {
                        boxes[nxtK][nxtI][nxtJ] = curTmt[3] + 1;
                        queue.offer(new int[]{nxtK, nxtI, nxtJ, curTmt[3] + 1});
                        zeroTmtCnt--;
                        result = Math.max(result, curTmt[3] + 1);
                    }
                }
            }
        }

        if (zeroTmtCnt > 0) {
            result = -1;
        }

        return result;
    }
}
