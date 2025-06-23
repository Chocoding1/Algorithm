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
        if (endI == N - 1 && endJ == N - 1) { // 목표 지점 (N, N)에 도달했으면 결과값 + 1하고 리턴
            res++;
            return;
        }

        if (!isPossible(startI, startJ, endI, endJ)) { // 현재 놓은 파이프의 위치가 유효한지 체크(파이프가 범위를 넘지 않는지, 벽에 놓지는 않았는지)
            return; // 유효하지 않으면 리턴
        }

        if (isHoriz(startI, endI)) { // 가로
            dfs(endI, endJ, endI, endJ + 1); // 가로로 밀기
            dfs(endI, endJ, endI + 1, endJ + 1); // 대각선으로 밀기
        } else if (isVerti(startJ, endJ)) { // 세로
            dfs(endI, endJ, endI + 1, endJ + 1); // 대각선으로 밀기
            dfs(endI, endJ, endI + 1, endJ); // 세로로 밀기
        } else { // 대각선
            dfs(endI, endJ, endI, endJ + 1); // 가로로 밀기
            dfs(endI, endJ, endI + 1, endJ + 1); // 대각선으로 밀기
            dfs(endI, endJ, endI + 1, endJ); // 세로로 밀기
        }
    }

    private static boolean isPossible(int startI, int startJ, int endI, int endJ) {
        if (endI >= N || endJ >= N) { // 범위 체크
            return false;
        }

        // 현재 파이프 위치에 벽이 있는지 체크
        if (isHoriz(startI, endI) || isVerti(startJ, endJ)) { // 가로 or 세로
            return home[endI][endJ] == 0;
        } else { // 대각선
            return home[endI][endJ] == 0 && home[endI - 1][endJ] == 0 && home[endI][endJ - 1] == 0;
        }
    }

    // 현재 파이프가 가로 상태인지 체크
    private static boolean isHoriz(int startI, int endI) {
        return startI == endI;
    }

    // 현재 파이프가 세로 상태인지 체크
    private static boolean isVerti(int startJ, int endJ) {
        return startJ == endJ;
    }
}
