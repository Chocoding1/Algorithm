import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012 {

    private static int[][] field;
    private static final int[][] coord = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int N;
    private static int M;
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                field[Y][X] = 1;
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1) {
//                        dfs(i, j);
                        bfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void bfs(int i, int j) {
        queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        field[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] curCoord = queue.poll();
            for (int k = 0; k < coord.length; k++) {
                int newI = curCoord[0] + coord[k][0];
                int newJ = curCoord[1] + coord[k][1];

                if (0 <= newI && newI < N && 0 <= newJ && newJ < M && field[newI][newJ] == 1) {
                    queue.offer(new int[]{newI, newJ});
                    field[newI][newJ] = 0;
                }
            }
        }
    }

    private static void dfs(int i, int j) {
        field[i][j] = 0;

        for (int k = 0; k < coord.length; k++) {
            int newI = i + coord[k][0];
            int newJ = j + coord[k][1];

            if (0 <= newI && newI < N && 0 <= newJ && newJ < M && field[newI][newJ] == 1) {
                dfs(newI, newJ);
            }
        }
    }
}
