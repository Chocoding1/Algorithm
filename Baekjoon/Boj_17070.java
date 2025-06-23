import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17070 {

    private static int N;
    private static int[][] home;
    private static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        home = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 1);

        System.out.println(res);
    }

    private static void dfs(int startI, int startJ, int endI, int endJ) {
        if (endI == N - 1 && endJ == N - 1) {
            res++;
            return;
        }
        
        if (!isPossible(startI, startJ, endI, endJ)) {
            return;
        }

        if (isHoriz(startI, endI)) { // 가로
            dfs(endI, endJ, endI, endJ + 1);
            dfs(endI, endJ, endI + 1, endJ + 1);
        } else if (isVerti(startJ, endJ)) { // 세로
            dfs(endI, endJ, endI + 1, endJ + 1);
            dfs(endI, endJ, endI + 1, endJ);
        } else { // 대각선
            dfs(endI, endJ, endI, endJ + 1);
            dfs(endI, endJ, endI + 1, endJ + 1);
            dfs(endI, endJ, endI + 1, endJ);
        }
    }

    private static boolean isPossible(int startI, int startJ, int endI, int endJ) {
        if (endI >= N || endJ >= N) {
            return false;
        }
        if (isHoriz(startI, endI)) {
            return home[endI][endJ] == 0;
        } else if (isVerti(startJ, endJ)) {
            return home[endI][endJ] == 0;
        } else {
            return home[endI][endJ] == 0 && home[endI - 1][endJ] == 0 && home[endI][endJ - 1] == 0;
        }
    }

    private static boolean isHoriz(int startI, int endI) {
        return startI == endI;
    }

    private static boolean isVerti(int startJ, int endJ) {
        return startJ == endJ;
    }
}
