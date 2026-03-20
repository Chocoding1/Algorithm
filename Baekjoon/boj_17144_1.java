import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17144_1 {

    private static int R, C;
    private static int purifierUpRow, purifierDownRow;
    private static int[][] A, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        A = new int[R][C];
        temp = new int[R][C];

        boolean isDown = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());

                if (A[i][j] == -1) {
                    if (isDown) {
                        purifierDownRow = i;
                        continue;
                    }
                    purifierUpRow = i;
                    isDown = true;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            rotation();
        }
        System.out.println(sumDust());
    }

    private static void spread() {
        int[][] coords = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        initialTemp();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] >= 5) {
                    int spreadUnit = A[i][j] / 5;
                    int spreadCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nxtI = i + coords[k][0];
                        int nxtJ = j + coords[k][1];
                        if (0 <= nxtI && nxtI < R && 0 <= nxtJ && nxtJ < C && A[nxtI][nxtJ] != -1) {
                            spreadCount++;
                            temp[nxtI][nxtJ] += spreadUnit;
                        }
                    }
                    A[i][j] -= spreadUnit * spreadCount;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] += temp[i][j];
            }
        }
    }

    private static void initialTemp() {
        for (int i = 0; i < R; i++) {
            Arrays.fill(temp[i], 0);
        }
    }

    private static void rotation() {
        copyA();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == -1) {
                    temp[i][j + 1] = 0;
                    continue;
                }

                if (i <= purifierUpRow) {
                    if (i == 0) {
                        if (j == 0) {
                            temp[i + 1][j] = A[i][j];
                            continue;
                        }
                        temp[i][j - 1] = A[i][j];
                        continue;
                    }

                    if (i == purifierUpRow) {
                        if (j == C - 1) {
                            temp[i - 1][j] = A[i][j];
                            continue;
                        }
                        temp[i][j + 1] = A[i][j];
                        continue;
                    }

                    if (j == 0) {
                        temp[i + 1][j] = A[i][j];
                        continue;
                    }
                    if (j == C - 1) {
                        temp[i - 1][j] = A[i][j];
                        continue;
                    }
                    temp[i][j] = A[i][j];
                }

                if (i >= purifierDownRow) {
                    if (i == purifierDownRow) {
                        if (j == C - 1) {
                            temp[i + 1][j] = A[i][j];
                            continue;
                        }
                        temp[i][j + 1] = A[i][j];
                        continue;
                    }

                    if (i == R - 1) {
                        if (j == 0) {
                            temp[i - 1][j] = A[i][j];
                            continue;
                        }
                        temp[i][j - 1] = A[i][j];
                        continue;
                    }

                    if (j == 0) {
                        temp[i - 1][j] = A[i][j];
                        continue;
                    }
                    if (j == C - 1) {
                        temp[i + 1][j] = A[i][j];
                        continue;
                    }
                    temp[i][j] = A[i][j];
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == -1) {
                    continue;
                }
                A[i][j] = temp[i][j];
            }
        }
    }

    private static void copyA() {
        for (int i = 0; i < R; i++) {
            temp[i] = A[i].clone();
        }
    }

    private static int sumDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == -1) {
                    continue;
                }
                sum += A[i][j];
            }
        }
        return sum;
    }
}
