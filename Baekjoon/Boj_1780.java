import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780 {

    private static int N;
    private static int[][] paper;
    private static final int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        recursion(N, 0, 0);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    private static void recursion(int currentSize, int startI, int startJ) {
        int startNumber = paper[startI][startJ];
        for (int i = startI; i < startI + currentSize; i++) {
            for (int j = startJ; j < startJ + currentSize; j++) {
                if (startNumber != paper[i][j]) {
                    int nextSize = currentSize / 3;
                    recursion(nextSize, startI, startJ);
                    recursion(nextSize, startI, startJ + nextSize);
                    recursion(nextSize, startI, startJ + nextSize * 2);
                    recursion(nextSize, startI + nextSize, startJ);
                    recursion(nextSize, startI + nextSize, startJ + nextSize);
                    recursion(nextSize, startI + nextSize, startJ + nextSize * 2);
                    recursion(nextSize, startI + nextSize * 2, startJ);
                    recursion(nextSize, startI + nextSize * 2, startJ + nextSize);
                    recursion(nextSize, startI + nextSize * 2, startJ + nextSize * 2);
                    return;
                }
            }
        }
        result[startNumber + 1]++;
    }
}
