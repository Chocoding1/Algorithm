import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] heiwei = new int[N][3];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            heiwei[i][0] = Integer.parseInt(st.nextToken());
            heiwei[i][1] = Integer.parseInt(st.nextToken());
            heiwei[i][2] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                if (heiwei[i][0] < heiwei[j][0] && heiwei[i][1] < heiwei[j][1]) {
                    heiwei[i][2]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(heiwei[i][2]).append(" ");
        }

        System.out.println(sb);
    }
}
