import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2447 {

    private static int N;
    private static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        star = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        recursion(N, 0, 0);

        printStar();
    }

    private static void recursion(int currentN, int startI, int startJ) {
        if (currentN == 1) {
            star[startI][startJ] = '*';
            return;
        }

        int nextN = currentN / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                recursion(nextN, startI + (nextN * i), startJ + (nextN * j));
            }
        }
    }

    private static void printStar() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
                stringBuilder.append(star[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
