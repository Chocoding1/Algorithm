import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9663 {

    private static int N;
    private static int[] col;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        col = new int[N];

        putQueen(0); // 0번째 열부터 퀸 놓기

        System.out.println(result);
    }

    private static void putQueen(int colIdx) {

        if (colIdx == N) {
            result++;
            return;
        }

        // 현재 열에 각 행마다 퀸을 놓아보기
        for (int i = 0; i < N; i++) {
            col[colIdx] = i;

            if (isPossible(colIdx)) { // 현재 열의 특정 행에 퀸을 놓고 해당 위치에 퀸을 놓아도 되는지 체크
                putQueen(colIdx + 1); // 퀸을 놓아도 되면 다음 열로 넘어가서 다음 퀸 놓기
            }
        }
    }

    private static boolean isPossible(int colIdx) {

        for (int i = 0; i < colIdx; i++) { // 왼쪽 열부터 순서대로 퀸을 놓을 것이기 때문에 탐색은 0번째 열부터 현재 열 전까지만 탐색
            // 이전 열과 같은 행에 퀸이 놓여져 있으면 퀸 놓을 수 없음
            if (col[colIdx] == col[i]) {
                return false;
            }

            // 이전 열에 놓여졌던 퀸의 대각선 위치에 현재 놓은 퀸이 놓여진 경우, 퀸 놓을 수 없음
            if (colIdx - i == Math.abs(col[colIdx] - col[i])) { // 두 퀸이 놓여진 위치의 열의 차와 행의 차가 같으면 대각선 위치에 존재하는 것
                return false;
            }
        }

        return true;
    }
}
