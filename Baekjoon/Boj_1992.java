import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1992 {

    private static int N;
    private static int[][] video;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] videoCells = bufferedReader.readLine().split("");
            for (int j = 0; j < N; j++) {
                video[i][j] = Integer.parseInt(videoCells[j]);
            }
        }

        compression(N, 0, 0);
        System.out.println(STRING_BUILDER);
    }

    private static void compression(int currentN, int startI, int startJ) {
        if (currentN == 1) {
            STRING_BUILDER.append(video[startI][startJ]);
            return;
        }

        int standardVideo = video[startI][startJ];
        for (int i = startI; i < startI + currentN; i++) {
            for (int j = startJ; j < startJ + currentN; j++) {
                if (standardVideo != video[i][j]) {
                    STRING_BUILDER.append("(");
                    int nextN = currentN / 2;
                    compression(nextN, startI, startJ);
                    compression(nextN, startI, startJ + nextN);
                    compression(nextN, startI + nextN, startJ);
                    compression(nextN, startI + nextN, startJ + nextN);
                    STRING_BUILDER.append(")");
                    return;
                }
            }
        }
        STRING_BUILDER.append(standardVideo);
    }
}
