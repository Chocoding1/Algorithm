import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500 {

    private static int N, M;
    private static int[][] paper;
    private static boolean[][] visited;
    private static int maxResult = 0;
    private static int[] di = {0, 1, 0, -1};
    private static int[] dj = {1, 0, -1, 0};
    private static int[][] coord = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, paper[i][j], 1);
            }
        }
        System.out.println(maxResult);
    }

    private static void dfs(int i, int j, int sum, int n) {
        if (n == 4) {
            maxResult = Math.max(maxResult, sum);
            return;
        }
        visited[i][j] = true;

        if (n == 2) {
            for (int k = 0; k < 4; k++) {
                int nxtI1 = i + coord[k % 4][0];
                int nxtJ1 = j + coord[k % 4][1];

                int nxtI2 = i + coord[(k + 1) % 4][0];
                int nxtJ2 = j + coord[(k + 1) % 4][1];

                if (0 <= nxtI1 && nxtI1 < N && 0 <= nxtJ1 && nxtJ1 < M && 0 <= nxtI2 && nxtI2 < N && 0 <= nxtJ2 && nxtJ2 < M) {
                    if (!visited[nxtI1][nxtJ1] && !visited[nxtI2][nxtJ2]) {
                        maxResult = Math.max(maxResult, sum + paper[nxtI1][nxtJ1] + paper[nxtI2][nxtJ2]);
                    }
                }
            }
        }

        for (int k = 0; k < 4; k++) {
            int nxtI = i + di[k];
            int nxtJ = j + dj[k];
            if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < M && !visited[nxtI][nxtJ]) {
                dfs(nxtI, nxtJ, sum + paper[nxtI][nxtJ], n + 1);
            }
        }

        visited[i][j] = false;
    }
}
