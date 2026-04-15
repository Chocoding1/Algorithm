import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2448 {

    private static int N;
    private static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        star = new char[N][2 * N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        printStar(N, 0, N - 1);
        for (int i = 0; i < N; i++) {
            System.out.println(star[i]);
        }
    }

    private static void printStar(int curN, int startI, int startJ) {
        if (curN == 3) {
            star[startI][startJ] = '*';
            star[startI + 1][startJ - 1] = star[startI + 1][startJ + 1] = '*';
            for (int j = startJ - 2; j <= startJ + 2; j++) {
                star[startI + 2][j] = '*';
            }
            return;
        }

        int nextN = curN / 2;
        printStar(nextN, startI, startJ);
        printStar(nextN, startI + nextN, startJ - nextN);
        printStar(nextN, startI + nextN, startJ + nextN);
    }
}
