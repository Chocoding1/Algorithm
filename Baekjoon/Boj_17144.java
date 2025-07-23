import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 필요한 변수 : R, C, T, A, 간이 A(모든 칸의 미세먼지가 동시에 확장하지만 계산은 순서대로 진행되기 때문에 앞선 방의 계산이 뒤에 계산되는 방에 영향을 주지 않도록 따로 저장해놓기 위한 변수), 공기청정기가 존재하는 행(윗 행, 아래 행)
 *
 * 풀이과정
 * 1. 변수 초기화
 * 2. T번 반복
 * 3. 모든 칸을 돌면서 미세먼지가 있으면 미세먼지 확산 계산 (계산한 값은 간이 A에 저장. 위에서 말했듯이 원래의 값이 바뀌면 안 됨)
 * 4. 모든 칸을 돌면서 원본 A와 간이 A의 칸들의 값을 더함 (이건 직접 해보면서 알아낸 계산법)
 * 5. 모든 칸을 돌며 공기청정기의 순환 경로에 존재하는 칸들은 이동 (위치에 따라 다르게 이동시키는 것이 point)
 *    이것 또한 간이 A에 저장(원본 값들이 손실되면 안 되기 때문) 후, 원본 A에 깊은 복사
 */
class Boj_17144 {

    private static int R, C, T;
    private static int[][] A;
    private static int[][] tempA;
    private static int cleanRUp, cleanRDown;// 공기청정기가 있는 두 행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        A = new int[R][C];
        tempA = new int[R][C];

        boolean flag = true; // 공기청정기 행 체크용
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1 && flag) {
                    cleanRUp = i;
                    cleanRDown = i + 1;
                    flag = false;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            dustDiffusion(); // 미세먼지 확산
            purification(); // 공기청정기 정화
        }
        System.out.println(checkDust()); // 최종 미세먼지 양 계산
    }

    private static void dustDiffusion() {
        tempAInitialize(); // 임시 방 리스트 초기화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == 0 || A[i][j] == -1) {
                    continue;
                }
                diffusion(i, j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == -1) {
                    continue;
                }

                A[i][j] += tempA[i][j];
            }
        }
    }

    private static void diffusion(int i, int j) {
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};

        int diffDust = A[i][j] / 5;
        if (diffDust == 0) {
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nxtI = i + di[k];
            int nxtJ = j + dj[k];
            int cnt = 0;
            if (0 <= nxtI && nxtI < R && 0 <= nxtJ && nxtJ < C && A[nxtI][nxtJ] != -1) {
                cnt++;
                tempA[nxtI][nxtJ] += diffDust;
            }
            tempA[i][j] += -(diffDust * cnt);
        }
    }

    private static void purification() {
        tempAInitialize(); // 임시 방 리스트 초기화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == 0 || A[i][j] == -1) {
                    continue;
                }

                if (j == 0) {
                    if (i < cleanRUp) {
                        tempA[i + 1][j] = A[i][j];
                    } else if (i > cleanRDown) {
                        tempA[i - 1][j] = A[i][j];
                    }
                } else if (j == C - 1) {
                    if (i == 0 || i == R - 1) {
                        tempA[i][j - 1] = A[i][j];
                    } else if (i <= cleanRUp) {
                        tempA[i - 1][j] = A[i][j];
                    } else if (i >= cleanRDown) {
                        tempA[i + 1][j] = A[i][j];
                    }
                } else {
                    if (i == 0 || i == R - 1) {
                        tempA[i][j - 1] = A[i][j];
                    } else if (i == cleanRUp || i == cleanRDown) {
                        tempA[i][j + 1] = A[i][j];
                    } else {
                        tempA[i][j] = A[i][j];
                    }
                }
            }
        }

        tempA[cleanRUp][0] = -1;
        tempA[cleanRDown][0] = -1;

        for (int i = 0; i < R; i++) {
            A[i] = tempA[i].clone();
        }
    }

    private static void tempAInitialize() {
        for (int i = 0; i < R; i++) {
            Arrays.fill(tempA[i], 0);
        }
    }

    private static int checkDust() {
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == -1) {
                    continue;
                }

                result += A[i][j];
            }
        }

        return result;
    }
}
