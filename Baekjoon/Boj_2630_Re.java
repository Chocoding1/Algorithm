import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630_Re {

    private static int N;
    private static int[][] paper;
    private static final int[] paperCount = new int[2];

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

        System.out.println(paperCount[0]);
        System.out.println(paperCount[1]);
    }

    private static void recursion(int currentN, int startI, int startJ) {
        if (currentN == 1) {
            paperCount[paper[startI][startJ]]++;
            return;
        }

        int standardPaperColor = paper[startI][startJ];
        for (int i = startI; i < startI + currentN; i++) {
            for (int j = startJ; j < startJ + currentN; j++) {
                if (standardPaperColor != paper[i][j]) {
                    int nextN = currentN / 2;
                    recursion(nextN, startI, startJ);
                    recursion(nextN, startI, startJ + nextN);
                    recursion(nextN, startI + nextN, startJ);
                    recursion(nextN, startI + nextN, startJ + nextN);
                    return;
                }
            }
        }

        paperCount[standardPaperColor]++;
    }
}
