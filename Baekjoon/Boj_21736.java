import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_21736 {

    private static char[][] campus;
    private static int N;
    private static int M;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];

        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (campus[i][j] == 'I') {
                    bfs(i, j);
                    if (result == 0) {
                        System.out.println("TT");
                    } else {
                        System.out.println(result);
                    }
                    return;
                }
            }
        }

    }

    private static void bfs(int i, int j) {
        int[][] coord = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});
        campus[i][j] = 'X';

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nxtI = curPos[0] + coord[k][0];
                int nxtJ = curPos[1] + coord[k][1];

                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < M) {
                    if (campus[nxtI][nxtJ] == 'X') {
                        continue;
                    }
                    queue.offer(new int[]{nxtI, nxtJ});
                    if (campus[nxtI][nxtJ] == 'P') {
                        result++;
                    }
                    campus[nxtI][nxtJ] = 'X';
                }
            }
        }
    }
}
