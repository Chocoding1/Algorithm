import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 참고 링크 : https://yuu5666.tistory.com/186
 */
public class Boj_27172 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] players = new int[N];
        int[] scores = new int[1000001];
        boolean[] isExist = new boolean[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            players[i] = Integer.parseInt(st.nextToken());
            isExist[players[i]] = true;
        }

        for (int player : players) {
            for (int i = player * 2; i < 1000001; i += player) {
                if (isExist[i]) {
                    scores[player]++;
                    scores[i]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(scores[players[i]]).append(" ");
        }
        System.out.println(sb);
    }
}
