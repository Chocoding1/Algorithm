import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int score;
        int totalScore;

        for (int t = 0; t < T; t++) {
            score = 0;
            totalScore = 0;

            char[] quizResult = br.readLine().toCharArray();
            for (char result : quizResult) {
                if (result == 'O') {
                    totalScore += ++score;
                } else {
                    score = 0;
                }
            }

            System.out.println(totalScore);
        }
    }
}
