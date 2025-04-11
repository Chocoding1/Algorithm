import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630 {

    private static int[][] paper;
    private static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N, paper[0][0]);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static void dfs(int startI, int startJ, int n, int color) {

        for (int i = startI; i < startI + n; i++) {
            for (int j = startJ; j < startJ + n; j++) {
                if (paper[i][j] != color) {
                    dfs(startI, startJ, n / 2, paper[startI][startJ]);
                    dfs(startI, startJ + n / 2, n / 2, paper[startI][startJ + n / 2]);
                    dfs(startI + n / 2, startJ, n / 2, paper[startI + n / 2][startJ]);
                    dfs(startI + n / 2, startJ + n / 2, n / 2, paper[startI + n / 2][startJ + n / 2]);
                    return;
                }
            }
        }
        result[color]++;
    }
}
