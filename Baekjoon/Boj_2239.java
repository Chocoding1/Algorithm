import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2239 {

    private static List<int[]> zeros = new ArrayList<>();
    private static int[][] sdoku = new int[9][9];
    private static boolean end = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String row = br.readLine();
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = row.charAt(j) - '0';
                if (sdoku[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }
        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sdoku[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx) {
        if (idx == zeros.size()) {
            end = true;
            return;
        }

        int curI = zeros.get(idx)[0];
        int curJ = zeros.get(idx)[1];

        for (int num = 1; num <= 9; num++) {
            if (!isValid(curI, curJ, num)) continue;

            sdoku[curI][curJ] = num;

            dfs(idx + 1);

            if (end) return;

            sdoku[curI][curJ] = 0;
        }
    }

    private static boolean isValid(int curI, int curJ, int num) {
        for (int i = 0; i < 9; i++) {
            if (sdoku[curI][i] == num || sdoku[i][curJ] == num) {
                return false;
            }
        }

        int startI = 3 * (curI / 3);
        int startJ = 3 * (curJ / 3);
        for (int i = startI; i <= startI + 2; i++) {
            for (int j = startJ; j <= startJ + 2; j++) {
                if (sdoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
